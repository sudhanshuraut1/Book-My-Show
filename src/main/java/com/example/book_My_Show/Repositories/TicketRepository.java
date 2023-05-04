package com.example.book_My_Show.Repositories;

import com.example.book_My_Show.Entities.TicketEntity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}
