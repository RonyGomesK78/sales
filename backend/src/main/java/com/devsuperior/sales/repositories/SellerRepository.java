package com.devsuperior.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.sales.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long>{

	
}
