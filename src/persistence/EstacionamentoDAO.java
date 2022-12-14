package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Estacionamento;

public class EstacionamentoDAO {

    Estacionamento estacionamento = null;

    // -------------------------------------------------------------------------- //
    // Retorna os dados do estacionamento
    // -------------------------------------------------------------------------- //

    public Estacionamento consultarEstacionamento() throws PersistenceException {

        try (Connection conn = DataSource.getConnection()) {
            String query = "SELECT id, vagas_totais, vagas_ocupadas, vagas_livre, tipo_bloco  FROM estacionamento";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    estacionamento = new Estacionamento();
                    estacionamento.setId(rs.getInt("id"));
                    estacionamento.setVagas_totais(rs.getInt("vagas_totais"));
                    estacionamento.setVagas_ocupadas(rs.getInt("vagas_ocupadas"));
                    estacionamento.setVagas_livres(rs.getInt("vagas_livre"));
                    estacionamento.setTipo_bloco(rs.getString("tipo_bloco"));

                }
            }

        } catch (Exception e) {
            throw new PersistenceException(e);
        }

        return estacionamento;
    }

    // -------------------------------------------------------------------------- //
    // Ocupar vaga : Subtrai 1 no vagas ocupadas e soma 1 no vagas livres
    // -------------------------------------------------------------------------- //

    public void liberarVaga() throws PersistenceException {

        try (Connection conn = DataSource.getConnection()) {
            String query = "SELECT   id, vagas_totais, vagas_livre, vagas_ocupadas FROM estacionamento";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int vagas_livre, vagas_ocupadas, vagas_totais, id;

                    id = rs.getInt("id");
                    vagas_livre = rs.getInt("vagas_livre") + 1;
                    vagas_ocupadas = rs.getInt("vagas_ocupadas") - 1;
                    vagas_totais = rs.getInt("vagas_totais");

                    if (vagas_livre > 30 || vagas_ocupadas < 0) {
                        throw new PersistenceException("O ilimite de vagas foi excedido! ");
                    }

                    query = "UPDATE estacionamento SET vagas_ocupadas = ?, vagas_livre = ? WHERE id = ?";

                    try (PreparedStatement us = conn.prepareStatement(query)) {
                        us.setInt(1, vagas_ocupadas);
                        us.setInt(2, vagas_livre);
                        us.setInt(3, id);
                        us.executeUpdate();

                    }

                }
            }

        } catch (Exception e) {
            throw new PersistenceException(e);
        }

    }

    // -------------------------------------------------------------------------- //
    // Ocupar vaga : Subtrai 1 do vagas livres e soma 1 do vagas ocupadas
    // -------------------------------------------------------------------------- //

    public void ocuparVaga() throws PersistenceException {

        try (Connection conn = DataSource.getConnection()) {
            String query = "SELECT   id, vagas_totais, vagas_livre, vagas_ocupadas FROM estacionamento";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int vagas_livre, vagas_ocupadas, vagas_totais, id;

                    id = rs.getInt("id");
                    vagas_livre = rs.getInt("vagas_livre") - 1;
                    vagas_ocupadas = rs.getInt("vagas_ocupadas") + 1;
                    vagas_totais = rs.getInt("vagas_totais");

                    if (vagas_ocupadas > 30 || vagas_livre < 0) {
                        throw new PersistenceException("O ilimite de vagas foi excedido! ");
                    }

                    query = "UPDATE estacionamento SET vagas_ocupadas = ?, vagas_livre = ? WHERE id = ?";

                    try (PreparedStatement us = conn.prepareStatement(query)) {
                        us.setInt(1, vagas_ocupadas);
                        us.setInt(2, vagas_livre);
                        us.setInt(3, id);
                        us.executeUpdate();

                    }

                }
            }

        } catch (Exception e) {
            throw new PersistenceException(e);
        }
    }

    // -------------------------------------------------------------------------- //
    // Alterar valor do bloco entre inteiro e meio.
    // -------------------------------------------------------------------------- //

    public void alterarBloco(String bloco) throws PersistenceException {

        try (Connection conn = DataSource.getConnection()) {
            String query = "SELECT   id FROM estacionamento";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int id;

                    id = rs.getInt("id");
                    query = "UPDATE estacionamento SET tipo_bloco = ? WHERE id = ?";

                    try (PreparedStatement us = conn.prepareStatement(query)) {
                        us.setString(1, bloco);
                        us.setInt(2, id);
                        us.executeUpdate();

                    }

                }
            }

        } catch (Exception e) {
            throw new PersistenceException(e);
        }

    }

}