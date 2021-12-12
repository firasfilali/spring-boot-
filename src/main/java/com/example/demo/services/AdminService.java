package com.example.demo.services;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Matricule;
import com.example.demo.repos.AdminRepository;
import com.example.demo.repos.MatriculeRepositery;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdminService {
	
	//add Admin
	private AdminRepository creatorRepo;
	private MatriculeRepositery matRepo;
	
	public Admin saveAdminToDB(Admin admin) {
		return creatorRepo.save(admin);
	}
	// get Admin 
	public Admin getAdminById(int id) {
		Optional<Admin> opt = creatorRepo.findById(id);
		return opt.orElseThrow(()-> new NoSuchElementException("Admin with this ID not found"));
	}
	//add Matricule to an admin
	
	public Matricule addMatriculeToAdmin(int idAdmin, Matricule matricule) {
		
		Admin admin = getAdminById(idAdmin);
		matricule.setCreator(admin);
		return matRepo.save(matricule);
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
