package com.example.demo.entities;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Data;

@Entity
@Data
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	private String title;

	private LocalDate creationDate;
	
	private LocalDate terminationDate;
	
	@ManyToMany
	@JoinTable(name = "have", joinColumns = @JoinColumn(name = "Project"), 
	inverseJoinColumns = @JoinColumn(name ="Employee"))
	private List<EmployeeEntity> employees;
}
