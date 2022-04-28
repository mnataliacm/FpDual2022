package edu.fpdual.todo.manager.implement;

import edu.fpdual.todo.connect.Connector;
import edu.fpdual.todo.dao.Actor;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActorManagerImplTest {

  @Mock
  private Connection connection;
  @Mock
  private Statement statement;
  @Mock
  private PreparedStatement preparedStatement;
  @Mock
  private ResultSet resultSet;

  @InjectMocks
  private ActorManagerImpl actorManager;

  @Test
  void todos_ok() throws SQLException {
    Actor expectedActor = Actor.builder()
        .id(1000000)
        .firstName("Paco")
        .lastName("León")
        .build();
    when(connection.createStatement()).thenReturn(statement);
    when(statement.executeQuery(any())).thenReturn(resultSet);
    when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

      private int counter = 0;

      @Override
      public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
        if(counter < 1){
          counter++;
          return true;
        } else {
          return false;
        }
      }
    });
    doReturn(expectedActor.getId()).when(resultSet).getInt(any());
    when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

      @Override
      public String answer(InvocationOnMock invocationOnMock) throws Throwable {

        if(invocationOnMock.getArgument(0).equals("actor_id")) {
          return String.valueOf(expectedActor.getId());
        } else if (invocationOnMock.getArgument(0).equals("first_name")) {
          return expectedActor.getFirstName();
        } else if (invocationOnMock.getArgument(0).equals("last_name")) {
          return expectedActor.getLastName();
        } else {
          return null;
        }
      }
    });

    List<Actor> actorSet = actorManager.todos(connection);
    MatcherAssert.assertThat(actorSet, Matchers.hasSize(1));
    MatcherAssert.assertThat(actorSet.iterator().next(), Matchers.is(expectedActor));

  }

  @Test
  void insertarActor_ok() throws SQLException {
    Actor expectedActor = Actor.builder()
        .id(1000000)
        .firstName("Paco")
        .lastName("León")
        .build();
    when(connection.prepareStatement(any())).thenReturn(preparedStatement);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    when(resultSet.next()).thenAnswer(new Answer<Boolean>() {
      private int counter = 0;
      @Override
      public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
        if(counter < 1){
          counter++;
          return true;
        } else {
          return false;
        }
      }
    });
  }

  /*@Test
  void cambiarActor_ok() throws SQLException {

    Actor expectedActor = Actor.builder()
        .firstName("Paco")
        .lastName("Leon")
        .id(10000000)
        .build();

    when(connection.prepareStatement(any())).thenReturn(preparedStatement);
    when(preparedStatement.executeQuery()).thenReturn(resultSet);
    when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

      private int counter = 0;

      @Override
      public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
        if(counter < 1){
          counter++;
          return true;
        } else {
          return false;
        }
      }
    });
    doReturn(expectedActor.getId()).when(resultSet).getInt(any());
    when(resultSet.getBigDecimal(any())).thenReturn(new BigDecimal(expectedActor.getPopulation()));
    when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

      @Override
      public String answer(InvocationOnMock invocationOnMock) throws Throwable {

        if(invocationOnMock.getArgument(0).equals("actor_id")) {
          return String.valueOf(expectedActor.getId());
        } else if (invocationOnMock.getArgument(0).equals("first_name")) {
          return expectedActor.getFirstName();
        } else if (invocationOnMock.getArgument(0).equals("last_name")) {
          return expectedActor.getLastName();
        } else {
          return null;
        }
      }
    });
    List<Actor> actorSet = actorManager.todos(connection);
    MatcherAssert.assertThat(actorSet, Matchers.hasSize(1));
    MatcherAssert.assertThat(actorSet.iterator().next(), Matchers.is(expectedActor));
  }*/

  /*@Test
  void borrarActor_ok() throws SQLException {
  Actor expectedActor = Actor.builder()
      .firstName("Paco")
      .lastName("Leon")
      .id(10000000)
      .build();

  when(connection.prepareStatement(any())).thenReturn(preparedStatement);
  when(preparedStatement.executeQuery()).thenReturn(resultSet);
  when(resultSet.next()).thenAnswer(new Answer<Boolean>() {

    private int counter = 0;

    @Override
    public Boolean answer(InvocationOnMock invocationOnMock) throws Throwable {
      if(counter < 1){
        counter++;
        return true;
      } else {
        return false;
      }
    }
  });
  doReturn(expectedActor.getId()).when(resultSet).getInt(any());
  when(resultSet.getBigDecimal(any())).thenReturn(new BigDecimal(expectedActor.getPopulation()));
  when(resultSet.getString(any())).thenAnswer(new Answer<String>() {

    @Override
    public String answer(InvocationOnMock invocationOnMock) throws Throwable {

      if(invocationOnMock.getArgument(0).equals("actor_id")) {
        return String.valueOf(expectedActor.getId());
      } else if (invocationOnMock.getArgument(0).equals("first_name")) {
        return expectedActor.getFirstName();
      } else if (invocationOnMock.getArgument(0).equals("last_name")) {
        return expectedActor.getLastName();
      } else {
        return null;
      }
    }
  });
  List<Actor> actorSet = actorManager.todos(connection);
    MatcherAssert.assertThat(actorSet, Matchers.hasSize(1));
    MatcherAssert.assertThat(actorSet.iterator().next(), Matchers.is(actorManager));
}*/

  @Test
  void todos_ko() throws SQLException {
    when(connection.createStatement()).thenThrow(new SQLException(""));
    List<Actor> actorList = actorManager.todos(connection);
    MatcherAssert.assertThat(actorList, Matchers.nullValue());
  }

  @Test
  void insertarActor_ko() throws SQLException {
    when(connection.prepareStatement(any())).thenThrow(new SQLException(""));
    List<Actor> actorList = actorManager.todos(connection);
    MatcherAssert.assertThat(actorList, Matchers.nullValue());
  }

  @Test
  void editarActor_ko() throws SQLException {
    when(connection.prepareStatement(any())).thenThrow(new SQLException(""));
    List<Actor> actorList = actorManager.todos(connection);
    MatcherAssert.assertThat(actorList, Matchers.nullValue());
  }

  @Test
  void borrarActor_ko() throws SQLException {
    when(connection.prepareStatement(any())).thenThrow(new SQLException(""));
    List<Actor> actorList = actorManager.todos(connection);
    MatcherAssert.assertThat(actorList, Matchers.nullValue());
  }
}