package Settings;

import DataRepository.Database_Accesser;

/**
 * 
 * @author john
 *
 */
public abstract class Settings {
	
	//column name and value are the 2 
	//values needed for the db query to
	//get the values of the hardware settings
	//these values will have to be inputs 
	//or at least taken from somewhere
	private String columnName;
	private String value;
	Database_Accesser dbQuery = new Database_Accesser();

	/**
	 * 
	 * @return
	 * @ensures \result returns a String array of all the device settings, 
	 * each column representing the IP 	address, type of device, and location. 
	 */
	public String [][] sendDeviceSettings(){
		String [][] temp;

		String ipResults += dbQuery.retrieveData("Hardware", "IPAddress", "*");//get all hardware that has an ip address
		String typeResults += dbQuery.retrieveData("Hardware", "Type", "*");//get all hardware types
		String locationResults += dbQuery.retrieveData("Hardware", "Location", "*");//get all hardware that has a locaiton
		

		//need to test this, doesn't look correct
		temp[0][] = ipResults.split(",");
		temp[1][] = typeResults.split(",");
		temp[2][] = locationResults.split(",");

		return temp;
	}
	
	public void know_Settings(){
		//unsure of which settings we need to know. just getting all of them right now
		String settings = dbQuery.retrieveData("Settings", "Home","*");
	}

}
