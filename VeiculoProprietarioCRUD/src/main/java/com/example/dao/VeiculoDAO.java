package com.example.dao;

import com.example.model.Veiculo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeiculoDAO {
    private static final Logger LOGGER = Logger.getLogger(VeiculoDAO.class.getName());

    public void addVeiculo(Veiculo veiculo) throws SQLException {
        String sql = "INSERT INTO Veiculo (placa, renavam, id_prop) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getRenavam());
            statement.setInt(3, veiculo.getIdProp());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao adicionar veículo", e);
            throw e;
        }
    }

    public void updateVeiculo(Veiculo veiculo) throws SQLException {
        String sql = "UPDATE Veiculo SET placa = ?, renavam = ?, id_prop = ? WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, veiculo.getPlaca());
            statement.setString(2, veiculo.getRenavam());
            statement.setInt(3, veiculo.getIdProp());
            statement.setInt(4, veiculo.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao atualizar veículo", e);
            throw e;
        }
    }

    public void deleteVeiculo(int id) throws SQLException {
        String sql = "DELETE FROM Veiculo WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao deletar veículo", e);
            throw e;
        }
    }

    public Veiculo getVeiculo(int id) throws SQLException {
        String sql = "SELECT * FROM Veiculo WHERE id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Veiculo(
                        resultSet.getInt("id"),
                        resultSet.getString("placa"),
                        resultSet.getString("renavam"),
                        resultSet.getInt("id_prop")
                    );
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao buscar veículo", e);
            throw e;
        }
        return null;
    }

    public List<Veiculo> getAllVeiculos() throws SQLException {
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM Veiculo";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Veiculo veiculo = new Veiculo(
                    resultSet.getInt("id"),
                    resultSet.getString("placa"),
                    resultSet.getString("renavam"),
                    resultSet.getInt("id_prop")
                );
                veiculos.add(veiculo);
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Erro ao listar veículos", e);
            throw e;
        }
        return veiculos;
    }
}
