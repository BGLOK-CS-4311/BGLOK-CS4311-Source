/**
 * 
 */
package Hardware;

/**
 * @author jvasquez9
 *
 */
public class Contact_Sensor extends Sensor {

	@Override
	public Boolean activateSensor(Sensor sensor, int IPAddress) {
		// TODO Auto-generated method stub
		return super.activateSensor(sensor, IPAddress);
	}
	
	@Override
	public Boolean deactivateSensor(Sensor sensor, int IPAddress) {
		// TODO Auto-generated method stub
		return super.deactivateSensor(sensor, IPAddress);
	}
	
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
	
	private void detectOpening(){
		
	}
	
	
}
