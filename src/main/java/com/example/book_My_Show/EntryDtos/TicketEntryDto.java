package com.example.book_My_Show.EntryDtos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TicketEntryDto {

    private int showId;
    private List<String > requestedSeats = new ArrayList<>();

    private int userID;


}
