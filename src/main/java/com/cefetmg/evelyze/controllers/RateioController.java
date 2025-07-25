package com.cefetmg.evelyze.controllers;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefetmg.evelyze.dto.RateioDTO;
import com.cefetmg.evelyze.services.RateioService;

import java.util.List;


@RestController
@RequestMapping("/rateio")
public class RateioController {

    @Autowired
    private RateioService rateioService;

	@GetMapping("/{id}")
	public ResponseEntity<RateioDTO> findById(@PathVariable Long id){
		RateioDTO rateioDTO = rateioService.findById(id);
		return ResponseEntity.ok(rateioDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<RateioDTO>> findAll(){
		List<RateioDTO> rateioDTOs = rateioService.findAll();
		return ResponseEntity.ok(rateioDTOs);
	}
	
	@PostMapping
	public ResponseEntity<RateioDTO> create(@RequestBody RateioDTO rateioDTO){
		RateioDTO novoTipo = rateioService.insert(rateioDTO);
		return ResponseEntity.status(201).body(novoTipo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<RateioDTO> update(@PathVariable Long id, @RequestBody RateioDTO rateioDTO){
		RateioDTO tipoAtualizado = rateioService.update(id, rateioDTO);
		return ResponseEntity.ok(tipoAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		rateioService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

