package com.tka.Project.controller;

import java.util.List;

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
import com.tka.Project.service.CountryService;

@RestController
@RequestMapping("api")
public class CountryController {
	
	@Autowired
	CountryService service;
	
	@PostMapping("addcountry")
	public ResponseEntity<String> addCountry(@RequestBody Country c) {
		String msg= service.addCountry(c);
		return ResponseEntity.ok(msg);
	}
	
	@PutMapping("updatecountry/{id}")
	public ResponseEntity<String> updateCounrty(@RequestBody Country c,@PathVariable int id){
		String msg=  service.updateCounrty(c,id);
		return ResponseEntity.ok(msg);
	}
	
	@DeleteMapping("deletecountry/{id}")
	public ResponseEntity<String> deleteCounrty(@PathVariable int id){
		String msg=  service.deleteCounrty(id);
		return ResponseEntity.ok(msg);
	}
	
	@GetMapping("getall")
	public ResponseEntity<List<Country>> getAllCounrty(){
		List<Country> list=  service.getAllCounrty();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("getpercountry/{id}")
	public ResponseEntity<Country> getPerticularCounrty(@PathVariable int id){
		Country con=  service.getPerticularCounrty(id);
		return ResponseEntity.ok(con);
	}
	
	

}
