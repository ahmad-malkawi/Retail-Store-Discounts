package com.Store.Discounts.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Store.Discounts.Repository.EmployeeRepository;
import com.Store.Discounts.model.Employee;

@Service
public class EmployeeService {
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService (EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	} 
	
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee upDateEmployee (Employee employee) {
		return employeeRepository.save(employee);
	}
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee findEmployeeById(Long id) {
		return	employeeRepository.getById(id);	
	}
}
