package Main;

import java.util.Timer;
import java.util.TimerTask;

public class Security {
	private boolean isAlarmOn;
	private boolean isAlarmTriggered;
	private static final int TIMER = 15;	//Seconds
	
	//CONTRACT
	public void notifyEmergancyAuthorites(String phoneNumber, String ownersName, String address){
	}
	
	/** Getter to know the security alarm status */
	boolean getCurrentAlarmStatus(Boolean alarmStatus){
		return isAlarmOn;	
	}
	
	/** Checks the password put in by the user and if it is correct then the 
	 * alarm will disarm or arm depending on the current alarm status.*/
	boolean disarm(int pin){
		if(checkPin(pin)){	//First check pin
			if(isAlarmOn){
				if(isAlarmTriggered){
					isAlarmTriggered = false;	//Stop sounding the alarm
					return true;
				}
				isAlarmOn = false;				//Disarm the alarm, alarm will stop monitoring
			}
			System.out.println("Alarm is not on, pin ignored");
			return false;
		}
		return false;						
	}
	
	/** Check's user's pin */
	boolean checkPin(int pin){
		//Retrieve pin's from database
		//if pin not found through all the saved pins
		//System.out.println("Error: Incorrect Pin);
		//return false;
		return true;
	}
	
	/** Arm the home by setting the alarm on*/
	boolean arm(){
		//Check if user is logged in?
		if(!isAlarmOn){
			isAlarmOn = true;
			return true;
		}
		return false;
	}
	
	/** Notifies the emergency authorities when either of two things have ocurred 
	 * 1. Motion/Contact sensors have triggered the alarm, and alarm was not disabled in time.
	 * 2. Panic button was pushed. 
	 * 
	 * Might be returning boolean to notify if an error occurred...
	 * */
	void notifyEmerAuthorities(){
		//Get phone number
		//Get owners name
		//Get home address
	}
	
	/** Once an intrusion is detected this method starts a timer to allow the user to
	 * disarm the alarm before the emergency authorities are called. Returns true if
	 * the emergency authorities were called. */
	boolean startAlarmCountdown(){
		final Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int time = TIMER;
			public void run(){
				System.out.println(time--);
					if(time < 0)
						timer.cancel();
			}
		}, 0, 1000);	//0ms delay. 1000 ms (1s) fixed rate
		
		if(isAlarmOn){
			notifyEmerAuthorities(); //Call the authorities
			return true;
		}
		return false; //Emergency authorities not notified
	}
}
