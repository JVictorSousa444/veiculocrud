package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.model.Veiculo;

public class VeiculoDAO {

    private static final Logger LOGGER = Logger.getLogger(VeiculoDAO.class.getName());

    public List<Veiculo> getAllVeiculos() throws SQLException {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT v.id, v.placa, v.renavam, v.id_status, v.id_prop, p.nome AS nome_proprietario, s.status AS nome_status "
                   + "FROM veiculo v "
                   + "JOIN proprietario p ON v.id_prop = p.id "
                   + "LEFT JOIN status_veiculo s ON v.id_status = s.id";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Veiculo veiculo = new Veiculo(
                    rs.getInt("id"),
                    rs.getString("placa"),
                    rs.getString("renavam"),
                    rs.getInt("id_prop"),
                    rs.getInt("id_status"),
                    rs.getString("nome_proprietario")
                );
                veiculo.setNomeStatus(rs.getString("nome_status"));
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao listar veículos", e);
            throw e;
        }
        return veiculos;
    }

    public List<Veiculo> getVeiculosByStatus(int status) throws SQLException {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT v.id, v.placa, v.renavam, v.id_status, v.id_prop, p.nome AS nome_proprietario, s.status AS nome_status "
                   + "FROM veiculo v "
                   + "JOIN proprietario p ON v.id_prop = p.id "
                   + "LEFT JOIN status_veiculo s ON v.id_status = s.id "
                   + "WHERE v.id_status = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, status);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Veiculo veiculo = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("renavam"),
                        rs.getInt("id_prop"),
                        rs.getInt("id_status"),
                        rs.getString("nome_proprietario")
                    );
                    veiculo.setNomeStatus(rs.getString("nome_status"));
                    veiculos.add(veiculo);
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao listar veículos por status", e);
            throw e;
        }
        return veiculos;
    }

    public void addVeiculo(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO veiculo (placa, renavam, id_status, id_prop) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getRenavam());
            ps.setInt(3, veiculo.getIdStatus());
            ps.setInt(4, veiculo.getIdProp());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao adicionar veículo", e);
            throw e;
        }
    }

    public Veiculo getVeiculoById(int id) throws SQLException {
        Veiculo veiculo = null;
        String sql = "SELECT v.id, v.placa, v.renavam, v.id_status, p.nome AS nome_proprietario "
                   + "FROM veiculo v "
                   + "JOIN proprietario p ON v.id_prop = p.id "
                   + "WHERE v.id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    veiculo = new Veiculo(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("renavam"),
                        rs.getInt("id_prop"),
                        rs.getInt("id_status"),
                        rs.getString("nome_proprietario")
                    );
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículo por ID", e);
            throw e;
        }
        return veiculo;
    }

    public void updateVeiculo(Veiculo veiculo) throws SQLException {
        String sql = "UPDATE veiculo SET placa = ?, renavam = ?, id_status = ?, id_prop = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, veiculo.getPlaca());
            ps.setString(2, veiculo.getRenavam());
            ps.setInt(3, veiculo.getIdStatus());
            ps.setInt(4, veiculo.getIdProp());
            ps.setInt(5, veiculo.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar veículo", e);
            throw e;
        }
    }

    public void deleteVeiculo(int id) throws SQLException {
        String sql = "DELETE FROM veiculo WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao deletar veículo", e);
            throw e;
        }
    }
}
