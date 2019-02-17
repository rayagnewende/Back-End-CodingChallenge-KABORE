package com.shopuser.service;

import java.net.URI;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.shopuser.dao.UserRepository;
import com.shopuser.exceptions.UserDataIncorrectException;
import com.shopuser.exceptions.UserIntrouvableException;
import com.shopuser.models.Shop;
import com.shopuser.models.User;

@RestController
@CrossOrigin("*") // cette annotation permet d'eviter les erreurs de cross origin request 
public class UserService {
	
	@Autowired
	private UserRepository userrepository ;
	
	
	/*
	 * cette methode permet d'authentifier un utilisateur. 
	 * la methode utilisée pour cherché l'utilisateur renvoie une liste,
	 *  donc l'utilisateur correspond au premier element de la liste
	 */
	@PostMapping("users/login")
	public User loginUser(@RequestBody User user ) throws UserDataIncorrectException
	{
		String email = user.getEmail();
		String password = user.getPassword();
	    List<User> user1 = userrepository.findByEmailAndPassword(email, password);
	    
	    // une exception est lancée lorque les données de l'utilisateur sont incorrects !
	    if(user1.isEmpty()) throw new UserDataIncorrectException("Email ou Password incorrect !");
		return user1.get(0);
	}
	
	
	
	// cette methode retourne une liste d'utilisateur
	@GetMapping("/users")
	public List<User> getUsers()
	{
		return userrepository.findAll();
	} 
	
	
	
	
	/*
	 *Cette methode récupère un utilisateur via son identifiant 
     */
	@GetMapping("/users/{id}")
	public User getUser(@PathVariable Long id) throws UserIntrouvableException 
	{
		User user = userrepository.getOne(id);
	    //une exception est lancé si l'utilisateur recherché n'a été trouvé 
	    if(user == null) throw new UserIntrouvableException("l'utilisateur avec l'id:"+ id + "n'existe pas");
	       return user;
	}
	
	
	
	
	/* 
	 * cette methode permet l'ajout d'un nouvel utilisateur 
	 * ResponseEntity<Void> est une classe qui hérite de HttpEntity, il permet de définir le bon code 
	 * HTTP à retourner 
	 * */
	@PostMapping("/users")
	public ResponseEntity<User> addUser(@RequestBody User user)
	{
		User localuser = userrepository.save(user);
		
		  if (localuser == null)
	            return ResponseEntity.noContent().build();  

	     /*   URI location = ServletUriComponentsBuilder
	                .fromCurrentRequest()
	                .path("/{id}")
	                .buildAndExpand(localuser.getId())
	                .toUri();      

	        return ResponseEntity.created(location).build();   */
		  return new ResponseEntity<User>(localuser, HttpStatus.CREATED);
	}
	
	
	
	
	// Cette methode permet de modifier les données d'un utilisateur
	@PutMapping("/users")
	public User updateUser(@RequestBody User user)
	{
		return userrepository.save(user) ;
	}
	
	
	
	
	
	 // Cette methode permet de supprimer un utilisateur de la base de données
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable Long id)
	{
		  userrepository.deleteById(id);
	}
	

}
