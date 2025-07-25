package com.cefetmg.evelyze.entities;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "tb_rateioconta")
public class RateioConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private SituacaoRateio situacao;

    @ManyToOne
    @JoinColumn(name = "morador_id")
    private Morador morador;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    public RateioConta() {
		
	}
	public RateioConta(Long id, BigDecimal valor, SituacaoRateio situacao, Morador morador, Conta conta) {
		
		this.id = id;
		this.valor = valor;
		this.situacao = situacao;
		this.morador = morador;
		this.conta = conta;
	}
    
    
    // Getters e Setters

    public Long getId() { 
    	return id; 
    	}
    public void setId(Long id) { 
    	this.id = id; 
    	}

    public BigDecimal getValor() { 
    	return valor; 
    	}
    public void setValor(BigDecimal valor) { 
    	this.valor = valor; 
    	}

    public SituacaoRateio getSituacao() { 
    	return situacao; 
    	}
    public void setSituacao(SituacaoRateio situacao) { 
    	this.situacao = situacao; 
    	}

    public Morador getMorador() { 
    	return morador; 
    	}
    public void setMorador(Morador morador) { 
    	this.morador = morador; 
    	}

    public Conta getConta() { 
    	return conta; 
    	}
    public void setConta(Conta conta) { 
    	this.conta = conta; 
    	}
	@Override
	public int hashCode() {
		return Objects.hash(conta, id, morador, situacao, valor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RateioConta other = (RateioConta) obj;
		return Objects.equals(conta, other.conta) && Objects.equals(id, other.id)
				&& Objects.equals(morador, other.morador) && situacao == other.situacao
				&& Objects.equals(valor, other.valor);
	}
	
    
}