package com.shopuser;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopuser.dao.ShopRepository;
import com.shopuser.dao.UserRepository;
import com.shopuser.models.Shop;
import com.shopuser.models.User;

/*
 *  l'annotation @SpringBootApplication remplace les les anciennes qui étaient 
 *  @Enable
 */
@SpringBootApplication 
public class ShopUserApplication implements CommandLineRunner{
	
	 @Autowired
	  UserRepository userrepository ;

	 @Autowired
	 ShopRepository shoprepository ;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ShopUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Set<Shop> shops = new HashSet<Shop>();
	
		Shop shop1 = new Shop("Decathlon", "https://cdni.rt.com/french/images/2016.07/article/577d68c1c361884c7a8b467c.jpg",1200);
		Shop shop2 = new Shop("KIABI", "http://femmesdumaroc.com/wp-content/uploads/2016/02/Fnac.jpg",1300);
		Shop shop3 = new Shop("Bim Bim", "https://static.lematin.ma/files/lematin/images/articles/2016/03/Hard-discount-Bim.jpg",1400);
		Shop shop4 = new Shop("Addidas", "http://femmesdumaroc.com/wp-content/uploads/2016/02/Fnac.jpg",1500);
		Shop shop5 = new Shop("Carrefour", "https://www.lebabi.net/mfupdata/1450689741carrefour.jpg",1600);
		Shop shop6 = new Shop("Fnac Fnac", "http://femmesdumaroc.com/wp-content/uploads/2016/02/Fnac.jpg",1700);
		Shop shop7 = new Shop("Prada", "http://femmesdumaroc.com/wp-content/uploads/2016/02/Fnac.jpg",1800);
		Shop shop8 = new Shop("Marjane", "https://www.lebabi.net/mfupdata/1450689741carrefour.jpg",1900);
	
		shops.add(shop1);
		shops.add(shop2); 
		shops.add(shop3);
		shops.add(shop4);
		shops.add(shop5);
		shops.add(shop6);
		shops.add(shop7);
		shops.add(shop8);
		shoprepository.saveAll(shops);
		
		User user = new User("kaboreva@gmail.com","12345678");
		
		userrepository.save(user);

		
	}


}

