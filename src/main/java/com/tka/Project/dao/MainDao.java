package com.tka.Project.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.Project.entity.Country;

@Repository
public class MainDao {
	
	@Autowired
	SessionFactory factory;

	public String  addCountry(Country c) {
		
		Session session=null;
		Transaction tx=null;
		String msg=null;
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			session.persist(c);
			tx.commit();
			msg="country Added Sucssfully";
			
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

	public String updateCounrty(Country c, int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Country country=null;
		
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			country= session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);
			tx.commit();
			msg="country Update Sucssfully";
			
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

	public String deleteCounrty(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Country  country=null;
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			country= session.get(Country.class, id);
			session.remove(country);
			tx.commit();
			msg="country Deleted Sucssfully";
			
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

	public List<Country> getAllCounrty() {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		List<Country> list=null;
		String hqlQuery="from Country";
		
		try {
			
			session= factory.openSession();
			tx= session.beginTransaction();
			Query<Country> query= session.createQuery(hqlQuery,Country.class);
			list= query.list();
			tx.commit();
			for (Country country : list) {
				
				
			}
			
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
		
		return list;
	}

	public Country getPerticularCounrty(int id) {
		Session session=null;
		Transaction tx=null;
		String msg=null;
		Country  country=null;
		try {
			session= factory.openSession();
			tx= session.beginTransaction();
			country= session.get(Country.class, id);
			msg="country get Perticular Sucssfully";
			tx.commit();
			
			
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
		
		return country;
	}
	
	
}
