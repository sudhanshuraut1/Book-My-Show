package com.example.book_My_Show.EntryDtos;

import com.example.book_My_Show.Genres.ShowType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowEntryDto {

    private LocalDate localDate;
    private LocalTime localTime;

    private ShowType showType;

    private int movieId;
     private int theatreId;
     private int classicSeatPrice;

     private int premiumSeatPrice;


}
