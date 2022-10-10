package com.automovel.model.service;

import com.automovel.model.dao.PessoaDAO;
import com.automovel.model.entities.Cliente;
import com.automovel.model.entities.Dono;
import com.automovel.model.entities.Funcionario;
import com.automovel.model.entities.Pessoa;

import java.sql.SQLException;

public class PessoaService {
    PessoaDAO dao = new PessoaDAO();


    public Pessoa selecionarPessoa(int matricula) throws SQLException {
        return dao.selecionarPessoa(matricula);
    }

    public void inserirPessoa(Pessoa pessoa) throws SQLException {

        if(pessoa instanceof Cliente) {
            dao.inserirPessoa(1, pessoa);
        } else if(pessoa instanceof Funcionario) {
            dao.inserirPessoa(2, pessoa);
        } else if(pessoa instanceof Dono){
            dao.inserirPessoa(3, pessoa);
        }

    }

    public void removerPessoa(int matricula) {
        dao.removerPessoa(matricula);
    }
}
