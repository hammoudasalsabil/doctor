package com.tassdoc.tassdoc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tassdoc.tassdoc.model.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>{
	
	Document findById(int id);
	Document deleteById(int id);

}
