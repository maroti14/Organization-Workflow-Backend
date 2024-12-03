package com.tka.Project.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.tka.Project.entity.Country;
import com.tka.Project.entity.Employee;

@Repository
public class EmployeeDao {
	
	@Autowired
	SessionFactory factory;

	public String addRecordEmp(Employee emp) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session= factory.openSession();
			tx=session.beginTransaction();
			
			session.persist(emp);
			tx.commit();
			msg="Employee Added Sucssfully";
			
			
		} catch (Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			if(session !=null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateEmployee(Employee emp, long id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		
		try {
			
			session= factory.openSession();
			tx=session.beginTransaction();
			Employee e1= session.get(Employee.class, id);
			e1.setName(emp.getName());
			session.merge(e1);
			tx.commit();
			msg="Employee Update Sucssfully";
			
		} catch (Exception e) {
			
			if(tx !=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		
		}finally {
			if(session != null) {
				session.close();
			}
		}
		
		return msg;
	}

	public String deleteEmployee(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Employee emp=null;
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			emp= session.get(Employee.class, id);
			session.remove(emp);
			tx.commit();
			msg="Employee Deleted Sucssfully";
			
		} catch (Exception e) {
			
			if(tx !=null) {
				tx.rollback();
			}
			
			e.printStackTrace();
		}finally {
			if(session !=null) {
				session.close();
			}
			
		}
		
		return msg;
	}

	public List<Employee> getAllEmployee() {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		List<Employee> list=null;
		
		try {
			
			session= factory.openSession();
			tx=session.beginTransaction();
			
			String hqlQuery="from Employee";
			
			Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			list= query.list();
			tx.commit();
			for (Employee employee : list) {
				
			}
			
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session != null) {
				session.close();
			}
			
		}
		return list;
		
	}

	public Employee getallEmp(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Employee emp=null;
		
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			emp= session.get(Employee.class, id);
			tx.commit();
			
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session != null) {
				session.close();
			}
			
		}
		return emp;
		
	}

	public Employee login(Employee emp) {
		
		Session session=null;
		Transaction tx=null;
		Employee employee = 	null;
		
		String hqlQuery="from Employee where emailid=:emailid and mobileno=:mobileno";
		
		
		try {
			session= factory.openSession();
			tx=session.beginTransaction();
			Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			query.setParameter("emailid", emp.getEmailid());
			query.setParameter("mobileno", emp.getMobileno());
			employee= query.uniqueResult();
			tx.commit();
			
		} catch (Exception e) {
			if(tx !=null) {
				tx.rollback();
			}
		}finally {
			if(session !=null) {
			session.close();
			}
		}
		return employee;
	}

	public List<Employee> getSalary(double salary, double salary1) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		List<Employee> list=null;
		
		try {
			
			session= factory.openSession();
			tx=session.beginTransaction();
			
			String hqlQuery="from Employee where salary between:salary and :salary1 ";
			
			Query<Employee> query= session.createQuery(hqlQuery,Employee.class);
			query.setParameter("salary", salary);
			query.setParameter("salary1", salary1);
			list= query.list();
			tx.commit();
			for (Employee employee : list) {
				
			}
			
		} catch (Exception e) {
			if(tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		}finally {
			
			if(session != null) {
				session.close();
			}
			
		}
		return list;
		
	}

	public List<Employee> getStatus(String status) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		List<Employee> list=null;
		
try {
			
			session = factory.openSession();
			tx= session.beginTransaction();
			String hqlQuery = "from Employee where status=:s";
			Query<Employee> query = session.createQuery(hqlQuery,Employee.class);
			query.setParameter("s", status);
			 list = query.list();
			 tx.commit();
			
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
				
		return list;
	}

	public String getEmployeeStatusChange(int eId) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		List<Employee> list=null;
		
		
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Employee emp = session.get(Employee.class, eId);
			String status = emp.getStatus();
			if(status.equals("Active")) {
				emp.setStatus("Inactive");
				msg = "Status Changed Successfully.";
			}
			else if(status.equals("Inactive")) {
				emp.setStatus("Active");
				msg = "Status Changed Successfully.";
			}
			else {
				msg = "Suspended employee does not change status";
			}
			session.merge(emp);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return msg;
		
	}

	public String employeeStatusChangeByIdAndStatus(int eId, String status) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		List<Employee> list=null;
		
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Employee emp = session.get(Employee.class, eId);
			
			if(status.equals("Active")) {
				emp.setStatus("Inactive");
				msg = "Status Changed Successfully.";
			}
			else if(status.equals("Inactive")) {
				emp.setStatus("Active");
				msg = "Status Changed Successfully.";
			}
			else {
				msg = "Suspended employee does not change status";
			}
			session.merge(emp);
			tx.commit();
		}catch(Exception e) {
			if(tx!=null)
				tx.rollback();
			e.printStackTrace();
		}finally {
			if(session!=null)
				session.close();
		}
		
		return msg;
	}

	

	
	

}
