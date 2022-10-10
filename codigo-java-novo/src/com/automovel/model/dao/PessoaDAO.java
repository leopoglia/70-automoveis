package com.automovel.model.dao;

import com.automovel.model.entities.*;

import java.sql.*;

public class PessoaDAO {

    public void inserirPessoa(int cargo, Pessoa pessoa) throws SQLException {
        String sql = "insert into pessoa(nome, cpf, telefone, genero, idade, matricula, senha) values (?,?,?,?,?,?,?)";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conecta();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, pessoa.getNome());
        statement.setString(2, pessoa.getCpf());
        statement.setString(3, pessoa.getTelefone());
        statement.setString(4, pessoa.getGenero());
        statement.setInt(5,  pessoa.getIdade());
        statement.setInt(6, pessoa.getMatricula());
        statement.setDouble(7, pessoa.getSenha());

        statement.execute();
        connection.close();
    }

    public void removerPessoa(int matricula) {
        String sql = "delete from pessoa where matricula = " + matricula;

        try {
            Conexao conexao = new Conexao();
            Connection connection = conexao.conecta();
            Statement statement = connection.createStatement();
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pessoa selecionarPessoa(int matricula) throws SQLException {
        String sql = "select * from pessoa where matricula = ?";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conecta();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, matricula);
        ResultSet resultSet = statement.executeQuery();
        Funcionario pessoa;

        if(resultSet != null) {
            if (resultSet != null && resultSet.next()) {
                pessoa = new Dono(
                        resultSet.getString("nome"),
                        resultSet.getString("cpf"),
                        resultSet.getString("telefone"),
                        resultSet.getString("genero"),
                        resultSet.getInt("idade"),
                        resultSet.getInt("matricula"),
                        resultSet.getInt("salario"),
                        resultSet.getInt("senha"),
                        resultSet.getInt("cargo")
                );

                if(resultSet.getInt("cargo") == 1) {
                    return pessoa;
                }else {
                    return (Funcionario) pessoa;
                }
            }
        }
        connection.close();
        throw new RuntimeException("Não foi possível fazer login");
    }
}
