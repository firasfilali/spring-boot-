package com.example.demo.controllers;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.EmployeeEntity;
import com.example.demo.services.EmployeeService;

@RestController
public class EmployeeCtrl {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/employee/add")
	public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
		return empService.saveToDB(employeeEntity);
	}
	
	@GetMapping("/employee/get")
	public List<EmployeeEntity> getAllemp(){
		return empService.getAllEmployee();
	}
	
	@GetMapping("/employee/get/{id}")
	public EmployeeEntity getOneemp(@PathVariable int id){
		return empService.getEmpById(id);
	}
	
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNSEE(NoSuchElementException e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error in search : " + e.getMessage());
	}
	
}
