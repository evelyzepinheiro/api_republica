package com.cefetmg.evelyze.dto;

import com.cefetmg.evelyze.entities.Morador;

public class MoradorDTO {

	private Long id;
	private String nome;
	private Long cpf;
	private String data_nascimento;
	private String celular;
	private String email;
	
	public MoradorDTO() {
		
	}

	public MoradorDTO(Morador morador) {
		this.id = morador.getId();
		this.nome = morador.getNome();
		this.cpf = morador.getCpf();
		this.data_nascimento = morador.getData_nascimento();
		this.celular = morador.getCelular();
		this.email = morador.getEmail();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Long getCpf() {
		return cpf;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public String getCelular() {
		return celular;
	}

	public String getEmail() {
		return email;
	}

	
	
}
