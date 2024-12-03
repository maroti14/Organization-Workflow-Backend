package com.tka.Project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Project.dao.EmployeeDao;
import com.tka.Project.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDao dao;

	public String addRecordEmp(Employee emp) {
		String msg= dao.addRecordEmp(emp);
		if(Objects.isNull(msg)) {
			msg="Employee Is Not Be Added";
		}
		return msg;
	}

	public String updateEmployee(Employee emp, long id) {
		String msg= dao.updateEmployee(emp,id);
		
		if(Objects.isNull(msg)) {
			msg="Employee Is Not Update";
		}
		return msg;
	}

	public String deleteEmployee(int id) {
		String msg= dao.deleteEmployee(id);
		if(Objects.isNull(msg))
			msg="Employee Is Not Delete";
		return msg;
	}

	public List<Employee> getAllEmployee() {
		List<Employee> list= dao.getAllEmployee();
		return list;
	}

	public Employee getallEmp(int id) {
		Employee emp= dao.getallEmp(id);
		return emp;
	}

	public Map login(Employee emp) {
		Employee obj= dao.login(emp);
		Map map= new HashMap();
		
		if(Objects.isNull(obj)) {
			map.put("msg", "Invalid Use");
			map.put("user", obj);
		}else {
			map.put("msg", "valid user");
			map.put("user", obj);
		}
		return map;
		
	}

	public List<Employee> getSalary( double salary, double salary1) {
		List<Employee> list=dao.getSalary(salary,salary1);
		return list;
	}

	public List<Employee> getStatus(String status) {
		List<Employee> list= dao.getStatus(status);
		return list;
	}

	public String getEmployeeStatusChange(int eId) {
		String msg= dao.getEmployeeStatusChange(eId);
		return msg;
	}

	public String employeeStatusChangeByIdAndStatus(int eId, String status) {
	String msg=	dao.employeeStatusChangeByIdAndStatus(eId,status);
		return msg;
	}

}
