package com.cefetmg.evelyze.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cefetmg.evelyze.dto.MoradorDTO;
import com.cefetmg.evelyze.entities.Morador;
import com.cefetmg.evelyze.entities.RateioConta;
import com.cefetmg.evelyze.entities.SituacaoRateio;
import com.cefetmg.evelyze.respositories.MoradorRepository;
import com.cefetmg.evelyze.respositories.RateioContaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MoradorService {

    @Autowired
    private MoradorRepository moradorRepository;

    @Autowired
    private RateioContaRepository rateioContaRepository;

    public List<MoradorDTO> findAll() {
        List<Morador> listaMorador = moradorRepository.findAll();
        return listaMorador.stream().map(MoradorDTO::new).toList();
    }

    public MoradorDTO findById(Long id) {
        Morador morador = moradorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado com ID: " + id));
        return new MoradorDTO(morador);
    }

    public MoradorDTO insert(MoradorDTO moradorDTO) {
        Morador morador = new Morador();
        
        morador.setNome(moradorDTO.getNome());
        morador.setCelular(moradorDTO.getCelular());
        morador.setCpf(moradorDTO.getCpf());
        morador.setData_nascimento(moradorDTO.getData_nascimento());
        morador.setEmail(moradorDTO.getEmail());
        
        Morador moradorSalvo = moradorRepository.save(morador);
        return new MoradorDTO(moradorSalvo);
    }

    public MoradorDTO update(Long id, MoradorDTO moradorDTO) {
        Morador morador = moradorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado com ID: " + id));

        morador.setNome(moradorDTO.getNome());
        morador.setCelular(moradorDTO.getCelular());
        morador.setCpf(moradorDTO.getCpf());
        morador.setData_nascimento(moradorDTO.getData_nascimento());
        morador.setEmail(moradorDTO.getEmail());

        Morador moradorAtualizado = moradorRepository.save(morador);
        return new MoradorDTO(moradorAtualizado);
    }

    public void delete(Long id) {
        if (!moradorRepository.existsById(id)) {
            throw new EntityNotFoundException("Morador não encontrado com ID: " + id);
        }
        moradorRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public BigDecimal calcularSaldoMorador(Long moradorId) {
        List<RateioConta> pendentes = rateioContaRepository.findByMoradorIdAndSituacao(moradorId, SituacaoRateio.EM_ABERTO);

        return pendentes.stream()
                .map(RateioConta::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}