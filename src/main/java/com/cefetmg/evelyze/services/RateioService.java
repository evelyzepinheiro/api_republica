package com.cefetmg.evelyze.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefetmg.evelyze.dto.RateioDTO;
import com.cefetmg.evelyze.entities.Conta;
import com.cefetmg.evelyze.entities.Morador;
import com.cefetmg.evelyze.entities.RateioConta;
import com.cefetmg.evelyze.respositories.ContaRepository;
import com.cefetmg.evelyze.respositories.MoradorRepository;
import com.cefetmg.evelyze.respositories.RateioContaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class RateioService {

	@Autowired
	private RateioContaRepository rateioRepository;

	@Autowired
	private MoradorRepository moradorRepository;

	@Autowired
	private ContaRepository contaRepository;

	public List<RateioDTO> findAll() {
		List<RateioConta> listaRateio = rateioRepository.findAll();
		return listaRateio.stream().map(RateioDTO::new).toList();
	}

	public RateioDTO findById(Long id) {
		RateioConta rateio = rateioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Rateio não encontrada com ID: " + id));
		return new RateioDTO(rateio);
	}

	public RateioDTO insert(RateioDTO rateioDTO) {
		Morador morador = moradorRepository.findById(rateioDTO.getMoradorId()).orElseThrow(
				() -> new EntityNotFoundException("Morador não encontrado com ID: " + rateioDTO.getMoradorId()));

		Conta conta = contaRepository.findById(rateioDTO.getIdConta()).orElseThrow(
				() -> new EntityNotFoundException("Conta não encontrado com ID: " + rateioDTO.getIdConta()));

		RateioConta rateio = new RateioConta();

		rateio.setMorador(morador);
		rateio.setSituacao(rateioDTO.getSituacao());
		rateio.setValor(rateioDTO.getValor());
		rateio.setConta(conta);

		RateioConta rateioSalvo = rateioRepository.save(rateio);
		return new RateioDTO(rateioSalvo);
	}

	public RateioDTO update(Long id, RateioDTO rateioDTO) {
		RateioConta rateio = rateioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Rateio não encontrado com ID: " + id));

		Morador morador = moradorRepository.findById(rateioDTO.getMoradorId()).orElseThrow(
				() -> new EntityNotFoundException("Morador não encontrado com ID: " + rateioDTO.getMoradorId()));

		Conta conta = contaRepository.findById(rateioDTO.getIdConta()).orElseThrow(
				() -> new EntityNotFoundException("Conta não encontrado com ID: " + rateioDTO.getIdConta()));

		rateio.setMorador(morador);
		rateio.setSituacao(rateioDTO.getSituacao());
		rateio.setValor(rateioDTO.getValor());
		rateio.setConta(conta);

		RateioConta rateioAtualizado = rateioRepository.save(rateio);
		return new RateioDTO(rateioAtualizado);
	}

	public void delete(Long id) {
		if (!rateioRepository.existsById(id)) {
			throw new EntityNotFoundException("Rateio não encontrado com ID: " + id);
		}
		rateioRepository.deleteById(id);
	}

}
