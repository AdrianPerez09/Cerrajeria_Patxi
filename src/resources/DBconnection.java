package resources;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DBconnection {


	private static final String FILENAME = "model/Config";
	
	private ResourceBundle configFile;
	private String url;
	private String user;
	private String pass;
	
	
	public DBconnection() {
		
		
		
		configFile = ResourceBundle.getBundle(FILENAME);
		url = configFile.getString("URL");
		user = configFile.getString("USER");
		pass = configFile.getString("PASSWORD");
		
		
		
		}
		
	
	public Connection  openConnection(){
			
		 Connection con=null;
		
		 try {
		  //String url = "jdbc:mysql://localhost/nombreBaseDatos";
		  //con =  DriverManager.getConnection(url+"?" +"user=____&password=_____");
			 
		  con = DriverManager.getConnection(url, user, pass);

		} catch (SQLException e) {
			
		 }
		return con;	
		}
	
	public void closeConnection(PreparedStatement stmt, Connection con) throws SQLException {
		
		if (stmt != null)
			stmt.close();
		if (con != null)
			con.close();
		
	}
	
	
	
}