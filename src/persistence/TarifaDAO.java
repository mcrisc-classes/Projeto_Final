package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import modelo.Tarifa;

public class TarifaDAO {

    // -------------------------------------------------------------------------- //
    // Lista todas as tarifas
    // -------------------------------------------------------------------------- //

    public List<Tarifa> listAll() throws PersistenceException {
        List<Tarifa> tarifas = new ArrayList<>();

        try (Connection conn = DataSource.getConnection()) {
            final String query = "SELECT  placa, preco_bloco, dt_pagamento, valor_pago FROM tarifa;";

            try (Statement ps = conn.createStatement()) {
                ResultSet rs = ps.executeQuery(query);

                while (rs.next()) {
                    Tarifa tarifa = new Tarifa();
                    tarifa.setPlaca(rs.getString("placa"));
                    tarifa.setPreco_bloco(rs.getFloat("preco_bloco"));
                    tarifa.setDt_pagamento(rs.getDate("dt_pagamento"));
                    tarifa.setValor_pago(rs.getFloat("valor_pago"));

                    tarifas.add(tarifa);
                }
            }

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return tarifas;
    }

    // -------------------------------------------------------------------------- //
    // Insere novas tarifas
    // -------------------------------------------------------------------------- //

    public void insert(Tarifa tarifa) throws PersistenceException {

        try (Connection conn = DataSource.getConnection()) {
            String query = " INSERT INTO tarifa (placa, preco_bloco, dt_pagamento, valor_pago)" +
                    "VALUE(?, ?, ?, ?);";

            try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, tarifa.getPlaca());
                ps.setFloat(2, tarifa.getPreco_bloco());
                ps.setDate(3, tarifa.getDt_pagamento());
                ps.setFloat(4, tarifa.getValor_pago());
                ps.executeUpdate();

                ResultSet rs = ps.getGeneratedKeys();

            }

        } catch (Exception e) {
            throw new PersistenceException(e);
        }

    }

    // -------------------------------------------------------------------------- //
    // Atualiza dados de uma tarifa
    // -------------------------------------------------------------------------- //

    public void update(Tarifa tarifa) throws PersistenceException {

        try (Connection conn = DataSource.getConnection()) {
            String query = " UPDATE tarifa SET placa = ?, preco_bloco = ? , dt_pagamento = ?, valor_pago = ?" +
                    "WHERE placa = ? ;";

            try (PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setString(1, tarifa.getPlaca());
                ps.setFloat(2, tarifa.getPreco_bloco());
                ps.setDate(3, tarifa.getDt_pagamento());
                ps.setFloat(4, tarifa.getValor_pago());
                ps.setString(5, tarifa.getPlaca());
                ps.executeUpdate();

            }

        } catch (Exception e) {
            throw new PersistenceException(e);
        }

    }

    // -------------------------------------------------------------------------- //
    // Deleta tarifa
    // -------------------------------------------------------------------------- //

    public void delete(Tarifa tarifa) throws PersistenceException {

        try (Connection conn = DataSource.getConnection()) {
            String query = "DELETE FROM tarifa WHERE placa = ?;";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, tarifa.getPlaca());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

}
