/**
 * 
 */
package Hardware;

/**
 * @author jvasquez9
 *
 */
public abstract class Sensor extends Hardware {
	
	private int IPAddress;
	private Boolean activate;
	
	/**
	 * This will set the active status of a Sensor to either true or false
	 * @param _activate
	 */
	public void setActivate(Boolean _activate){
		activate = _activate;
	}//end set activate
	
	/**
	 * This will get the active status of a sensor, true or false
	 * @return
	 */
	public Boolean getActivate(){
		return activate;
	}//end getActivate
	
	/**
	 * setting address to ipaddress
	 * @param address
	 */
	public void setIP(int address){
		IPAddress = address;
	}//end setIP
	
	/**
	 * 
	 * @return IP address
	 */
	public int getIP(){
		return IPAddress;
	}//end get IP
	

	/**
	 * 
	 */
	private void sensorReading(){
		//not sure how to code this yet --john
	}
	
	/**
	 * 
	 */
	@Override
	public void sendDeviceStatus(Hardware hardware) {
		// TODO Auto-generated method stub
		super.sendDeviceStatus(hardware);
	}//end sendDevice status
	
	/**
	 * 
	 */
	@Override
	public void setDeviceStatus(Hardware hardware, String status) {
		// TODO Auto-generated method stub
		super.setDeviceStatus(hardware, status);
	}//end set device status
	

	//need to modifiy the sensor.ip address 
	//or see if methods require a sensor object -- john
	
	/**
	 * 
	 * @param IPAddress
	 * @return
	 * @requires ipAddress != null
	 * @requires ipAddress.exists()
	 * @ensures /result= True iff the sensor was successfully activated, else /result = false
	 */
	public Boolean activateSensor(Sensor sensor, int IPAddress){
		//check if IPAddress is null
		if(IPAddress == 0 ){
			//string is empty, throw error
			System.out.println("The IP Address is invalid, please re-enter");
			return false;
		}//end string check if
		
		//string is not null or empty, proceed to add
		else{
			sensor.activate = true;
			return true;
		}//end ip address exists else
		
	}//end activate sensor
	
	
	/**
	 * 
	 * @param sensor
	 * @param IPAddress
	 * @return
	 * @requires ipAddress != null
	 * @requires ipAddress.exists()
	 * @ensures /result= True iff the sensor was successfully activated, else /result = false
	 */
	public Boolean deactivateSensor(Sensor sensor, int IPAddress){
		//check if IPAddress is null
		if(IPAddress == 0 || sensor.IPAddress == 0){
		//string is empty, throw error
			System.out.println("The IP Address is invalid, please re-enter");
			return false;
		}//end string check if
		else{
			sensor.activate = false;
			return true;
		}//end ip address exists else	
		
	}//end deactivate sensor
	
}
