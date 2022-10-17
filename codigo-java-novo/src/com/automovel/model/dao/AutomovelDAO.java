package com.automovel.model.dao;
import com.automovel.model.entities.Carro;
import com.automovel.model.entities.Moto;
import java.sql.*;
import java.util.ArrayList;

public class AutomovelDAO {

    public void inserirCarro(Carro carro) throws SQLException {
        String sql = "insert into carro(modelo, placa, ano, portas, cavalos, estilo, preco) values (?,?,?,?,?,?,?)";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conecta();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, carro.getModelo());
        statement.setString(2, carro.getPlaca());
        statement.setInt(3, carro.getAno());
        statement.setInt(4, carro.getPortas());
        statement.setInt(5,  carro.getCavalos());
        statement.setString(6, carro.getEstilo());
        statement.setDouble(7, carro.getPreco());
        statement.execute();
        connection.close();
    }

    public void inserirMoto(Moto moto) throws SQLException {
        String sql = "insert into moto(modelo, placa, ano, tipo, suspensao, tamanho, preco) values (?,?,?,?,?,?,?)";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conecta();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, moto.getModelo());
        statement.setString(2, moto.getPlaca());
        statement.setInt(3, moto.getAno());
        statement.setString(4, moto.getTipo());
        statement.setDouble(5,  moto.getSuspensao());
        statement.setString(6, moto.getTamanho());
        statement.setDouble(7, moto.getPreco());
        statement.execute();
        connection.close();
    }

    public ArrayList<Carro> buscarCarro() throws SQLException {
        ArrayList<Carro> carroCollection = new ArrayList<>();

        String sql = "select * from carro";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conecta();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet != null && resultSet.next()){
            Carro carro = new Carro(
                    resultSet.getString("modelo"),
                    resultSet.getString("placa"),
                    resultSet.getInt("ano"),
                    resultSet.getInt("portas"),
                    resultSet.getInt("cavalos"),
                    resultSet.getString("estilo"),
                    resultSet.getDouble("preco"),
                    resultSet.getString("dono")
            );
            carroCollection.add(carro);
        }
        connection.close();

        return carroCollection;
    }

    public ArrayList<Moto> buscarMoto() throws SQLException {
        ArrayList<Moto> motoCollection = new ArrayList<>();

        String sql = "select * from moto";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conecta();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet != null && resultSet.next()){
            Moto moto = new Moto(
                    resultSet.getString("modelo"),
                    resultSet.getString("placa"),
                    resultSet.getInt("ano"),
                    resultSet.getString("tipo"),
                    resultSet.getInt("suspensao"),
                    resultSet.getString("tamanho"),
                    resultSet.getDouble("preco"),
                    resultSet.getString("dono")
            );
            motoCollection.add(moto);
        }
        connection.close();

        return motoCollection;
    }

    public ArrayList<Carro> buscarCarroVendido() throws SQLException {
        ArrayList<Carro> carroCollection = new ArrayList<>();

        String sql = "select * from carro where dono is not null";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conecta();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet != null && resultSet.next()){
            Carro carro = new Carro(
                    resultSet.getString("modelo"),
                    resultSet.getString("placa"),
                    resultSet.getInt("ano"),
                    resultSet.getInt("portas"),
                    resultSet.getInt("cavalos"),
                    resultSet.getString("estilo"),
                    resultSet.getDouble("preco"),
                    resultSet.getString("dono")
            );
            carroCollection.add(carro);
        }
        connection.close();
        return carroCollection;
    }

    public ArrayList<Moto> buscarMotoVendida() throws SQLException {
        ArrayList<Moto> motoCollection = new ArrayList<>();

        String sql = "select * from moto where dono is not null";
        Conexao conexao = new Conexao();
        Connection connection = conexao.conecta();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet != null && resultSet.next()){
            Moto moto = new Moto(
                    resultSet.getString("modelo"),
                    resultSet.getString("placa"),
                    resultSet.getInt("ano"),
                    resultSet.getString("tipo"),
                    resultSet.getInt("suspensao"),
                    resultSet.getString("tamanho"),
                    resultSet.getDouble("preco"),
                    resultSet.getString("dono")
            );
            motoCollection.add(moto);
        }
        connection.close();

        return motoCollection;
    }

    public int verificarPlaca(String placa, int opcao) throws SQLException {
        String sql;

        if(opcao == 1) {
            sql = "select * from carro where placa = ?";
        } else {
            sql = "select * from moto where placa = ?";
        }

        Conexao conexao = new Conexao();
        Connection connection = conexao.conecta();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, placa);
        ResultSet resultSet = statement.executeQuery();
        if (resultSet != null && resultSet.next()){
            return resultSet.getInt("placa");
        }
        connection.close();
        return -1;
    }

    public void removerAutomovel(String placa, int opcao) {
        String sql;
        if(opcao == 1) {
            sql = "delete from carro where placa = " + placa;
        }else{
            sql = "delete from moto where placa = " + placa;
        }

        System.out.println(sql);

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

    public void venderAutomovel(String placa, String nome, int opcao) throws SQLException {
        String sql;

        if(opcao == 1) {
            sql = "update carro set dono = '" + nome + "' where placa = " + placa;
        }else{
            sql = "update moto set dono = '" + nome + "' where placa = " + placa;
        }

        Conexao conexao = new Conexao();
        Connection connection = conexao.conecta();
        Statement statement = connection.createStatement();
        statement.execute(sql);
        connection.close();
        //aaaa
    }
}
