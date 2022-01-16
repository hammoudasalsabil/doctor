package com.tassdoc.tassdoc.model;

import java.io.File;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
@Entity
@Table(name="Document")
public class Document {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	private String title;
	private File file;
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@ManyToOne
    @JoinColumn(name="id_patient")
    private Patient patient;
	
	@ManyToOne
    @JoinColumn(name="id_doctor")
    private Doctor doctor;
	
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(String title, File file, Date date, Patient patient, Doctor doctor) {
		super();
		this.title = title;
		this.file = file;
		this.date = date;
		this.patient = patient;
		this.doctor = doctor;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", title=" + title + ", file=" + file + ", date=" + date + ", patient=" + patient
				+ ", doctor=" + doctor + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	
	
	
	
}
