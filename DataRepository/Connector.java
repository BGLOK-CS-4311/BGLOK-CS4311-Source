package DataRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
	static Connection connect;
	
	Connector(){
		
	}
	
	public static void main(String [] args){
		final String DRIVER = "com.mysql.jdbc.Driver";
		
		final String HOST = "jdbc:mysql://recon19.cs.utep.edu:22/cs4311team1fa14";
		final String USER = "cs4311team1fa14";
		final String PWD = "2014team1";
		final String DB = "cs4311team1fa14";
		
		/*final String HOST = "jdbc:mysql://192.168.1.139:3306/DigitalHome";
		final String USER = "root";
		final String PWD = "2014team1";
		final String DB = "DigitalHome";
		 */
		
		try{
			//Register JDBC Driver
			Class.forName(DRIVER);
			
			//Open connection
			System.out.println("Connecting");
			connect = DriverManager.getConnection(HOST, USER, PWD);
		
		} catch (SQLException | ClassNotFoundException e) {
			//System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}
}