package com.example.book_My_Show.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "tickets")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;

    private int totalAmount;
     private String  tikcketId = UUID.randomUUID().toString();

     private String theatreName;

     private String  bookedSeats;

     @JoinColumn
    @ManyToOne
    private  UserEntity userEntity;

 //ticket is child wrt show Entity

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

}
