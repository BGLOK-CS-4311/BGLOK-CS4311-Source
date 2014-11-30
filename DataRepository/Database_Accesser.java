/**
 * 
 */
package DataRepository;

/**
 * @author jvasquez9
 *
 */

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*Pertained JSch jar file from the following website: www.jcraft.com/jsch/
 * STEPS: 1. Go down to "Download" at the bottom
 * 		  2. Click on jsch-0.1.51.jar
 * 		  3. In Eclipse right-click on the BGLOK project and select properties
 *        4. Click on Add External JARs and search for where you saved the JSch jar file
 *        5. Click open and click OK*/

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import java.sql.Connection;

public class Database_Accesser {
	
    /**
     * Java Program to connect to remote database through SSH using port forwarding
     * @author Pankaj@JournalDev
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
 
//  	  String url = "jdbc:mysql://localhost:3306/";
//	  String dbName = "demo";
//	  String driver = "com.mysql.jdbc.Driver";
//	  String userName = "root"; 
//	  String password = "mypasswd";
//	  try {
//	  Class.forName(driver).newInstance();
//	  Connection conn = DriverManager.getConnection(url+dbName,userName,password);
//	  
//	  conn.close();
//	  } catch (Exception e) {
//	  e.printStackTrace();
//	  }


    	
        int lport=5656;
        String rhost="earth.cs.utep.edu"; //secure.journaldev.com
        String host="earth.cs.utep.edu";  //secure.journaldev.com
        int rport=3306;
        String user="jmontiveros"; //sshuser
        String password="i<3domokun18"; //sshpassword
        String dbuserName = "recon13.cs.utep.edu"; //mysql
        String dbpassword = "2014team1"; //mysql123
        String url = "jdbc:mysql://localhost:"+lport+"/mydb";
        String driverName="com.mysql.jdbc.Driver";
        Connection conn = null;
        Session session= null;
        
        try{
            //Set StrictHostKeyChecking property to no to avoid UnknownHostKey issue
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            JSch jsch = new JSch();
            session=jsch.getSession(user, host, 22);
            session.setPassword(password);
            session.setConfig(config);
            System.out.println("IT WORKES UP TO HERE");
            session.connect(); //line that's causing problems
            System.out.println("Connected");
            int assinged_port=session.setPortForwardingL(lport, rhost, rport);
            System.out.println("localhost:"+assinged_port+" -> "+rhost+":"+rport);
            System.out.println("Port Forwarded"); 
            //mysql database connectivity
            Class.forName(driverName).newInstance();
            conn = DriverManager.getConnection (url, dbuserName, dbpassword);
            System.out.println ("Database connection established");
            System.out.println("DONE");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(conn != null && !conn.isClosed()){
                System.out.println("Closing Database Connection");
                conn.close();
            }
            if(session !=null && session.isConnected()){
                System.out.println("Closing SSH Connection");
                session.disconnect();
            }
        }
    }
	
	public void storeData(String tableName, String columnName, String value){
		
	}
	
	public String retrieveData(String tableName, String columnName, String value){
		//Statement St = conn.createStatement();
		//ResultSet res = st.executeQuery("SELECT * FROM tableName");
		
		return "false";
	}
	
	public void deleteData(String tableName, String columnName, String value){
		
	}

	public String addData(String string, String string2, String iPAddress) {
		// TODO Auto-generated method stub
		return null;
	}

}
