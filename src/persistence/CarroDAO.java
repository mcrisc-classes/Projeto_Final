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
    public Carros findByPlaca(String cpf) throws PersistenceException {
        Carros carros = null;

        try (Connection conn = DataSource.getConnection()) {
            final String query = "SELECT placa, descricao, duracao, quantidade_blocos, hora_entrada, hora_saida FROM carros WHERE placa = ?;";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, cpf);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    carros = new Carros();
                    carros.setPlaca(rs.getString("placa"));
                    carros.setDescricao(rs.getString("descricao"));
                    carros.setDuracao(rs.getInt("duracao"));
                    carros.setQuantidade_blocos(rs.getInt("quantidade_blocos"));
                    carros.setHora_entrada(rs.getDate("hora_entrada"));
                    carros.setHora_sainda(rs.getDate("hora_saida"));
                }
            }

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return carros;
    }

    // -------------------------------------------------------------------------- //
    // Lista os carros presente no banco
    // -------------------------------------------------------------------------- //
    public List<Carros> listAll() throws PersistenceException {
        List<Carros> carros = new ArrayList<>();

        try (Connection conn = DataSource.getConnection()) {
            final String query = "SELECT placa, descricao, duracao, quantidade_blocos, hora_entrada, hora_saida FROM carros WHERE placa = ?;";

            try (Statement ps = conn.createStatement()) {
                ResultSet rs = ps.executeQuery(query);

                while (rs.next()) {
                    Carros carro = new Carros();
                    carro.setPlaca(rs.getString("placa"));
                    carro.setDescricao(rs.getString("descricao"));
                    carro.setDuracao(rs.getInt("duracao"));
                    carro.setQuantidade_blocos(rs.getInt("quantidade_blocos"));
                    carro.setHora_entrada(rs.getDate("hora_entrada"));
                    carro.setHora_sainda(rs.getDate("hora_saida"));

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

        String query = "INSERT INTO carros (placa, descricao, duracao, quantidade_blocos, hora_entrada, hora_saida) VALUES (?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, carros.getPlaca());
            ps.setString(2, carros.getDescricao());
            ps.setInt(3, carros.getDuracao());
            ps.setInt(4, carros.getQuantidade_blocos());
            ps.setDate(5, carros.getHora_entrada());
            ps.setDate(6, null);
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

        String query = "UPDATE carro SET hora_saida = ? WHEEW placa =?;";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setDate(6, carros.getHora_sainda());

            ps.executeUpdate();
        }
    }

    // -------------------------------------------------------------------------- //
    // Muda dados caso necessário
    // -------------------------------------------------------------------------- //

    private void update(Connection conn, Carros carros) throws SQLException {

        String query = "UPDATE carros SET placa = ?, descricao = ?,duracao = ?,quantidade_blocos = ?,hora_entrada = ?, hora_saida = ? WHERE placa = ?;";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, carros.getPlaca());
            ps.setString(2, carros.getDescricao());
            ps.setInt(3, carros.getDuracao());
            ps.setInt(4, carros.getQuantidade_blocos());
            ps.setDate(5, carros.getHora_entrada());
            ps.setDate(6, carros.getHora_sainda());
            ps.executeUpdate();
        }
    }

}