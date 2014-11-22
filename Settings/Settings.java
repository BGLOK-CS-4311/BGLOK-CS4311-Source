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
	
	/**
	 * 
	 * @return
	 * @ensures \result returns a String array of all the device settings, 
	 * each column representing the IP 	address, type of device, and location. 
	 */
	public String [][] sendDeviceSettings(String _column, String _value){
		String [][] newDeviceSettings;
		
		//setting private strings to inputs
		columnName = _column;
		value = _value;
		
		//creating a new query
		Database_Accesser newQuery = new Database_Accesser();
		
		newQuery.retrieveData("Hardware", columnName, value);
		
		return newDeviceSettings;
	}
	
	public void know_Settings(){
		
	}

}
