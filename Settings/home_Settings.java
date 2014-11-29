package Settings;

import DataRepository.Database_Accesser;
/**
 * 
 */

/**
 * @author jvasquez9
 *
 */
public class home_Settings extends Settings{

	Database_Accesser dbQuery = new Database_Accesser();
	
	/**
	 * 
	 * @return
	 * @ensures \result returns a String array of all the device settings, 
	 * 	each column representing the IP 	address, type of device, and location. 
	 */
	public String[][] sendDeviceSettings(String device) {
		String [][] newSettings = new String[4][4];
		newSettings[0][1] = dbQuery.retrieveData("Hardware", "ipAddress", device);
		newSettings[0][2] = dbQuery.retrieveData("Hardware", "name", device);
		newSettings[0][3] = dbQuery.retrieveData("Hardware", "type", device);
		newSettings[0][4] = dbQuery.retrieveData("Hardware", "status", device);
		return newSettings;
	}//end send device settings
	
	
	/**
	 * 
	 * @return
	 * @ensures \result returns the degree preference  
	 */
	public String sendDegreePreference(){
		
		return "true";
	}//end send degree preference
	
	
	/**
	 * 
	 * @param deviceIP
	 * @return
	 * @requires deviceIP != null
	 * @requires deviceIP exists in the database
	 * @ensures \result == True iff device was successfully removed, 
	 * 	else \result = False if errors were 			encountered
	 */
	public Boolean removeDevice(String deviceIP){
	
		return false;
	}
	
	
	/**
	 * 
	 * @param IPAddress
	 * @param type
	 * @param location
	 * @return
	 * @requires (IPAddress != null) && (type != null) && (location != null)
	 * @ensures \result == True iff device was successfully removed, 
	 * 	else \result = False if errors were 			encountered.
	 */
	public Boolean addDevice(String IPAddress, String type, String location){
		
		return false;
	}

}
