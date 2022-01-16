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
@Table(name="Doctor")
@DiscriminatorValue("D")
public class Doctor extends User{

	private String diplom;
	
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Patient> patients;
	
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Document> documents;
	
	@ManyToOne
    @JoinColumn(name="id_admin")
    private Admin admin;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String name, String surname, String adress, String phone, String diplom, Admin admin) {
		super(name, surname, adress, phone);
		this.diplom = diplom;
		this.admin = admin;
	}

	@Override
	public String toString() {
		return "Doctor [diplom=" + diplom + ", patients=" + patients + ", documents=" + documents + ", admin=" + admin
				+ "]";
	}

	public String getDiplom() {
		return diplom;
	}

	public void setDiplom(String diplom) {
		this.diplom = diplom;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	
}
