package com.automovel.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public static final String URL = "jdbc:mysql://localhost:3306/70automoveis";
    public static final String USER = "root";
    public static final String PASS = "root";


    public Connection conecta() throws SQLException {

        try{
            return DriverManager.getConnection(URL, USER, PASS);
        }catch (SQLException e){
            throw new SQLException(e);
        }

    }

}
