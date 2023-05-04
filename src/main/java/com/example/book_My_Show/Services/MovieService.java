package com.example.book_My_Show.Services;

import com.example.book_My_Show.Converters.MovieConverter;
import com.example.book_My_Show.Entities.MovieEntity;
import com.example.book_My_Show.EntryDtos.MovieEntryDto;
import com.example.book_My_Show.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
  @Autowired
  MovieRepository movieRepository;

  public String addMovie(MovieEntryDto movieEntryDto)throws Exception{

    MovieEntity movieEntity = MovieConverter.convertEntryDtoToEntity(movieEntryDto);

    movieRepository.save(movieEntity);

    return "movie Added successfully";
  }
}
