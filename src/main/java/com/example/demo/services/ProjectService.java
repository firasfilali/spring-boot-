package com.example.demo.services;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.example.demo.entities.EmployeeEntity;
import com.example.demo.entities.Project;
import com.example.demo.repos.ProjectRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProjectService {

	private ProjectRepository projectRepositery;
	private EmployeeService employeeService;
	
	
	public Project addProject(Project project) {
		return projectRepositery.save(project);
	
	}
	
	public Project getOneProject(int idProject) {
		return projectRepositery.findById(idProject).orElseThrow(()-> new NoSuchElementException("No project found"));
		
	}
	
	public Project addEmployeeToAproject(int idProject, int idEmp) {
		EmployeeEntity employeeEntity = employeeService.getEmpById(idEmp);
		Project project = getOneProject(idProject);
		project.getEmployees().add(employeeEntity);
		return projectRepositery.save(project);
		
		
		
	}
}
