package com.practice.SpringRestAPI.service;

import java.util.List;

import javax.ws.rs.PathParam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.SpringRestAPI.model.Employee;
import com.practice.SpringRestAPI.repository.EmployeeRepo;
/*
	This service class perform the GET, POST, PUT and DELETE of the Rest API 
*/
@Controller
@RequestMapping(value="/employees")
public class EmployeeService {

	EmployeeRepo empRepo = new EmployeeRepo();
	
	@RequestMapping(method=RequestMethod.GET , headers="Accept=application/json" , produces={"application/json"})
	@ResponseBody
	public List<Employee> getAllEmployees(){
		return empRepo.getAllEmployees();
	}
	
//	@GET
//	@Path("{employeeid}")
//	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(value="/{employeeid}", method=RequestMethod.GET, headers="Accept=application/json" , produces={"application/json"})
	@ResponseBody
	public Employee getEmployee(@PathVariable("employeeid") int id){
		return empRepo.getEmployee(id);
	}
	
//	@PUT
//	@Path("{employeeid}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
	@RequestMapping(value="/{employeeid}", method=RequestMethod.PUT, headers="Accept=application/json" , produces={"application/json"})
	@ResponseBody
	public Employee updateEmployee(@PathVariable("employeeid") int id , @RequestBody Employee employee){
		employee.setId(id);
		return empRepo.updateEmployee(employee);
	}
	
	@RequestMapping(method=RequestMethod.POST , headers="Accept=application/json" , produces={"application/json"})
	@ResponseBody
	public List<Employee> addEmployee(@RequestBody Employee employee){
		return empRepo.addEmployee(employee);
	}
	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public List<Employee> addEmployee(Employee employee){
//		return empRepo.addEmployee(employee);
//	}
	
	@RequestMapping(value="/{employeeid}", method=RequestMethod.DELETE, headers="Accept=application/json", produces={"application/json"})
	@ResponseBody
	public void deleteEmployee(@PathVariable("employeeid") int id){
		System.out.println("Deleting .....");
		empRepo.deleteEmployee(id);
	}
}
