package com.example.book_My_Show.Repositories;

import com.example.book_My_Show.Entities.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}
