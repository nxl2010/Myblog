package com.example.myblog.repository;

import com.example.myblog.enity.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuotesRepository extends JpaRepository<Quotes,Integer> {
    Optional<Quotes> findById(Integer id);
}
