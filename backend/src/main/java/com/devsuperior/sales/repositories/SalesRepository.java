package com.devsuperior.sales.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.sales.dto.SaleSuccessDTO;
import com.devsuperior.sales.dto.SaleSumDTO;
import com.devsuperior.sales.entities.Sale;

public interface SalesRepository extends JpaRepository<Sale, Long>{

	@Query("SELECT new com.devsuperior.sales.dto.SaleSumDTO (obj.seller, SUM (obj.amount) ) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedbySeller();
	
	@Query("SELECT new com.devsuperior.sales.dto.SaleSuccessDTO (obj.seller, SUM (obj.visited), SUM (obj.deals) ) "
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedbySeller();
}
