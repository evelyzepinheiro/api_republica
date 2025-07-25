package com.cefetmg.evelyze.dto;

import java.math.BigDecimal;


import com.cefetmg.evelyze.entities.Conta;
import com.cefetmg.evelyze.entities.Morador;
import com.cefetmg.evelyze.entities.RateioConta;
import com.cefetmg.evelyze.entities.SituacaoRateio;


public class RateioDTO {
	private Long id;
    private Long moradorId;
    private BigDecimal valor;
    private SituacaoRateio situacao; // Deve ser QUITADA,PENDENTE, CANCELADA
    private Long idConta;
       
    public RateioDTO() {
    	
    }
    
    public RateioDTO(RateioConta rateio) {
    	this.id = rateio.getId();
		this.moradorId = rateio.getMorador().getId();
		this.valor = rateio.getValor();
		this.situacao = rateio.getSituacao();
		this.idConta = rateio.getConta().getId();
	}
    
    // Getters

    public Long getId() {
		return id;
	}    
    
    public Long getMoradorId() { 
    	return moradorId; 
    	
    }

   	
	public BigDecimal getValor() { 
    	return valor; 
    	
    }
    
    public SituacaoRateio getSituacao() { 
    	return situacao; 
    	
    }
	public Long getIdConta() {
		return idConta;
	}
	
	
}

