package com.devsuperior.sales.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.sales.entities.Sale;

public interface SalesRepository extends JpaRepository<Sale, Long>{

}
