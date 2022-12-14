package persistence;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.Estacionamento;

public class EstacionamentoDAO {

    Estacionamento estacionamento = null;

    public int consultarVagasLivres(int id) throws PersistenceException {

        try (Connection conn = DataSource.getConnection()) {
            String query = "SELECT vagas_livre FROM estacionamento WHERE id = ?";

            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, id);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    estacionamento = new Estacionamento();
                    estacionamento.setVagas_livres(rs.getInt("vagas_livre"));

                }
            }

        } catch (Exception e) {
            throw new PersistenceException(e);
        }

        return estacionamento.getVagas_livres();
    }

}