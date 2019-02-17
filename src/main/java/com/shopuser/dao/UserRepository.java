package com.shopuser.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopuser.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
	/*
	 *  cette methode est proposée par Spring data JPA et permet 
	 *  de génerer les données d'un user  en fonction de email et de son mot de passe
	 */
	List<User> findByEmailAndPassword(String email, String password);

}
