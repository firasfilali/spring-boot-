package com.example.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Admin extends Personne{
	
	
	
	@OneToMany(mappedBy = "creator")
	private List<Matricule> matricules = new ArrayList<>();

}
