package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DataSource {
	private static Logger logger = Logger.getLogger("localhost");
	private static final String DB_NAME = "comparsasbanco";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			logger.info("Driver JDBC carregado");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/" + DB_NAME,
				DB_USER, DB_PASSWORD);
		return conn;
	}
}