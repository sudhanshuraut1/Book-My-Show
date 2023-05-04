package com.example.book_My_Show.Repositories;

import com.example.book_My_Show.Entities.TheatreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository <TheatreEntity,Integer> {
}
