package com.automovel.model.entities;

import com.automovel.view.Main;
import java.sql.SQLException;

public abstract class Pessoa {

	private String nomePessoa;
	private String cpfPessoa;
	private String telefonePessoa;
	private String generoPessoa;
    private Integer idadePessoa;
	private Integer matriculaPessoa;
	private Integer senhaPessoa;

	public static Pessoa cadastrar(String nome, String cpf, String telefone, String genero, int idade, int matricula, int senha, double salario) {
		Pessoa pessoa;
		if (salario == 0) {
			pessoa = new Cliente(nome, cpf, telefone, genero, idade, matricula, senha);
		} else {
			pessoa = new Funcionario(nome, cpf, telefone, genero, idade, matricula, senha, salario, 2);
		}
		return pessoa;
	}

	public Pessoa validarLogin(int senha){
		if(this.getSenha() == senha){
			return this;
		}
		throw new RuntimeException("Senha incorreta!");
	}
	public abstract String[] menu();
	public Pessoa(String nome, String cpf, String telefone, String genero, int idade, int matricula, int senha) {
		super();
		this.nomePessoa = nome;
		this.cpfPessoa = cpf;
		this.telefonePessoa = telefone;
		this.generoPessoa = genero;
		this.idadePessoa = idade;
		this.matriculaPessoa = matricula;
		this.setSenha(senha);
	}
	public static void escolhaMenu(String[] opcoes, int escolha) throws SQLException {
		if (escolha == opcoes.length) {
			Main.logar();
		} else if (escolha < 1 || escolha > opcoes.length) {
			Main.menu();
		} else {
			switch (escolha) {
				case 1 -> Main.listarAutomovel();
				case 2 -> Main.cadastrarAutomovel(-1, 0);
				case 3 -> Main.editarAutomovel();
				case 4 -> Main.excluirAutomovel();
				case 5 -> Main.venderAutomovel();
				case 6 -> Main.cadastrarPessoa(2);
				case 7 -> Main.removerPessoa();
			}
		}
	}

	@Override
	public String toString() {
		return "NOME:" + nomePessoa + ", CPF:" + cpfPessoa + ", TELEFONE:" + telefonePessoa + ", GENERO:" + generoPessoa + ", IDADE:"
				+ idadePessoa + ", MATRICULA:" + matriculaPessoa;
	}
	public String getNome() {
		return nomePessoa;
	}
	public int getMatricula() {
		return matriculaPessoa;
	}
	public int getSenha() {
		return senhaPessoa;
	}
	public void setSenha(int senha) {
		this.senhaPessoa = senha;
	}
	public String getCpf() {
		return cpfPessoa;
	}
	public String getTelefone() {
		return telefonePessoa;
	}
	public String getGenero() {
		return generoPessoa;
	}
	public Integer getIdade() {
		return idadePessoa;
	}
}