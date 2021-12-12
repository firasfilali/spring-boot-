package com.example.demo.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.Data;

@Entity
@Table(name = "employee")
@Data
public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	
	@Column(length = 60)
	private String name;
	
	@Column(length = 70, nullable = false, unique = true)
	private String email;

	private LocalDate dob;
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "matricule")
	private Matricule matricule;
	

}
