package com.example.model;

import java.io.Serializable;

public class Proprietario implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String cpfCnpj;
	private String nome;
	private String endereco;
	private boolean ativo;

	public Proprietario() {
	}

	public Proprietario(int id, String cpfCnpj, String nome, String endereco, boolean ativo) {
		this.id = id;
		this.cpfCnpj = cpfCnpj;
		this.nome = nome;
		this.endereco = endereco;
		this.ativo = ativo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCpfCnpj() {
		return cpfCnpj;
	}

	public void setCpfCnpj(String cpfCnpj) {
		this.cpfCnpj = cpfCnpj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
