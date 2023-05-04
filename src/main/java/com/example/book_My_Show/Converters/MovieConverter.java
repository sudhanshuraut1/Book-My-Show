package com.example.book_My_Show.Converters;

import com.example.book_My_Show.Entities.MovieEntity;
import com.example.book_My_Show.EntryDtos.MovieEntryDto;
import org.springframework.boot.context.metrics.buffering.StartupTimeline;

public class MovieConverter {
    public static MovieEntity convertEntryDtoToEntity(MovieEntryDto movieEntryDto){
  MovieEntity movieEntity = MovieEntity.builder().movieName(movieEntryDto.getMovieName()).duration(movieEntryDto.getDuration())
          .genre(movieEntryDto.getGenre()).language(movieEntryDto.getLanguage()).rating(movieEntryDto.getRating()).build();

  return movieEntity;
    }
}
