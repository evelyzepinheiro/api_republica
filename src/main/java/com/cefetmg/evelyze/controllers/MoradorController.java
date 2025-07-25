package com.cefetmg.evelyze.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cefetmg.evelyze.dto.MoradorDTO;
import com.cefetmg.evelyze.services.MoradorService;

@RestController
@RequestMapping("/moradores")
public class MoradorController {

	@Autowired
	private MoradorService moradorService;
	
	@GetMapping("/{id}")
	public ResponseEntity<MoradorDTO> findById(@PathVariable Long id){
		MoradorDTO moradorDTO = moradorService.findById(id);
		return ResponseEntity.ok(moradorDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<MoradorDTO>> findAll(){
		List<MoradorDTO> moradorDTOs = moradorService.findAll();
		return ResponseEntity.ok(moradorDTOs);
	}
	
	@PostMapping
	public ResponseEntity<MoradorDTO> create(@RequestBody MoradorDTO moradorDTO){
		MoradorDTO novoMorador = moradorService.insert(moradorDTO);
		return ResponseEntity.status(201).body(novoMorador);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<MoradorDTO> update(@PathVariable Long id, @RequestBody MoradorDTO moradorDTO){
		MoradorDTO moradorAtualizado = moradorService.update(id, moradorDTO);
		return ResponseEntity.ok(moradorAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		moradorService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
