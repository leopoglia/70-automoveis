package com.automovel.model.entities;

import java.util.Scanner;

public class Funcionario extends Pessoa {

	private Double salario;
	private int cargo;

	public Funcionario(String nome, String cpf, String telefone, String genero, int idade, int matricula, int senha,
			double salario, int cargo) {
		super(nome, cpf, telefone, genero, idade, matricula, senha);
		this.salario = salario;
		this.cargo = cargo;
	}


	@Override
	public String toString() {
		return super.toString() + "FUNCIONARIO [ SENHA:" + getSenha() + " SALARIO: " + salario + " ]";
	}

	public String[] menu() {
		return new String[] { "(1) LISTAR PRODUTO", "(2) CADASTRAR PRODUTO", "(3) EDITAR PRODUTO",
				"(4) EXCLUIR PRODUTO", "(5) VENDER PRODUTO", "(6) VOLTAR" };
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}
}