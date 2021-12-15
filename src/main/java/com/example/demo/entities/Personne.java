package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int id;
	@Column(length = 60)
	private String name;


}
