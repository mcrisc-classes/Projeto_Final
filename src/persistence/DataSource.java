package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DataSource {
	// -------------------------------------------------------------------------- //
	// Informações sobre a conexão
	// -------------------------------------------------------------------------- //
	private static Logger logger = Logger.getLogger("localhost"); // Nome do host
	private static final String DB_NAME = "comparsasbanco"; // Nome do banco
	private static final String DB_USER = "root"; // User do banco
	private static final String DB_PASSWORD = "root"; // Senha do banco

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			logger.info("Driver JDBC carregado");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// -------------------------------------------------------------------------- //
	// Conexão
	// -------------------------------------------------------------------------- //

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/" + DB_NAME,
				DB_USER, DB_PASSWORD);
		return conn;
	}
}