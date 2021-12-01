package com.example.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entities.EmployeeEntity;
import com.example.demo.repos.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	private EmployeeRepository empRepos;
	
	public EmployeeEntity saveToDB(EmployeeEntity employeeEntity) {
		return empRepos.save(employeeEntity);
	}
	public List<EmployeeEntity> getAllEmployee(){
		return empRepos.findAll();
	}
	
	public EmployeeEntity getEmpById(int id) {
		Optional<EmployeeEntity> opt = empRepos.findById(id);
	//	if(opt.isPresent())
		//	return opt.get();
		//throw new NoSuchElementException("Employee with this ID not found");
	return opt.orElseThrow(()-> new NoSuchElementException("Employee with this ID not found"));
	}
	public EmployeeEntity getEmpByName(String name) {
		Optional<EmployeeEntity> opt = empRepos.findByNameIgnoreCase(name);
	return opt.orElseThrow(()-> new NoSuchElementException("Employee with this ID not found"));
	}
	public List<EmployeeEntity> getAllEmpBornAfter(LocalDate date){
		return empRepos.getAllEmpBornAfter(date);
	}
	//update
	public EmployeeEntity updateEmpById(int id, EmployeeEntity newEntity)
}
