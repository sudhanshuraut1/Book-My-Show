package com.example.book_My_Show.EntryDtos;

import lombok.Data;

@Data
public class TheatreEntryDto {

     private String name;
    private String address;

    private int classicSeatsCount;

    private int premiumSeatsCount;

}
