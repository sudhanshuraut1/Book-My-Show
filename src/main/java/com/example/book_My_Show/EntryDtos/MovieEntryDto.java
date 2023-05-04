package com.example.book_My_Show.EntryDtos;

import com.example.book_My_Show.Entities.ShowEntity;
import com.example.book_My_Show.Genres.Genre;
import com.example.book_My_Show.Genres.Language;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MovieEntryDto {
    private String movieName;

    private double rating;
    private int duration;

    private Language language;

    private Genre genre;
}
