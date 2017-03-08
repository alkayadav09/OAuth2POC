package com.practice.SpringRestAPI.repository;

import java.util.List;

import com.practice.SpringRestAPI.model.Employee;

public interface IRepository {
	public List<Employee> getAllEmployees();
	
	public Employee getEmployee(int id);
	
	public Employee updateEmployee(Employee employee);
	
	public List<Employee> addEmployee(Employee employee);
	
	public void deleteEmployee(int id);
}
