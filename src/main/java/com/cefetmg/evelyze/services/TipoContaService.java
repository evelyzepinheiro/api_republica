package com.cefetmg.evelyze.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefetmg.evelyze.dto.TipoContaDTO;
import com.cefetmg.evelyze.entities.TipoConta;
import com.cefetmg.evelyze.respositories.TipoContaRepository;

import jakarta.persistence.EntityNotFoundException;


@Service
public class TipoContaService {

	 @Autowired
	    private TipoContaRepository tipoContaRepository;

	    public List<TipoContaDTO> findAll() {
	        List<TipoConta> listaTipoConta = tipoContaRepository.findAll();
	        return listaTipoConta.stream().map(TipoContaDTO::new).toList();
	    }

	    public TipoContaDTO findById(Long id) {
	        TipoConta tipoConta = tipoContaRepository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Tipo conta não encontrado com ID: " + id));
	        return new TipoContaDTO(tipoConta);
	    }

	    public TipoContaDTO insert(TipoContaDTO tipoContaDTO) {
	        TipoConta tipoConta = new TipoConta();
	        tipoConta.setDescricao(tipoContaDTO.getDescricao());
	        tipoConta.setObservacao(tipoContaDTO.getObservacao());
	        TipoConta tipoContaSalvo = tipoContaRepository.save(tipoConta);
	        return new TipoContaDTO(tipoContaSalvo);
	    }

	    public TipoContaDTO update(Long id, TipoContaDTO tipoContaDTO) {
	        TipoConta tipoConta = tipoContaRepository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Tipo conta não encontrado com ID: " + id));

	        tipoConta.setDescricao(tipoContaDTO.getDescricao());
	        tipoConta.setObservacao(tipoContaDTO.getObservacao());
	
	        TipoConta tipoContaAtualizado = tipoContaRepository.save(tipoConta);
	        return new TipoContaDTO(tipoContaAtualizado);
	    }

	    public void delete(Long id) {
	        if (!tipoContaRepository.existsById(id)) {
	            throw new EntityNotFoundException("Tipo conta não encontrado com ID: " + id);
	        }
	        tipoContaRepository.deleteById(id);
	    }
}