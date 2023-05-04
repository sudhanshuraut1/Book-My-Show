package com.example.book_My_Show.Repositories;

import com.example.book_My_Show.Entities.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository <MovieEntity,Integer> {

}
