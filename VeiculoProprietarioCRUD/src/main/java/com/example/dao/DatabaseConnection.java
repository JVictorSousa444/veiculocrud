package com.example.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {
    private static final Logger LOGGER = Logger.getLogger(DatabaseConnection.class.getName());
    private static final String URL = "jdbc:postgresql://localhost:5432/bdtreinamento";
    private static final String USER = "lucas";
    private static final String PASSWORD = "jl3go5c3";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Driver do PostgreSQL não encontrado", e);
            throw new SQLException("Driver do PostgreSQL não encontrado", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao conectar ao banco de dados", e);
            throw e;
        }
    }
}
