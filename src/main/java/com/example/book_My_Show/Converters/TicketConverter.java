package com.example.book_My_Show.Converters;

import com.example.book_My_Show.Entities.TicketEntity;
import com.example.book_My_Show.EntryDtos.TicketEntryDto;

public class TicketConverter {

    public static TicketEntity convertEntryTOEntity(TicketEntryDto ticketEntryDto){

        TicketEntity ticketEntity = new TicketEntity();

        return ticketEntity;
    }
}
