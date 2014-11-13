/**
 * 
 */
package Hardware;

/**
 * @author jvasquez9
 *
 */
public abstract class Hardware {
	
	/**
	 * IDEA: Implement hardware as a DS to assign multiple values to devices...John
	 * 
	//
	//this needs to be worked on!!!!!
	//
	 * 
	 * 
	 */
	public Hardware() {
		// TODO Auto-generated constructor stub
		Hardware hardware = new Hardware();
		Hardware status = hardware.status();
		Hardware address = hardware.address(); //ip address, need this from db?
		Hardware registered = hardware.registered(); //will call the db to see if it already exsists
	}

	/**
	 * 
	 * @param hardware
	 * @param status
	 * @requires hardware!= null && hardware.exists()
	 */
	public void setDeviceStatus(Hardware hardware, String status){
		//checking if hardware object is null
		if(hardware == null){
			System.out.println("The hardware does not exist within the system or cannot" +
					" be found, please try again");
		}//end if hardware null
		
		//checking if the status message is null or empty
		else if(status.equals("") || status == null){
			System.out.println("The status cannot be empty, please try again");
		}//end status if
		
		//passed both checks, we now update the status
		else{
			//updating the status
			hardware.status = status;
			
			//print out a confirmation message stating status has updated
			System.out.println("Status has been updated for device " + hardware.toString() );
		}//end else
		
	}//end set device status
	
	
	/**
	 * 
	 * @param hardware
	 * @requires hardware!= null && hardware.exists()
	 */
	public void sendDeviceStatus(Hardware hardware){
		//checking if hardware object is null
		if(hardware == null){
			System.out.println("The hardware does not exist within the system or cannot" +
							" be found, please try again");
		}//end if hardware null
		
		//passed initial check, send hardware status
		else{
			String status = hardware.status;
			
			//this sop is only temporary and will be changed once the rest of the 
			//system has been implementd --John
			System.out.println("Status of hardware is " + status);
		}//end else
		
	}//end send device status
	
	
	/**
	 * 
	 * @param hardware
	 * @requires hardware!= null && hardware.exists()
	 * /*@ensures: Device is added and an IP Address is assigned
	 */
	public void addDevice(Hardware hardware){
		//checking if hardware object is already in system
		//checking if hardware is already registered and if hardwares address
		//has a valid address that is not 0
		if(hardware.registered == true && hardware.address != 0){
			System.out.println("The hardware you are trying to add already exists, please try again");
		}//end if hardware null
		
		//hardware is not in system, add
		else{
			hardware.registerd = true; //registering it
			hardware.address = new address();//need a new address
			System.out.println("Added new hardware to system");
		}//end else
		
		
	}//end add device
	
	
	/**
	 * 
	 * @param hardware
	 * @requires hardware != null && hardware.exists();
	 * @ensures Device is removed and database is updated with removal
	 */
	public void removeDevice(Hardware hardware){
		//checking if hardware object is already in system
		//checking if hardware is already registered and if hardwares address
		//has a valid address that is not 0
		if(hardware.registered == true && hardware.address != 0){
			hardware.registered = false; //unregistering it
			hardware.address = 0; //getting rid of the address associated with device
		}//end if hardware null
		
		//if hardware object is not in system
		else{
			System.out.println("Hardware is not in system, please try again");
		}//end else
	}//end remove device
	
	
	/**
	 * 
	 * @param s
	 * @return
	 * #####NOTE Need to implement check on whether device is connected or ot
	 * #####Not sure how to do this yet, will implement later
	 */
	public String status(Hardware hardware, String s){
		String status = "";//this will be our end result
		
		if(s.equals("") || s == null){
			//throw error
		}
		else{
			if(hardware == "connected"){
				status = "enabled";
			}//end connected if
			else{
				status = "disabled";
			}//end else connect
		}//end else
		
	}//end status
	
	
	
//------------------------------------------------------------------------------------------	
	
	/**
	 * WILL WORK ON THESE LATER!!!  JOHN
	 */
	
	
	
	public void userCommandPref(){
		
	}
	
	public void knowIPAddress(Hardware harware){
		
	}
	
	public void logDeviceFailure(Hardware hardware){
		
	}
}
