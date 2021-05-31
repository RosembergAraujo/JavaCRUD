package ConnectionFactory;

import java.sql.*;

public class ConnectionFactory {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "4321";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3336/pross";

    public static Connection createConnectionToMySQL() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection con = createConnectionToMySQL();

        if (con != null) {
            con.close();
        }
    }
}
