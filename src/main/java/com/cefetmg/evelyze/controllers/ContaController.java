package com.cefetmg.evelyze.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefetmg.evelyze.dto.ContaDTO;
import com.cefetmg.evelyze.services.ContaService;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService contaService;

	@GetMapping("/{id}")
	public ResponseEntity<ContaDTO> findById(@PathVariable Long id){
		ContaDTO contaDTO = contaService.findById(id);
		return ResponseEntity.ok(contaDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<ContaDTO>> findAll(){
		List<ContaDTO> contaDTOs = contaService.findAll();
		return ResponseEntity.ok(contaDTOs);
	}
	
	@PostMapping
	public ResponseEntity<ContaDTO> create(@RequestBody ContaDTO contaDTO){
		ContaDTO novaConta = contaService.insert(contaDTO);
		return ResponseEntity.status(201).body(novaConta);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ContaDTO> update(@PathVariable Long id, @RequestBody ContaDTO contaDTO){
		ContaDTO contaAtualizada = contaService.update(id, contaDTO);
		return ResponseEntity.ok(contaAtualizada);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		contaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}