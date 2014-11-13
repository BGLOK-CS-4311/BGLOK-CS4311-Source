/**
 * 
 */
package Hardware;

/**
 * @author jvasquez9
 *
 */
public class Thermostat extends Hardware {

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
	
	private void knowReadings(){
		
	}
	
	private void knowContraints(){
		
	}
	
	/**
	 * 
	 * @param desiredTemp
	 * @return
	 * @requires value != currentTemp
	 * @ensures \result == (tempIncreaseVal || tempDecreaseVal)
	 */
	public int changeTemperature(int desiredTemp){
		
		return 0;
	}
	
	

}
