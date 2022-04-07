/**
This package contains the interfaces and the DB implementations of the application.
 */
package resources;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Database connection class.
 * @author Jorge_Adrián.
 */
public class DBconnection {
     private ResourceBundle configFile;
  
    private String conn;
    private String dbUser;
    private String dbPass;
    private String Driver;

    
    /**
     * Class constructor
     * Here the config
     */
    public DBconnection() {

        configFile = ResourceBundle.getBundle("resources.Config");

     
        conn = configFile.getString("Conn");
        dbUser = configFile.getString("DBUser");
        dbPass = configFile.getString("DBPass");
      Driver = configFile.getString("Driver");

    }

    public Connection openConnection() {

        Connection con = null;

        try {
            //String url = "jdbc:mysql://localhost/nombreBaseDatos";
            //con =  DriverManager.getConnection(url+"?" +"user=____&password=_____");
            Class.forName(Driver);
            con = DriverManager.getConnection(conn, dbUser, dbPass);
            
            
            
            if(con != null){
                System.out.println("resources.DBconnection.openConnection()");
            }
            
        } catch (SQLException e){
            
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(DBconnection.class.getName()).log(Level.SEVERE, null, ex);
         }
        return con;
    }

    public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {

        if (stmt != null) {
            stmt.close();
        }
        if (con != null) {
            con.close();
        }

    }

}

