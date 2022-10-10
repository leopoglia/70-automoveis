package com.automovel.model.entities;

import java.util.Scanner;

public class Dono extends Funcionario {
	
	private Double salarioDono = 30000.0;

	public Dono(String nome, String cpf, String telefone, String genero, int idade, int matricula, int senha, double salarioDono, double salario, int cargo) {
		super(nome, cpf, telefone, genero, idade, matricula, senha, salario, cargo);
		this.salarioDono = salarioDono;
	}
	
	static Scanner sc = new Scanner(System.in);

	public Dono(String nome, String cpf, String telefone, String genero, int idade, int matricula, int senha, int salario, int cargo) {
		super(nome, cpf, telefone, genero, idade, matricula, senha, salario, cargo);
	}


	@Override
	public String toString() {
		return super.toString() + "DONO [ SALARIO: " + salarioDono;
	}

	@Override
	public String[] menu() {	
		return new String[] { "(1) LISTAR", "(2) CADASTRAR PRODUTO", "(3) EDITAR PRODUTO",
				"(4) EXCLUIR PRODUTO", "(5) VENDER PRODUTO", "(6) CADASTRAR FUNCIONÁRIO", "(7) EXCLUIR FUNCIONÁRIO", "(8) VOLTAR"};
	}


}