package com.practice.SpringRestAPI.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.practice.SpringRestAPI.model.Employee;
/*	
	Adding sample data to the employee class and then performing 
	the retrieving, adding, updating and deleting data on the List<Employee>

*/
public class EmployeeRepo {

	private  static List<Employee> employees;
		
	 static {
		employees = new ArrayList<Employee>(); 
		for(int i=0 ; i<10 ; i++)
		{
			employees.add(new Employee(i,"FirstName"+i, "LastName"+i, 1000));	
		}
	}
	
	public List<Employee> getAllEmployees(){
		return employees;
	}
	
	public Employee getEmployee(int id){	
		for (Employee employee : employees)
		{
			if(employee.getId() == id)
			{
				return employee;
			}
		}
		return null;
	}
	
	public Employee updateEmployee(Employee employee){
		for (Employee emp : employees)
		{
			if(emp.getId() == employee.getId())
			{
				emp.setId(employee.getId());
				emp.setFirstName(employee.getFirstName());
				emp.setLastName(employee.getLastName());
				emp.setSalary(employee.getSalary());
				employees.add(emp);
				return emp;
			}
		}
		return null;
	}

	public List<Employee> addEmployee(Employee employee) {
		
		ListIterator<Employee> itr = employees.listIterator();
		System.out.println("inside post method");
		do
		{   
			System.out.println("hello"+ itr.next());
			if(!itr.hasNext())
			{
				int index = itr.previousIndex();
				System.out.println(index);
				employee.setId(employees.get(index).getId()+1);
			}
		}while(itr.hasNext());
		
		employees.add(employee);
		return employees;
	}

	public void deleteEmployee(int id) {
		ListIterator<Employee> itr = employees.listIterator();
		System.out.println("deleting from empRepo ....");
		int index = 0;
		
		while(itr.hasNext()){
			index = itr.nextIndex();
			System.out.println(index + "id is : " + id );
			if(employees.get(index).getId()==id){
				System.out.println(index + "id is : " + id + "from the if loop" );
				break;
			}
			itr.next();
		}
		employees.remove(index);	
	}
	
}
