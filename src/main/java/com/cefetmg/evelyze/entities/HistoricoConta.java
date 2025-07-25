package com.cefetmg.evelyze.entities;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "tb_historicoconta")
public class HistoricoConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "conta_id", nullable = false)
    private Conta conta;

    @ManyToOne
    @JoinColumn(name = "morador_id", nullable = false)
    private Morador morador; // Quem fez a ação

    private LocalDate data;
    
    @Enumerated(EnumType.STRING)
    private AcaoConta acao; // QUITAR, REABRIR, CANCELAR

    public HistoricoConta() {
	}

	public HistoricoConta(Long id, Conta conta, Morador morador, LocalDate data, AcaoConta acao) {
		this.id = id;
		this.conta = conta;
		this.morador = morador;
		this.data = data;
		this.acao = acao; /*CRIADA,QUITADA,	REABERTA,CANCELADA*/
		}
    
    // Getters e setters

    public Long getId() {
        return id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public AcaoConta getAcao() {
        return acao;
    }

    public void setAcao(AcaoConta acao) {
        this.acao = acao;
    }

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acao, conta, data, id, morador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HistoricoConta other = (HistoricoConta) obj;
		return acao == other.acao && Objects.equals(conta, other.conta) && Objects.equals(data, other.data)
				&& Objects.equals(id, other.id) && Objects.equals(morador, other.morador);
	}

	
    
}