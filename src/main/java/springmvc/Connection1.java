package springmvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection1 {
    public Connection connect() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "");

        return con1;

    }
}
