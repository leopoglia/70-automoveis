package com.automovel.controller;

import com.automovel.model.entities.Cliente;
import com.automovel.model.entities.Funcionario;
import com.automovel.model.entities.Pessoa;
import com.automovel.model.service.PessoaService;

import java.sql.SQLException;

public class PessoaController {
    Pessoa model;

    public Pessoa validarLogin(int matricula, int senha) throws SQLException {
        PessoaService service = new PessoaService();
        model = service.selecionarPessoa(matricula);
        return model.validarLogin(senha);
    }

    public void cadastrar(int opcao, String nome, String cpf, String telefone, String genero, int idade, int matricula, int senha, double salario) throws SQLException {
        Pessoa pessoa = Pessoa.cadastrar(nome, cpf, telefone, genero, idade, matricula, senha, salario);
        PessoaService service = new PessoaService();
        service.inserirPessoa(pessoa);
    }

    public void removerPessoa(int matricula) {
        PessoaService service = new PessoaService();
        service.removerPessoa(matricula);
    }
}
