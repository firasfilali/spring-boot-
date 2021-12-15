package com.example.demo.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Project;
import com.example.demo.services.ProjectService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/projects")
public class ProjectCtrl {
	
private ProjectService projectService;

	@PostMapping
	public Project addProject(@RequestBody Project project) {
		return projectService.addProject(project);
	}
	
	@PutMapping("/{idProject}/add/{idEmp}") 
	public Project addEmpToProject(@PathVariable int idProject, @PathVariable int idEmp ) {
		return projectService.addEmployeeToAproject(idProject, idEmp);
	}
	
	
	
	
	
	

}
