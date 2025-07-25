package com.cefetmg.evelyze.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cefetmg.evelyze.dto.TipoContaDTO;
import com.cefetmg.evelyze.services.TipoContaService;

import java.util.List;


@RestController
@RequestMapping("/tipos_conta")
public class TipoContaController {

    @Autowired
    private TipoContaService tipoContaService;

	@GetMapping("/{id}")
	public ResponseEntity<TipoContaDTO> findById(@PathVariable Long id){
		TipoContaDTO tipoContaDTO = tipoContaService.findById(id);
		return ResponseEntity.ok(tipoContaDTO);
	}
	
	@GetMapping
	public ResponseEntity<List<TipoContaDTO>> findAll(){
		List<TipoContaDTO> tipoContaDTOs = tipoContaService.findAll();
		return ResponseEntity.ok(tipoContaDTOs);
	}
	
	@PostMapping
	public ResponseEntity<TipoContaDTO> create(@RequestBody TipoContaDTO tipoContaDTO){
		TipoContaDTO novoTipo = tipoContaService.insert(tipoContaDTO);
		return ResponseEntity.status(201).body(novoTipo);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoContaDTO> update(@PathVariable Long id, @RequestBody TipoContaDTO tipoContaDTO){
		TipoContaDTO tipoAtualizado = tipoContaService.update(id, tipoContaDTO);
		return ResponseEntity.ok(tipoAtualizado);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		tipoContaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}

