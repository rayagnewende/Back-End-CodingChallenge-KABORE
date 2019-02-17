package com.shopuser.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopuser.dao.ShopRepository;
import com.shopuser.exceptions.ShopListEmptyException;
import com.shopuser.models.Shop;

@RestController
@CrossOrigin("*")
public class ShopService {
	
	@Autowired
	ShopRepository shoprepository ;
	
	
	// cette mothode génère la liste des magasins triés en fonction de la distance 
	@GetMapping("/shops/sorted")
	public List<Shop> shopListSorted() throws ShopListEmptyException
	{
		List<Shop> shops= this.shopList();
		if(shops == null)
		{
			throw new ShopListEmptyException("le tri n'a pas pu etre effectuer car la liste recupérée est vide");
		}
		
		// ici la comparaison se fait en fonction de la distance de chaque magasin
		shops.sort(Comparator.comparing(Shop::getDistance));
		return shops ;
	
	}
	
	
	
	
	// cette methode retourne une liste non triée des magasins 
	@GetMapping("/shops")
	public List<Shop> shopList()
	{
		return shoprepository.findAll();
	}
	
	
	
	// cette methode retourne un magasin en fonction de son identifiant
	@GetMapping("/shops/{id}")
	public Shop getShop(@PathVariable Long id)
	{
		return shoprepository.getOne(id);
	}
	
	
	
	// cette methode permet d'enregistrer un magasin dans la base de données
	@PostMapping("/shops")
	public Shop addShop(@RequestBody Shop shop)
	{
		return shoprepository.save(shop) ;
	}
	
	
	// cette methode permet de modifier les informations d'un magasin dans la base de données
	@PutMapping("/shops")
	public Shop updateShop(@RequestBody Shop shop)
	{
		return shoprepository.save(shop);
	}
	
	// cette methode permet de supprimer un magasin dans la base de données
	@DeleteMapping("/shops/{id}")
	public void deleteShop(@PathVariable Long id)
	{
		shoprepository.deleteById(id);
	}
	

}
