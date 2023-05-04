package com.example.book_My_Show.Entities;

import com.example.book_My_Show.Genres.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "theatre_seats")
@Builder
@AllArgsConstructor
public class TheatreSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private String seatNo;

    @ManyToOne
    @JoinColumn
    private TheatreEntity theatreEntity;
}
