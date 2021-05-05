package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Repository.EmployeeRepository;
import com.example.demo.controller.global.exception.EmptyInputException;
import com.example.demo.entity.Employee;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) {
		if(employee.getName().isEmpty() || employee.getName().length() ==0) {
			throw new EmptyInputException("601", "Input fields are empty");
		}
		Employee savedEmployee = employeeRepository.save(employee);
		return savedEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> empList = null;
		empList = employeeRepository.findAll();
		return empList;
	}

	@Override
	public Employee getEmpById(Long empidL) {
		
		return employeeRepository.findById(empidL).get();
	}

	@Override
	public void deleteEmpById(Long empidL) {
		employeeRepository.deleteById(empidL);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}

}
