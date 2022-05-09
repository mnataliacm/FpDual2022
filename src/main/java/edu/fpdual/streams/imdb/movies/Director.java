package edu.fpdual.streams.imdb.movies;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Director {

  private int id;
  private String name;
  private String imdb;
  private List<Movie> movies;



}
