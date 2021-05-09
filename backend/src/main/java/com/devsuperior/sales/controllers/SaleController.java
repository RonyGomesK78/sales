package com.devsuperior.sales.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.sales.dto.SaleDTO;
import com.devsuperior.sales.dto.SaleSuccessDTO;
import com.devsuperior.sales.dto.SaleSumDTO;
import com.devsuperior.sales.services.SaleService;

@RestController
@RequestMapping(value="/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		
		Page<SaleDTO> list = saleService.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller(){
		
		List<SaleSumDTO> list = saleService.amountGroupedbySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value="/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller(){
		
		List<SaleSuccessDTO> list = saleService.successGroupedbySeller();
		return ResponseEntity.ok(list);
	}
}
