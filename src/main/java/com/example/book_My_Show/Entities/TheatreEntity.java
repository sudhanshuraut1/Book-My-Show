package com.example.book_My_Show.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = " theatres")
public class TheatreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;

    //this is parent class wrt theatreseats
    @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL)
    private List<TheatreSeatEntity> theatreSeatEntityList = new ArrayList<>();

     @OneToMany(mappedBy = "theatreEntity",cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();
}
