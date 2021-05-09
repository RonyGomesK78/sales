package com.devsuperior.sales.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.sales.dto.SaleDTO;
import com.devsuperior.sales.dto.SaleSuccessDTO;
import com.devsuperior.sales.dto.SaleSumDTO;
import com.devsuperior.sales.entities.Sale;
import com.devsuperior.sales.repositories.SalesRepository;
import com.devsuperior.sales.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SalesRepository saleRepository;

	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		
		sellerRepository.findAll();
		Page<Sale> result = saleRepository.findAll(pageable);
		return result.map(sale -> new SaleDTO(sale));
	}
	
	@Transactional(readOnly=true)
	public List<SaleSumDTO> amountGroupedbySeller(){
		return saleRepository.amountGroupedbySeller();
	}
	
	@Transactional(readOnly=true)
	public List<SaleSuccessDTO> successGroupedbySeller(){
		return saleRepository.successGroupedbySeller();
	}
}
