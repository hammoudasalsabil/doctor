package com.tassdoc.tassdoc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="Patient")
@DiscriminatorValue("P")
public class Patient extends User{
	
	@ManyToOne
    @JoinColumn(name="id_doctor")
    private Doctor doctor;
	
	@OneToMany(mappedBy ="patient",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Document> documents;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String name, String surname, String adress, String phone) {
		super(name, surname, adress, phone);
	}

	@Override
	public String toString() {
		return "Patient [doctor=" + doctor + ", documents=" + documents + "]";
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	
	


}
