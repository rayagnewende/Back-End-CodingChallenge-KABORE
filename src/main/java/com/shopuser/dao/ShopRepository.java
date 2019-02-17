package com.shopuser.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopuser.models.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
