package com.cefetmg.evelyze.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefetmg.evelyze.dto.ContaDTO;
import com.cefetmg.evelyze.entities.Conta;
import com.cefetmg.evelyze.entities.Morador;
import com.cefetmg.evelyze.entities.TipoConta;
import com.cefetmg.evelyze.respositories.ContaRepository;
import com.cefetmg.evelyze.respositories.MoradorRepository;
import com.cefetmg.evelyze.respositories.TipoContaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private TipoContaRepository tipoContaRepository;
    
    @Autowired
    private MoradorRepository moradorRepository;
    
    
    public List<ContaDTO> findAll() {
        List<Conta> listaConta = contaRepository.findAll();
        return listaConta.stream().map(ContaDTO::new).toList();
    }

    public ContaDTO findById(Long id) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada com ID: " + id));
        return new ContaDTO(conta);
    }

    public ContaDTO insert(ContaDTO contaDTO) {
        Morador morador = moradorRepository.findById(contaDTO.getMoradorResponsavelId())
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado com ID: " + contaDTO.getMoradorResponsavelId()));
        
        TipoConta tipoConta = tipoContaRepository.findById(contaDTO.getTipoContaId())
                .orElseThrow(() -> new EntityNotFoundException("Tipo Conta não encontrado com ID: " + contaDTO.getTipoContaId()));
        
        Conta conta = new Conta();
        
        conta.setObservacao(contaDTO.getObservacao());
        conta.setDataVencimento(contaDTO.getDataVencimento());
        conta.setTipoConta(tipoConta);
        conta.setValor(contaDTO.getValor());
        conta.setResponsavel(morador);
        conta.setSituacao(contaDTO.getSituacao());
        
        Conta contaSalvo = contaRepository.save(conta);
        return new ContaDTO(contaSalvo);
    }

    public ContaDTO update(Long id, ContaDTO contaDTO) {
        Conta conta =contaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Conta não encontrada com ID: " + id));
        
        Morador morador = moradorRepository.findById(contaDTO.getMoradorResponsavelId())
                .orElseThrow(() -> new EntityNotFoundException("Morador não encontrado com ID: " + contaDTO.getMoradorResponsavelId()));
        
        TipoConta tipoConta = tipoContaRepository.findById(contaDTO.getTipoContaId())
                .orElseThrow(() -> new EntityNotFoundException("Tipo Conta não encontrado com ID: " + contaDTO.getTipoContaId()));
        
        
        conta.setObservacao(contaDTO.getObservacao());
        conta.setDataVencimento(contaDTO.getDataVencimento());
        conta.setTipoConta(tipoConta);
        conta.setValor(contaDTO.getValor());
        conta.setResponsavel(morador);
        conta.setSituacao(contaDTO.getSituacao());        

        Conta contaAtualizada = contaRepository.save(conta);
        return new ContaDTO(contaAtualizada);
    }

    public void delete(Long id) {
        if (!contaRepository.existsById(id)) {
            throw new EntityNotFoundException("Conta não encontrada com ID: " + id);
        }
        contaRepository.deleteById(id);
    }

    
}
