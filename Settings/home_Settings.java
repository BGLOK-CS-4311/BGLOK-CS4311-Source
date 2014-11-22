package Settings;
/**
 * 
 */

/**
 * @author jvasquez9
 *
 */
public class home_Settings extends Settings{

	/**
	 * 
	 * @return
	 * @ensures \result returns a String array of all the device settings, 
	 * 	each column representing the IP 	address, type of device, and location. 
	 */
	public String[][] sendDeviceSettings() {
		String [][] newSettings;
		return newSettings;
	}//end send device settings
	
	
	/**
	 * 
	 * @return
	 * @ensures \result returns the degree preference  
	 */
	public String sendDegreePreference(){
		
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
