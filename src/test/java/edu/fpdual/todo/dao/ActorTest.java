package edu.fpdual.todo.dao;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.matches;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActorTest {

  @Mock
  private ResultSet resultSet;

  @Test
  public void actorConstruction_ok() throws SQLException {
    Actor expectedActor = Actor.builder()
        .id(1000000)
        .firstName("Paco")
        .lastName("León")
        .build();
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

    Actor actualActor = new Actor(resultSet);
    MatcherAssert.assertThat(actualActor, Matchers.is(expectedActor));
  }
}