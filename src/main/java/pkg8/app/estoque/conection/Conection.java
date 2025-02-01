package pkg8.app.estoque.conection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
    private static final String URL = "jdbc:mysql://localhost:3306/dadosprodutos";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection conn;

    private Conection() {
        // Construtor privado para evitar instanciação
    }

    public static Connection getConexao() {
        try {
            if (conn == null || conn.isClosed()) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
