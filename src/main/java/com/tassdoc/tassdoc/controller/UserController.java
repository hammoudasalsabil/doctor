package com.tassdoc.tassdoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tassdoc.tassdoc.dao.UserRepository;
import com.tassdoc.tassdoc.model.Admin;
import com.tassdoc.tassdoc.model.Doctor;
import com.tassdoc.tassdoc.model.Patient;
import com.tassdoc.tassdoc.model.User;

import io.swagger.annotations.Api;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Api(description = "gestion des Utilisateu")
public class UserController {
	
	@Autowired
	private UserRepository userrepository;
	
	@GetMapping(value="/User")
	public List<User> AfficherUtilisateurs(){
		return userrepository.findAll();
	}
	@GetMapping(value="/User/{id}")
	public User AfficherUtilisateur(@PathVariable int id){
		return userrepository.findById(id);
	}
	@GetMapping(value="/Users/{type_per}")
	public List<User> AffUser(@PathVariable String type_per) {
		return userrepository.ChercherPatient(type_per);
	}
	
	@PostMapping(value="/AddDoctor")
	public User AddDoctor(@RequestBody Doctor doctor){
		return userrepository.save(doctor);
	}
	
	@PostMapping(value="/AddPatient")
	public User AddPatient(@RequestBody Patient patient){
		return userrepository.save(patient);
	}
	
	@PostMapping(value="/AddAdmin")
	public User AddAdmin(@RequestBody Admin admin){
		return userrepository.save(admin);
	}
	

	@DeleteMapping(value="/DelUser/{id}")
	public User DelUtilisateur(@PathVariable int id) {
		return userrepository.deleteById(id);
	} 
	
	@PutMapping(value="/UpdDoctor/{id}")
	public User UpdDoctor(@RequestBody  Doctor doctor, @PathVariable int id){
		doctor.setId(id);
		return userrepository.save(doctor);
	}

	@PutMapping(value="/UpdPatient/{id}")
	public User UpdPatient(@RequestBody  Patient patient, @PathVariable int id){
		patient.setId(id);
		return userrepository.save(patient);
	}
	
	@PutMapping(value="/UpdAdmin/{id}")
	public User UpdAdmin(@RequestBody  Admin admin, @PathVariable int id){
		admin.setId(id);
		return userrepository.save(admin);
	}
	
}
