package com.example.book_My_Show.Repositories;

import com.example.book_My_Show.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
}
