/**
 * 
 */
package Hardware;

/**
 * @author jvasquez9
 *
 */
public class Humidistat extends Hardware {

	@Override
	public void setDeviceStatus(Hardware hardware, String status) {
		// TODO Auto-generated method stub
		super.setDeviceStatus(hardware, status);
	}
	
	@Override
	public void sendDeviceStatus(Hardware hardware) {
		// TODO Auto-generated method stub
		super.sendDeviceStatus(hardware);
	}
	
	
	/**
	 * 
	 * @param desiredTemp
	 * @return
	 * @requires value != currentHumidLevel
	 * @ensures \result == (dehumidifyVal || humidifyVal)
	 */
	public int changeTemperature(int desiredTemp){
	//this needs to be looked at
	//the contract is wrong
		
		return 0;
	}
	
	private void knowReadings(){
		
	}
	
	private void knowContraints(){
		
	}
	
	
}
