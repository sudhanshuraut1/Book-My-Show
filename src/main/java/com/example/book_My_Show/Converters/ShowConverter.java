package com.example.book_My_Show.Converters;

import com.example.book_My_Show.Entities.ShowEntity;
import com.example.book_My_Show.EntryDtos.ShowEntryDto;

public class ShowConverter {

  public static ShowEntity showDtoToEntity(ShowEntryDto showEntryDto){

      ShowEntity showEntity = ShowEntity.builder()
              .showDate(showEntryDto.getLocalDate()).showTime(showEntryDto.getLocalTime()).showType(showEntryDto.getShowType())
              .build();

      return  showEntity;
  }
}
