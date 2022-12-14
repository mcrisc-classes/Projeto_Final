
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class App {

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        EstacionamentoDAO e = new EstacionamentoDAO();

        int a = e.consultarVagasLivres(1);

        System.out.println("RONAAAAAALDINHO: " + a);
    }

}
