package Settings;

import DataRepository.Database_Accesser;
/**
 * 
 */

/**
 * @author jvasquez9
 *
 */
public class user_Settings extends Settings {

	//our query
	Database_Accesser dbQuery = new Database_Accesser();
	
	/**
	 * From the protocols, this is the 
	 * know all users in the system 
	 * private responsibilities
	 */
	private void knowAllActiveUsers(){
		
	}//end know all active users
	
	/*
	 * in the protocols this is the know
	 * all user account details
	 */
	private void knowAllActiveAccounts(){
		
	}//end know all active accounts
	
	/**
	 * 
	 * @return
	 * @requires 1 <= users exist in the system 
	 * @ensures \result returns a String array of usernames
	 */
	public String [] sendAllUsers(){
		
		String [] results = new String [25];
		//query to get all user names in database
		String rows = dbQuery.retrieveData("Users", "username", "*");
		
		int i = 0;
		while(rows.contains("\n")){
			results[i] = rows;
			i++;
		}//assuming that after each returned result there is a \n, we will read each
		
		return results;
		
	}//end send all users
	
	
	/**
	 * 
	 * @param username
	 * @return
	 * @requires: username != null
	 * @requires: username exists
	 * @ensures \result returns a String array of all the 
	 * 	account details for the specified user.
	 */
	public String [] sendUserAccountDetails(String username){
		String [] results = new String[10];
		
		//checking if user name is null or empty
		if(username.equals("") || username == null){
			System.out.println("Username cannot be empty, please enter a user name");
			results[0] = "error";
			return results;
		}
		//getting all tables except for pin and password
		else{
			results[0] = dbQuery.retrieveData("Users", "username", username);
			results[1] = dbQuery.retrieveData("Users", "Fname", username);
			results[2] = dbQuery.retrieveData("Users", "Lname", username);
			results[3] = dbQuery.retrieveData("Users", "Utype", username);
			
			return results;
		}
	}//end send user account details
	
	/**
	 * 
	 * @param username
	 * @return
	 * @requires username != null 
	 * @ensures \result = True iff the user was successfully removed from the system, 
	 * 	else \result = false if the user couldn’t be removed.  
	 */
	public Boolean removeUser(String username){
		dbQuery.deleteData("User", "username", username);
	}//end remove user
	
	
	/**
	 * 
	 * @param user
	 * @return
	 * @requires: user != null 
	 * @ensures \result = True iff the user was successfully added to the system, 
	 * 	else \result = false if the user couldn’t be added.
	 */
	public Boolean addUser(String user){
		dbQuery.insertData("User", "username", user);		
	}//end add user
	
	/**
	 * 
	 * @param user
	 * @return
	 * @requires: user != null 
	 * @ensures \result = True iff the user was successfully modified in the system, 
	 * 	else \result = false if the user account details couldn’t be changed. 
	 */
	public Boolean modifyUser(String user){
		dbQuery.updateData("User", "username", user);	
	}//end modify user

	
}
