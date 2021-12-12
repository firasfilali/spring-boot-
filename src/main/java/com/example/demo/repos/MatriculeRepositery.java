package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Matricule;

public interface MatriculeRepositery extends JpaRepository<Matricule, Integer> {

}
