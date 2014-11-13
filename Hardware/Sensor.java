/**
 * 
 */
package Hardware;

/**
 * @author jvasquez9
 *
 */
public abstract class Sensor extends Hardware {
	
	@Override
	public void sendDeviceStatus(Hardware hardware) {
		// TODO Auto-generated method stub
		super.sendDeviceStatus(hardware);
	}
	
	@Override
	public void setDeviceStatus(Hardware hardware, String status) {
		// TODO Auto-generated method stub
		super.setDeviceStatus(hardware, status);
	}
	

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
	public Boolean activateSensor(Sensor sensor, String IPAddress){
		//check if IPAddress is null
		if(IPAddress.equals("") || IPAddress == null || sensor.IPAddress == false){
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
	public Boolean deactivateSensor(Sensor sensor, String IPAddress){
		//check if IPAddress is null
		if(IPAddress.equals("") || IPAddress == null || sensor.IPAddress == false){
		//string is empty, throw error
			System.out.println("The IP Address is invalid, please re-enter");
			return false;
		}//end string check if
		else{
			sensor.activate = false;
			return true;
		}//end ip address exists else	
		
	}
	
	
	private void sensorReading(){
		
	}
}
