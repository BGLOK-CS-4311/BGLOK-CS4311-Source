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
		
		
		//checking if any of the queries returned false in any way
		if(newSettings[0][1].equals("Error")){
			System.out.println("Device IPAddress does not exsist, an error has occured");
		}//end ip error
		
		else if(newSettings[0][2].equals("Error")){
			System.out.println("Device name does not exsist, an error has occured");
		}
		else if(newSettings[0][3].equals("Error")){
			System.out.println("Device type does not exsist, an error has occured");
		}
		else if(newSettings[0][4].equals("Error")){
			System.out.println("Device status does not exsist, an error has occured");
		}
		
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
	 * 	else \result = False if errors were encountered
	 */
	public Boolean removeDevice(String deviceIP){
		String results;
		results = dbQuery.removeData("Hardware", "IPAddress", deviceIP );
		
		if(results.equals("Deleted")){
			return true;
		}
		else{
			return false;
		}
	}//end remove Device
	
	
	/**
	 * 
	 * @param IPAddress
	 * @param type
	 * @param location
	 * @return
	 * @requires (IPAddress != null) && (type != null) && (location != null)
	 * @ensures \result == True iff device was successfully removed, 
	 * 	else \result = False if errors were encountered.
	 */
	public Boolean addDevice(String IPAddress, String type, String name, String status){
		String ipResult = dbQuery.addData("Hardware", "IPAddress", IPAddress);
		String typeResult = dbQuery.addData("Hardware", "Type", type);
		String nameResult = dbQuery.addData("Hardware", "Name", name);
		String statusResult = dbQuery.addData("Hardware", "Status", status);
		
		/**
		 * Checks if all additions have passed, else, we return a false
		 */
		if(ipResult.equals("Added") && typeResult.equals("Added") && nameResult.equals("Added")
				&& statusResult.equals("Added")){
			return true;
		}//end all if
		
		else if(ipResult.equals("Error")){
			System.out.println("IP Result error failed");
			return false;
		}//end else if ip
		
		else if(typeResult.equals("Error")){
			System.out.println("Type Result error failed");
			return false;
		}//end else if type
		
		else if(nameResult.equals("Error")){
			System.out.println("IP Result error failed");
			return false;
		}//end name result else if
		
		else if(statusResult.equals("Error")){
			System.out.println("IP Result error failed");
			return false;
		}//end else if status
		
		else{
			return false;
		}
	}//end add device

}
