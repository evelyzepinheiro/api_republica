package com.cefetmg.evelyze.dto;

import com.cefetmg.evelyze.entities.TipoConta;

public class TipoContaDTO {
	private Long id;
    private String descricao;
    private String observacao;
    
	public TipoContaDTO() {
	}

	public TipoContaDTO(TipoConta tipoConta) {
		this.id = tipoConta.getId();
		this.descricao = tipoConta.getDescricao();
		this.observacao = tipoConta.getObservacao();
	}
	
	public TipoContaDTO(Long id, String descricao, String observacao) {
		this.id = id;
		this.descricao = descricao;
		this.observacao = observacao;
	}
	
    public Long getId() {
        return id;
    }	

    public String getDescricao() {
        return descricao;
    }

    public String getObservacao() {
        return observacao;
    }




}