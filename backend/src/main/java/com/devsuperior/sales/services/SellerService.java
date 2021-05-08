package com.devsuperior.sales.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.sales.dto.SellerDTO;
import com.devsuperior.sales.entities.Seller;
import com.devsuperior.sales.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		
		List<Seller> result= repository.findAll();
		return result.stream().map(seller -> new SellerDTO(seller)).collect(Collectors.toList());
	}
}
