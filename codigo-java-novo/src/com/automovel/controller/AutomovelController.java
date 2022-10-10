package com.automovel.controller;

import com.automovel.model.entities.Automovel;
import com.automovel.model.entities.Carro;
import com.automovel.model.entities.Moto;
import com.automovel.model.service.AutomovelService;

import java.sql.SQLException;
import java.util.ArrayList;

public class AutomovelController {

    public void cadadastrarAutomovel(Automovel automovel) throws SQLException {
        AutomovelService service = new AutomovelService();

        if(automovel instanceof Carro){
            service.cadastrarCarro((Carro) automovel);
        }else if(automovel instanceof Moto){
            service.cadastrarMoto((Moto) automovel);
        }
    }

    public void editarAutomovel(int matricula, Automovel carro) {
    }

    public ArrayList<Carro> listarCarro() throws SQLException {
        return new AutomovelService().listarCarro();
    }

    public ArrayList<Moto> listarMoto() throws SQLException {
        return new AutomovelService().listarMoto();
    }

    public ArrayList<Carro> listarCarroVendido() throws SQLException {
        return new AutomovelService().listarCarroVendido();

    }

    public ArrayList<Moto> listarMotoVendida() throws SQLException {
        return new AutomovelService().listarMotoVendida();

    }

    public int verificarPlaca(String placa, int opcao) throws SQLException {
        return new AutomovelService().verificarPlaca(placa, opcao);
    }

    public void excluirAutomovel(String placa, int opcao) {
        new AutomovelService().excluirAutomovel(placa, opcao);
    }

    public void venderAutomovel(String placa, String nome, int opcao) throws SQLException {
        new AutomovelService().venderAutomovel(placa, nome, opcao);
    }
}
