package com.tka.Project.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.Project.entity.Country;
import com.tka.Project.entity.Employee;
import com.tka.Project.service.EmployeeService;

@RestController
@RequestMapping("empApi")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PostMapping("addrecordEmp")
	public ResponseEntity<String> addRecordEmp(@RequestBody Employee emp){
		String msg= service.addRecordEmp(emp);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("updateemployee/{id}")
	public ResponseEntity<String> updateEmployee(@RequestBody Employee emp,@PathVariable long id){
		String msg=  service.updateEmployee(emp,id);
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deleteemployee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id){
		String msg=  service.deleteEmployee(id);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getallEmp")
	public ResponseEntity<List<Employee>> getAllEmployee(){
		List<Employee> list=  service.getAllEmployee();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("getper/{id}")
	public ResponseEntity<Employee> getPerEmp(@PathVariable int id){
		Employee emp= service.getallEmp(id);
		return ResponseEntity.ok(emp);
		
	}
	
	@PostMapping("login")
	public ResponseEntity<Map> login(@RequestBody Employee emp) {
		Map map= service.login(emp);
		return ResponseEntity.ok(map);
	}
	
	
	@GetMapping("getsalary/{salary}/{salary1}")
	public ResponseEntity<List<Employee>> getSalary(@PathVariable double salary ,@PathVariable double salary1) {
		List< Employee> list= service.getSalary(salary,salary1);
		return ResponseEntity.ok(list);
	}
	
//	@GetMapping("employeeStatus/{status}")
//	public ResponseEntity<List<Employee>> getEmployeeStatus(@PathVariable String status) {
//		List<Employee> list = employeeService.getEmployeeStatus(status);
//		return ResponseEntity.ok(list);
//	}
	
	@GetMapping("getstatus/{status}")
	public ResponseEntity<List<Employee>> getStatusEmp(@PathVariable String status) {
		List< Employee> list= service.getStatus(status);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("statuschnge/{eId}")
	public ResponseEntity<String> getEmployeeStatusChange(@PathVariable int eId) {
		String message = service.getEmployeeStatusChange(eId);
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("empStatusChangeByIdAndStatus/{eId}/{status}")
	public ResponseEntity<String> employeeStatusChangeByIdAndStatus(@PathVariable int eId, @PathVariable String status) {
		String message = service.employeeStatusChangeByIdAndStatus(eId,status);
		return ResponseEntity.ok(message);
	}
	


}
