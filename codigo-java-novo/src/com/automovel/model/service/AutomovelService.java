package com.automovel.model.service;

import com.automovel.model.dao.AutomovelDAO;
import com.automovel.model.entities.Carro;
import com.automovel.model.entities.Moto;

import java.sql.SQLException;
import java.util.ArrayList;

public class AutomovelService {
    AutomovelDAO dao = new AutomovelDAO();


    public void cadastrarCarro(Carro carro) throws SQLException {
        dao.inserirCarro(carro);
    }

    public void cadastrarMoto(Moto moto) throws SQLException {
        dao.inserirMoto(moto);
    }

    public ArrayList<Carro> listarCarro() throws SQLException {
        return dao.buscarCarro();
    }

    public ArrayList<Moto> listarMoto() throws SQLException {
        return dao.buscarMoto();
    }

    public ArrayList<Carro> listarCarroVendido() throws SQLException {
        return dao.buscarCarroVendido();
    }

    public ArrayList<Moto> listarMotoVendida() throws SQLException {
        return dao.buscarMotoVendida();
    }

    public int verificarPlaca(String placa, int opcao) throws SQLException {
        return dao.verificarPlaca(placa, opcao);
    }

    public void excluirAutomovel(String placa, int opcao) {
        dao.removerAutomovel(placa, opcao);
    }

    public void venderAutomovel(String placa, String nome, int opcao) throws SQLException {
        dao.venderAutomovel(placa, nome, opcao);
    }
}
