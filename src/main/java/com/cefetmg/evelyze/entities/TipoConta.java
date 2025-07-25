
package com.cefetmg.evelyze.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_tipoconta")
public class TipoConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String observacao;

 
    public TipoConta() {
    }

    public TipoConta(String descricao, String observacao) {
        this.descricao = descricao;
        this.observacao = observacao;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoConta tipoConta = (TipoConta) o;
        return id != null && id.equals(tipoConta.id);
    }

    @Override
    public int hashCode() {
        return 31;
    }
    @Override
    public String toString() {
        return "TipoConta{id=" + id + ", descricao='" + descricao + "'}";
    }
}