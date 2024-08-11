package com.example.dao;

import com.example.model.Proprietario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioDAO {

    public void insert(Proprietario proprietario) throws SQLException {
        String sql = "INSERT INTO proprietario (cpf_cnpj, nome, endereco, ativo) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, proprietario.getCpfCnpj());
            ps.setString(2, proprietario.getNome());
            ps.setString(3, proprietario.getEndereco());
            ps.setBoolean(4, proprietario.isAtivo());
            ps.executeUpdate();
        }
    }

    public void update(Proprietario proprietario) throws SQLException {
        String sql = "UPDATE proprietario SET cpf_cnpj = ?, nome = ?, endereco = ?, ativo = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, proprietario.getCpfCnpj());
            ps.setString(2, proprietario.getNome());
            ps.setString(3, proprietario.getEndereco());
            ps.setBoolean(4, proprietario.isAtivo());
            ps.setInt(5, proprietario.getId());
            ps.executeUpdate();
        }
    }

    public void updateStatus(Proprietario proprietario) throws SQLException {
        String sql = "UPDATE proprietario SET ativo = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, proprietario.isAtivo());
            ps.setInt(2, proprietario.getId());
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM proprietario WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public Proprietario findById(int id) throws SQLException {
        Proprietario proprietario = null;
        String sql = "SELECT * FROM proprietario WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    proprietario = new Proprietario(
                        rs.getInt("id"),
                        rs.getString("cpf_cnpj"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getBoolean("ativo")
                    );
                }
            }
        }
        return proprietario;
    }
    
    public List<Proprietario> listByStatus(boolean ativo) throws SQLException {
        List<Proprietario> proprietarios = new ArrayList<>();
        String sql = "SELECT * FROM proprietario WHERE ativo = ? ORDER BY id ASC";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setBoolean(1, ativo);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Proprietario proprietario = new Proprietario(
                        rs.getInt("id"),
                        rs.getString("cpf_cnpj"),
                        rs.getString("nome"),
                        rs.getString("endereco"),
                        rs.getBoolean("ativo")
                    );
                    proprietarios.add(proprietario);
                }
            }
        }
        return proprietarios;
    }

}
