//Class which gives us the connection to our database
package rohanbakery;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConnectToDatabase {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            //Register driver and get the connection using username - root and password - lucifer@000
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rohankitchen","root","lucifer@000");
            return conn;
        } catch(Exception e) {
            //Displays dialog if connection cannot be established
            JOptionPane.showMessageDialog(null, "Connection cannot be established");
            return null;
        }
    }
}
