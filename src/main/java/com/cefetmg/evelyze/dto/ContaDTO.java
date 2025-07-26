package com.cefetmg.evelyze.dto;
import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.cefetmg.evelyze.entities.Conta;
import com.cefetmg.evelyze.entities.SituacaoConta;

public class ContaDTO {
	public Long id;
    public String observacao;
    public Long tipoContaId;
    public BigDecimal valor;
    public LocalDate dataVencimento;
    public Long moradorResponsavelId;
    public SituacaoConta situacao;
    public List<RateioDTO> rateios;
      
	public ContaDTO() {
	}
	
	public ContaDTO(Conta conta) {
		this(conta, false);
	}
	
	public ContaDTO(Conta conta, boolean carregarRateios) {
		this.id = conta.getId();
		this.observacao = conta.getObservacao();
		this.tipoContaId = conta.getTipoConta().getId();
		this.valor  = conta.getValor();
		this.dataVencimento  = conta.getDataVencimento();
		this.moradorResponsavelId  = conta.getResponsavel().getId();
		this.situacao  = conta.getSituacao();
		
		if (carregarRateios) {
	        this.rateios = conta.getRateios().stream()
	            .map(RateioDTO::new)
	            .collect(Collectors.toList());
	    }
	}
	
	public Long getId() {
		return id;
	}
	public String getObservacao() {
		return observacao;
	}
	public Long getTipoContaId() {
		return tipoContaId;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public LocalDate getDataVencimento() {
		return dataVencimento;
	}
	public Long getMoradorResponsavelId() {
		return moradorResponsavelId;
	}
	public SituacaoConta getSituacao() {
		return situacao;
	}

    
    
	
}
