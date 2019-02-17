package com.shopuser.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="shops")
public class Shop  {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	private String shop_name;
	private String shop_image ;
	private int distance ;
	
	 @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            },
	            mappedBy = "shops")
	 
	// cette annotations permet d'éviter les problèmes liés à la serialisations des entitées
	 @JsonIgnoreProperties("shops") 
	 private Set<User> users = new HashSet<User>();
	 
	 
	 public Shop()
	 {
		 
	 }

	 

	public Shop(String shop_name, String shop_image, int distance) {
		super();
		this.shop_name = shop_name;
		this.shop_image = shop_image;
		this.distance = distance;
	}



	public Shop(String shop_name, String shop_image, int distance, Set<User> users) {
		super();
		this.shop_name = shop_name;
		this.shop_image = shop_image;
		this.distance = distance;
		this.users = users;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getShop_name() {
		return shop_name;
	}


	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}


	public String getShop_image() {
		return shop_image;
	}


	public void setShop_image(String shop_image) {
		this.shop_image = shop_image;
	}


	public int getDistance() {
		return distance;
	}


	public void setDistance(int distance) {
		this.distance = distance;
	}


	public Set<User> getUsers() {
		return users;
	}


	public void setPosts(Set<User> users) {
		this.users = users;
	}
	 
	 
	
	
	

}
