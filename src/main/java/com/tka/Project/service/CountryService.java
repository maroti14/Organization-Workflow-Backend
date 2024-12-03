package com.tka.Project.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.Project.dao.MainDao;
import com.tka.Project.entity.Country;

@Service
public class CountryService {
	
	@Autowired
	MainDao dao;

	public String  addCountry(Country c) {
		
		String msg= dao.addCountry(c);
		
		if(Objects.isNull(msg)) {
			msg="Country Is Not Be Added";
		}
		
		return msg;
		
		
	}

	public String updateCounrty(Country c, int id) {
		String msg= dao.updateCounrty(c,id);
		if(Objects.isNull(msg)) {
			msg="Country Is Not Update";
		}
		return msg;
	}

	public String deleteCounrty(int id) {
		String msg= dao.deleteCounrty(id);
		if(Objects.isNull(msg)) {
			msg="Country Is Not Deleted";
		}
		return msg;
	}

	public List<Country> getAllCounrty() {
		List<Country> list= dao.getAllCounrty();
		return list;
	}

	public Country getPerticularCounrty(int id) {
		Country con= dao.getPerticularCounrty(id);
		
		return con;
	}

}
