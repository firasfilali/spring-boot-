package com.example.demo.repos;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.EmployeeEntity;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Integer> {

	Optional<EmployeeEntity> findByName(String name);
	
	Optional<EmployeeEntity> findByNameIgnoreCase(String name);
	
	@Query(value = "select * from employee where dob >= :date", nativeQuery = true)
	List<EmployeeEntity> getAllEmpBornAfter(@Param ("date") LocalDate date);


}
