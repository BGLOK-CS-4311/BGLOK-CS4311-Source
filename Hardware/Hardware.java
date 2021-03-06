/**
 * 
 */
package Hardware;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jvasquez9
 *
 */
public abstract class Hardware {
	
	/**
	 * default private values. Will set these 
	 */
	private ArrayList<String> hardwareList = new ArrayList<String>();//the list of all the hardware connected to the system
	
	private String hardware;
	protected String status;
	private int ipaddress;
	private boolean registerd;
	private String failurel;
	//Database_Accessor dbQuery = new Database_Accessor();

	

	/**
	 * 
	 * @param hardware
	 * @param status
	 * @requires hardware!= null && hardware.exists()
	 */
	public void setDeviceStatus(Hardware hardware, String newStatus){
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
			hardware.status = newStatus;
			
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
			String getStatus = hardware.status;
			
			//this sop is only temporary and will be changed once the rest of the 
			//system has been implementd --John
			System.out.println("Status of hardware is " + getStatus);
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
		for(int i = 0; i < hardwareList.size(); i++){
			if(hardwareList.get(i).equals(hardware) ){
				System.out.println("The hardware you are trying to add already exists, please try again");
			}//end if hardware null
		}
			
		
		hardware.registerd = true; //registering it
		hardware.ipaddress = ipaddress++;//need a new address
		System.out.println("Added new hardware to system");		

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
		if(hardware.registerd == true && hardware.ipaddress != 0){
			hardware.registerd = false; //unregistering it
			hardware.ipaddress = 0; //getting rid of the address associated with device
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
			if(hardware.status == "connected"){
				status = "enabled";
			}//end connected if
			else{
				status = "disabled";
			}//end else connect
		}//end else
		return status;
	}//end status


	public void userCommandPref(){
		//no idea what this is supposed to
		//be doing, need clarrification
		//-john
		
	}
	
	public void knowIPAddress(Hardware harware){
		//check if hardware object is null
		if(hardware == null){
			System.out.println("Hardware Item must be known, please retry");
		}
		else{
			//getting the ip address of the hardware object
			//String results = dbQuery.retrieveDate("Hardware", "IPAddress", hardware.ipaddress);
			//System.out.println("IPAddress is " + results);
		}

	}
	
	public void logDeviceFailure(Hardware hardware){
		//check if hardware object is null
		if(hardware == null){
			System.out.println("Hardware Item must be known, please retry");
		}//end if
		else{
			//String results = dbQuery.storeData("Hardware","Failures", hardware.failure);
			System.out.println("Failure has been logged");
		}//end else
	}
}
