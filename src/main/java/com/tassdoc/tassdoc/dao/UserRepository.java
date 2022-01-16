package com.tassdoc.tassdoc.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tassdoc.tassdoc.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findById(int id);
	User deleteById(int id);
	

	@Query("select u from User u where u.type_per = :type_per")
	List<User> ChercherPatient(@Param("type_per") String type_per);
	
}
