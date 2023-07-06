package com.example.EmployeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeApp.entities.Employee;
import com.example.EmployeeApp.entities.SearchRequest;
import com.example.EmployeeApp.exception.EmployeeNotFoundException;
import com.example.EmployeeApp.repository.EmployeeRepository;
import com.example.EmployeeApp.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@Autowired
	private EmployeeRepository repo;

	@PostMapping("/createEmployee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
	}

	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable Integer id) {
		return service.getEmployeeById(id);
	}

	@PutMapping("/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		return service.updateEmployee(employee);
	}

	@DeleteMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		return service.deleteEmployee(id);
	}

	@GetMapping("/search")
	public List<Employee> searchEmployees(@RequestBody SearchRequest request) {
		if (request.getId() != null) {
			return repo.findById(request.getId()).map(List::of)
					.orElseThrow(() -> new EmployeeNotFoundException(request.getId()));
		} else if (request.getFirstName() != null) {
			return repo.findByFirstName(request.getFirstName());
		} else if (request.getLastName() != null) {
			return repo.findByLastName(request.getLastName());
		} else {
			return repo.findAll();
		}
	}

}
