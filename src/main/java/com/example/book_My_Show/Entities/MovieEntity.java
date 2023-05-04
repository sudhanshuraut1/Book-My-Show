package com.example.book_My_Show.Entities;

import com.example.book_My_Show.Genres.Genre;
import com.example.book_My_Show.Genres.Language;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movies")
@Data
@Builder
@AllArgsConstructor
public class MovieEntity {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
@Column(unique = true,nullable = false)
private String movieName;

private double rating;
private int duration;
@Enumerated(value = EnumType.STRING)
private Language language;

@Enumerated(value = EnumType.STRING)
private Genre genre;

//parent wrt show
@OneToMany(mappedBy = "movieEntity",cascade = CascadeType.ALL)
    private List<ShowEntity> showEntityList = new ArrayList<>();



}
