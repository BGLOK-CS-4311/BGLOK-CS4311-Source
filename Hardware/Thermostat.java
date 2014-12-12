/**
 * 
 */
package Hardware;

/**
 * @author jvasquez9
 *
 */
public class Thermostat extends Hardware {

	public int temp;


	@Override
	public void sendDeviceStatus(Hardware hardware) {
		// TODO Auto-generated method stub
		if(hardware == null){
			System.out.println("Hardware object cannot be null, please retry");
		}
		else{
			String status = hardware.status;
			System.out.println(status);
		}
		
	}//end send device status
	
	@Override
	public void setDeviceStatus(Hardware hardware, String status) {
		// TODO Auto-generated method stub
		super.setDeviceStatus(hardware, status);
		if(hardware == null){
			System.out.println("Hardware object cannot be null, please retry");
		}
		if(status.equals("") || status == null){
			System.out.println("The status cannont be null, please re enter the status");
		}
		else{
			hardware.status = status;
		}
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
		if(desiredTemp < 50 || desiredTemp > 80){
			System.out.println("The desired temperature is not within the appropraite range of "
				+"a low 50 degrees and a high of 80 degress. Please re enter your temperature");
			return 0;
		}
		else{
			return temp = desiredTemp;
		}
		
	}
	
	

}
