package com.example.book_My_Show.Entities;

import com.example.book_My_Show.Genres.SeatType;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@Table(name = "showseats")
@NoArgsConstructor
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private boolean isBooked;
    private int price;//price of seat for that particular show

    private String seatNo;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    @Timestamp
    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;



}
