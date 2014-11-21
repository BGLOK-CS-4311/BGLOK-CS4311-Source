package Settings;

/**
 * 
 * @author john
 *
 */
public abstract class Settings {
	
	/**
	 * 
	 * @return
	 * @ensures \result returns a String array of all the device settings, 
	 * each column representing the IP 	address, type of device, and location. 
	 */
	public String [][] sendDeviceSettings(){
		String [][] newDeviceSettings = new String [1][1];;
		
		return newDeviceSettings;
	}
	
	public void know_Settings(){
		
	}

}
