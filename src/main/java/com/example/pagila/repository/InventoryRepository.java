package com.example.pagila.repository;

import com.example.pagila.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Film,Integer> {
}
