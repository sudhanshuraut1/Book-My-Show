package com.example.book_My_Show.Converters;

import com.example.book_My_Show.Entities.TheatreEntity;
import com.example.book_My_Show.EntryDtos.TheatreEntryDto;

public class TheatreConverter {

    public static TheatreEntity convertDtotoEntity(TheatreEntryDto theatreEntryDto){
        return TheatreEntity.builder().location(theatreEntryDto.getAddress())
                .name(theatreEntryDto.getName()).build();


    }
}
