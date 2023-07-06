package com.example.EmployeeApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeApp.entities.Employee;
import com.example.EmployeeApp.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public Employee addEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	public Employee getEmployeeById(Integer id) {
		Optional<Employee> employee = repo.findById(id);
		if(employee.isPresent())
			return employee.get();
		return null;
	}

	public String updateEmployee(Employee employee) {
		Optional<Employee> result = repo.findById(employee.getId());
		if(result.isPresent()) {
			Employee data = result.get();
			Optional.ofNullable(employee.getFirstName()).ifPresent(data::setFirstName);
			Optional.ofNullable(employee.getLastName()).ifPresent(data::setLastName);
			Optional.ofNullable(employee.getEmail()).ifPresent(data::setEmail);
			Optional.ofNullable(employee.getDoj()).ifPresent(data::setDoj);
			repo.save(data);
			return "Employee record updated successfully";
		}
		else {
			return "Employee record not found";
		}
	}
	
	public String deleteEmployee(Integer id) {
		Optional<Employee> result = repo.findById(id);
		if(result.isPresent()) {
			repo.deleteById(id);
			return "Employee record deleted";
		}
		else {
			return "Record Not Found";
		}
	}
	
	public List<Employee> searchEmployees(String searchTerm) {
		int page = 1;
        int pageSize = 2;
		List<Employee> employees = repo.findAll();
        List<Employee> filteredEmployees = employees.stream()
                .filter(employee ->
                        String.valueOf(employee.getId()).equals(searchTerm) ||
                        employee.getFirstName().equalsIgnoreCase(searchTerm) ||
                        employee.getLastName().equalsIgnoreCase(searchTerm))
                .collect(Collectors.toList());

        int totalResults = filteredEmployees.size();
        int totalPages = (int) Math.ceil((double) totalResults / pageSize);

        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, totalResults);

        if (startIndex >= totalResults) {
            return new ArrayList<>(); // Empty list if page is out of range
        }

        return filteredEmployees.subList(startIndex, endIndex);
    }
}
