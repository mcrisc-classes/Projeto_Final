package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Carros;

public class CarroDAO {

    // -------------------------------------------------------------------------- //
    // Responsavel por encontrar um carro especifico no banco de dados pela placa
    // -------------------------------------------------------------------------- //
    public Carros findByPlaca(String placa) throws PersistenceException {
        Carros carro = null;

        try (Connection conn = DataSource.getConnection()) {
            final String query = "SELECT placa, descricao, duracao, quantidade_blocos, hora_entrada, hora_saida FROM carros WHERE placa = ?;";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, placa);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    carro = new Carros();
                    carro.setPlaca(rs.getString("placa"));
                    carro.setDescricao(rs.getString("descricao"));
                    carro.setDuracao(rs.getInt("duracao"));
                    carro.setQuantidade_blocos(rs.getInt("quantidade_blocos"));
                    carro.setHora_entrada(rs.getString("hora_entrada"));
                    carro.setHora_saida(rs.getString("hora_saida"));
                }
            }

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return carro;
    }

    // -------------------------------------------------------------------------- //
    // Lista os carros presente no banco
    // -------------------------------------------------------------------------- //
    public List<Carros> listAll() throws PersistenceException {
        List<Carros> carros = new ArrayList<>();

        try (Connection conn = DataSource.getConnection()) {
            final String query = "SELECT placa, descricao, duracao, quantidade_blocos, hora_entrada, hora_saida FROM carros;";

            try (Statement ps = conn.createStatement()) {
                ResultSet rs = ps.executeQuery(query);

                while (rs.next()) {
                    Carros carro = new Carros();
                    carro.setPlaca(rs.getString("placa"));
                    carro.setDescricao(rs.getString("descricao"));
                    carro.setDuracao(rs.getInt("duracao"));
                    carro.setQuantidade_blocos(rs.getInt("quantidade_blocos"));
                    carro.setHora_entrada(rs.getString("hora_entrada"));
                    carro.setHora_saida(rs.getString("hora_saida"));

                    carros.add(carro);
                }
            }

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return carros;
    }

    // -------------------------------------------------------------------------- //
    // Insere valores novos na tabela, diferenciando updats de inserts
    // -------------------------------------------------------------------------- //
    public Carros save(Carros carros) throws PersistenceException {
        try (Connection conn = DataSource.getConnection()) {
            if (carros.isNew()) {
                insert(conn, carros);
            } else {
                update(conn, carros);
            }

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return carros;
    }

    // -------------------------------------------------------------------------- //
    // Salva a data e hora que o carro deixa o estacionamento
    // -------------------------------------------------------------------------- //

    public Carros saveSaida(Carros carros) throws PersistenceException {
        try (Connection conn = DataSource.getConnection()) {

            updateSaida(conn, carros);

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return carros;
    }

    // -------------------------------------------------------------------------- //
    // Insere um novo carro
    // -------------------------------------------------------------------------- //

    private void insert(Connection conn, Carros carros) throws SQLException {

        String query = "INSERT INTO carros (placa, descricao, duracao, quantidade_blocos, hora_entrada,  hora_saida) VALUES (?, ?, 0 ,0, now(), null);";
        try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, carros.getPlaca());
            ps.setString(2, carros.getDescricao());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                carros.setPlaca(rs.getString(1));
            }
        }
    }

    // -------------------------------------------------------------------------- //
    // Guarda data e hora da saida de um carro
    // -------------------------------------------------------------------------- //

    private void updateSaida(Connection conn, Carros carros) throws SQLException {

        String query = "UPDATE carros SET hora_saida = now() WHERE placa =?;";
        try (PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, carros.getPlaca());
            ps.executeUpdate();
        }
    }

    // -------------------------------------------------------------------------- //
    // Muda dados caso necessário
    // -------------------------------------------------------------------------- //

    private void update(Connection conn, Carros carros) throws SQLException {

        String query = "UPDATE carros SET placa = ?, descricao = ?,duracao = ?,quantidade_blocos = ?,hora_entrada = ?, hora_saida = ? WHERE placa = ?;";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(7, carros.getPlaca());
            ps.setString(1, carros.getPlaca());
            ps.setString(2, carros.getDescricao());
            ps.setInt(3, carros.getDuracao());
            ps.setInt(4, carros.getQuantidade_blocos());
            ps.setString(5, carros.getHora_entrada());
            ps.setString(6, carros.getHora_saida());

            ps.executeUpdate();
        }
    }

    // -------------------------------------------------------------------------- //
    // Atualiza dados do carro
    // -------------------------------------------------------------------------- //

    public void update(Carros carros) throws SQLException, PersistenceException {

        try (Connection conn = DataSource.getConnection()) {
            String query = "UPDATE carros SET placa = ?, descricao = ?,duracao = ?,quantidade_blocos = ?,hora_entrada = ?, hora_saida = ? WHERE placa = ?;";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(7, carros.getPlaca());
                ps.setString(1, carros.getPlaca());
                ps.setString(2, carros.getDescricao());
                ps.setInt(3, carros.getDuracao());
                ps.setInt(4, carros.getQuantidade_blocos());
                ps.setString(5, carros.getHora_entrada());
                ps.setString(6, carros.getHora_saida());

                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

    }

    // -------------------------------------------------------------------------- //
    // Limpar data de horário e saida quando o carro for embora
    // -------------------------------------------------------------------------- //

    public void limparDate(Carros carros) throws PersistenceException {

        try (Connection conn = DataSource.getConnection()) {

            String query = "UPDATE carros SET hora_saida = null, hora_entrada = null WHERE placa =?;";

            try (PreparedStatement ps = conn.prepareStatement(query)) {

                ps.setString(1, carros.getPlaca());
                ps.executeUpdate();
            }

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

    }

    public void delete(Carros carros) throws PersistenceException {
        try (Connection conn = DataSource.getConnection()) {
            String query = "DELETE FROM carros WHERE placa = ?;";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, carros.getPlaca());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

}