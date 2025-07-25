package com.cefetmg.evelyze.dto;
import java.math.BigDecimal;

import java.time.LocalDate;

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
      
	public ContaDTO() {
	}
	
	public ContaDTO(Conta conta) {
		this.id = conta.getId();
		this.observacao = conta.getObservacao();
		this.tipoContaId = conta.getTipoConta().getId();
		this.valor  = conta.getValor();
		this.dataVencimento  = conta.getDataVencimento();
		this.moradorResponsavelId  = conta.getResponsavel().getId();
		this.situacao  = conta.getSituacao();
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
