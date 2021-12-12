package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Admin;
import com.example.demo.entities.Matricule;
import com.example.demo.services.AdminService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/admins")
@AllArgsConstructor
public class AdminCtrl {
	
	private AdminService adminService;
	
	
	
	@PostMapping()
	public Admin SaveAdmin(@RequestBody Admin admin) {
		return adminService.saveAdminToDB(admin);
	}
	
	@GetMapping("/{id}")
	public Admin getOneAdmin(@PathVariable int id) {
		return adminService.getAdminById(id);
	}
	
	@PutMapping("/{id}/add/matricule")
	public Matricule AddMatricule(@PathVariable int id,@RequestBody Matricule matricule) {
		return adminService.addMatriculeToAdmin(id, matricule);
	}
	
	
	

}
