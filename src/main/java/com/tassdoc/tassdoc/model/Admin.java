package com.tassdoc.tassdoc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Admin")
@DiscriminatorValue("A")
public class Admin extends User{
	
	@OneToMany(mappedBy = "admin",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Doctor> doctors;

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String surname, String adress, String phone) {
		super(name, surname, adress, phone);
	}

	@Override
	public String toString() {
		return "Admin [doctors=" + doctors + "]";
	}

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	
	

}
