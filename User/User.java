package User;

import DataRepository.Database_Accesser;
/**
 * 
 */

/**
 * @author jvasquez9
 *
 */
public abstract class User {
	
	private String username;
	private int pin;
	private String currentUser;
	private String password; 
	
	//need to access database so we are creating 
	//an object to do so
	Database_Accesser dblink = new Database_Accesser();
	

	private void know_Username(){
		//gets the user name and sets that to current 
		//user, will need to pix this --john
		currentUser = username;
	}//end know username
	
	private void know_pin(){
		String pinString = Integer.toString(pin);
		dblink.retrieveData("User", "pin", pinString);
	}//end know pin
	
	private void verify_Login(){
		String password = "";
		dblink.retrieveData("User", "Username", username);
		dblink.retrieveData("User", "Username", password);
	}//end verify login
	
	public String getUser(String _username){
		return username = _username;
	}//end get user
	
	/**
	 * **Need to double check contract, info is not 
	 * completely accurate --john
	 * @param user
	 * 
	 */
	public void send_User_Info(String user){
		//the result of our db query
		String results; 
		//getting the user name from the db
		results = dblink.retrieveData("user","all_users", username );
		System.out.println("Username information " + results);
	}//end send_User_Info
	
}
