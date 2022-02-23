package com.tassdoc.tassdoc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tassdoc.tassdoc.dao.DocumentRepository;
import com.tassdoc.tassdoc.model.Document;

@RestController
public class DocumentController {

	@Autowired
	private DocumentRepository documentrepository;

	@CrossOrigin(origins = "http://localhost:4201")
	
	@GetMapping(value="/Document")
	public List<Document> AfficherUtilisateurs(){
		return documentrepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4201")
	@GetMapping(value="/Document/{id}")
	public Document AfficherUtilisateur(@PathVariable int id){
		return documentrepository.findById(id);
	}

	@CrossOrigin(origins = "http://localhost:4201")
	@PostMapping(value="/AddDocument")
	public Document AddDoctor(@RequestBody Document document){
		return documentrepository.save(document);
	}
}
