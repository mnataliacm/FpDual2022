package edu.fpdual.streams.imdb.movies;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {

  private int id;
  private String title;
  private int year;
  private String imdb;
  private List<Genre> genres;
  private List<Director> directors;



}
