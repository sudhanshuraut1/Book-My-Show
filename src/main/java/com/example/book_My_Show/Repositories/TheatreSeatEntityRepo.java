package com.example.book_My_Show.Repositories;

import com.example.book_My_Show.Entities.TheatreSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreSeatEntityRepo extends JpaRepository<TheatreSeatEntity,Integer> {
}
