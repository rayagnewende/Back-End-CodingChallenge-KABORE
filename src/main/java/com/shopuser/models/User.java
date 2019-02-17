package com.shopuser.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/*
 * Pour la réalisation de cette application,nous contatons que la relation many to many convient 
 * le plus.
 * un utilisateur peut aimer plusieurs magasins 
 * un magasin peut etre aimé par plusieurs utilisateur  
 * 
 */

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name ;
	private String email ;
	private String password ;
	
	/*
	 * cette annotation indique la relation qu'il y a entre User et Shop
	 * L'option  LAZY indique comment les données seront chargées dans le programme 
	 * lorsqu'on en aura besoin
	 */
	 @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            })
	    @JoinTable(name = "user_shops",
	            joinColumns = { @JoinColumn(name = "user_id") },
	            inverseJoinColumns = { @JoinColumn(name = "shop_id") })
	 
	   // cette annotations permet d'éviter les problèmes liés à la serialisations des entitées
	    @JsonIgnoreProperties("users")
	    private Set<Shop> shops = new HashSet<Shop>();
	
	 
	 
	 public User()
	 {
		 
	 }
	 
	 
    

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}




	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}




	public User(String name, String email, String password, Set<Shop> shops) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.shops = shops;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Shop> getShops() {
		return shops;
	}

	public void setShops(Set<Shop> shops) {
		this.shops = shops;
	}}


