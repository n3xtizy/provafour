package Factory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/prova4", "root", "12344");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}