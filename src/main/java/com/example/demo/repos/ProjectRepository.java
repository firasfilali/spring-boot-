package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer>{

}
