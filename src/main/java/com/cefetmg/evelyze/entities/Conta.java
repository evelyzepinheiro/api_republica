package com.cefetmg.evelyze.entities;

import jakarta.persistence.*;


import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tb_conta")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "tipo_conta_id")
    private TipoConta tipoConta;

    private BigDecimal valor;

    private LocalDate dataVencimento;

    @Enumerated(EnumType.STRING)
    private SituacaoConta situacao;

    @ManyToOne
    @JoinColumn(name = "morador_responsavel_id")
    private Morador responsavel;

    public Conta() {
		
	}
    
    public Conta(Long id, String observacao, TipoConta tipoConta, BigDecimal valor, LocalDate dataVencimento,
			SituacaoConta situacao, Morador responsavel) {
		this.id = id;
		this.observacao = observacao;
		this.tipoConta = tipoConta;
		this.valor = valor;
		this.dataVencimento = dataVencimento;
		this.situacao = situacao; //QUITADA, PENDENTE,CANCELADA
		this.responsavel = responsavel;
	}
    
    
    // Getters e Setters

    public Long getId() { 
    	return id; 
    }
    public void setId(Long id) { 
    	this.id = id; 
    }

    public String getObservacao() {
    	return observacao; 
    }
    public void setObservacao(String observacao) { 
    	this.observacao = observacao; 
    }

    public TipoConta getTipoConta() { 
    	return tipoConta; 
    }
    public void setTipoConta(TipoConta tipoConta) { 
    	this.tipoConta = tipoConta;
    }

    public BigDecimal getValor() { 
    	return valor; 
    }
    public void setValor(BigDecimal valor) { 
    	this.valor = valor; 
    }

    public LocalDate getDataVencimento() { 
    	return dataVencimento; 
    }
    public void setDataVencimento(LocalDate dataVencimento) { 
    	this.dataVencimento = dataVencimento; 
    }

    public SituacaoConta getSituacao() { 
    	return situacao; 
    }
    public void setSituacao(SituacaoConta situacao) { 
    	this.situacao = situacao; 
    }

    public Morador getResponsavel() { 
    	return responsavel; 
    }
    public void setResponsavel(Morador responsavel) { 
    	this.responsavel = responsavel; 
    }

    
}