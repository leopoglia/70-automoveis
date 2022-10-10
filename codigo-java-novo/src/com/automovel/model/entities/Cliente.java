package com.automovel.model.entities;

public class Cliente extends Pessoa {

	/**
	 * Métodos da classe Cliente
	 */
	public String[] menu() {
		return new String[] { "(1) LISTAR", "(2) VOLTAR" };
	}

	/**
	 * Construtor da classe Cliente
	 */
	public Cliente(String nome, String cpf, String telefone, String genero, int idade, int matricula, int senha) {
		super(nome, cpf, telefone, genero, idade, matricula, senha);
	}

	/**
	 * toString da classe Cliente
	 */
	@Override
	public String toString() {
		return super.toString() + "CLIENTE [";
	}
}