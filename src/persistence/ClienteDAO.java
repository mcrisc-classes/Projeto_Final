package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;;

public class ClienteDAO {

    public Cliente findByCpf(String cpf) throws PersistenceException {
        Cliente cliente = null;

        try (Connection conn = DataSource.getConnection()) {
            final String query = "SELECT cpf, n_cliente, telefone,observacoes,placa FROM cliente WHERE cpf = ?;";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, cpf);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    cliente = new Cliente();
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setN_cliente(rs.getInt("n_cliente"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setObservacoes(rs.getString("observacoes"));
                    cliente.setPlaca(rs.getString("placa"));

                }
            }

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return cliente;
    }

    public List<Cliente> listAll() throws PersistenceException {
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conn = DataSource.getConnection()) {
            final String query = "SELECT cpf, n_cliente, telefone,observacoes,placa FROM cliente;";

            try (Statement ps = conn.createStatement()) {
                ResultSet rs = ps.executeQuery(query);
                Cliente cliente = new Cliente();
                while (rs.next()) {

                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setN_cliente(rs.getInt("n_cliente"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setObservacoes(rs.getString("observacoes"));
                    cliente.setPlaca(rs.getString("placa"));

                    clientes.add(cliente);
                }
            }

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }

        return clientes;
    }

    public void delete(Cliente cliente) throws PersistenceException {
        try (Connection conn = DataSource.getConnection()) {
            String query = "DELETE FROM cliente WHERE cpf = ?;";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setString(1, cliente.getCpf());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
    }

    private void insert(Connection conn, Cliente cliente) throws SQLException {
        String query = "INSERT INTO cliente (cpf, n_cliente, telefone,observacoes,placa) VALUES (?, ?, ?, ?, ?);";
        try (PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, cliente.getCpf());
            ps.setInt(2, cliente.getN_cliente());
            ps.setString(3, cliente.getTelefone());
            ps.setString(4, cliente.getObservacoes());
            ps.setString(5, cliente.getPlaca());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                cliente.setCpf(rs.getString(1));
            }
        }
    }

    private void update(Connection conn, Cliente cliente) throws SQLException {

        String query = "UPDATE cliente SET n_cliente = ?, telefone = ?,observacoes = ?,placa = ? WHERE cpf = ?;";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setInt(1, cliente.getN_cliente());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getObservacoes());
            ps.setString(4, cliente.getPlaca());
            ps.setString(5, cliente.getCpf());
            ps.executeUpdate();
        }
    }

    public static void main(String[] args) throws PersistenceException {
        ClienteDAO c = new ClienteDAO();
        Cliente cliente = c.findByCpf("450454234-02");
        System.out.println(cliente.getTelefone());

    }
}