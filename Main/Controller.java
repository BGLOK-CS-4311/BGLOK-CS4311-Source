/** @author jvazquez9
 * 
 */
package Main;
import Hardware.Hardware;
import Main.Commands;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonModel;
import javax.swing.JButton;

public class Controller implements Commands{
	private GUI gui;
	//Model classes variables go here
	private Security security;
	private Hardware hardware;

	private boolean isRunning; 			//variable to know if sim is currently running
	private boolean isSet;
	private boolean isPanicking;
	
	//CONTRACT
	public String sendUpdatedDeviceInfo(Hardware device){		
		return "false";
	}
	
	//CONTRACT
	public String updateDeviceInfo(Hardware device, String info){	
		return "false";
	}
	
	/** Main method for testing. Application must have a main method in order to run. */
	public static void main(String[] args){
		Controller ctrl = new Controller();
	}
	
	/** Constructor instantiates view and model objects */
	public Controller(){
		gui = new GUI(new ViewListener()); //Controller creates the view
		security = new Security();
		
		isRunning = false;
	}

	/** This method, is meant to go from GUI to devices. In order to send user input */
	//String updateDeviceInfo(Hardware hardware, String info)
	
	/** This method, sends user preferences to the devices. Specific temp/humidity values.*/
	//int userInput (GUI deviceType, int value);

////////////////////////////////////////////////////////////////////////////////////////
/** Inner class listens to the GUI components and performs the actions */
	class ViewListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {	
			String cmd = e.getActionCommand();
			System.out.print(cmd + " button pressed.\t");
			
			switch(cmd){
			case START:			//Not running yet, start simulator for user
				startDisplay(true);
				break;		
			case STOP:			//Simulator should be running, stop simulator for user
				startDisplay(false);
				break;
			case SET:
				setDisplay(true);
				break;
			case RESET:
				setDisplay(false);
				break;
				
			default:
				System.out.println("Unknown command: "+ cmd +", ActionListener needs to be defined");
				break;
			}	
		}
		
		/** Display settings for when simulator has been started/stopped
		 * @parm boolean decision to display a simulator that is running */
		void startDisplay(boolean isStarted){
			isRunning = isStarted; 			//If started then it is running
			isSet = isStarted;				//If started then it is set
			//gui.showControlB(isStarted);	//If started show running sim ctrls
			gui.showStartB(!isStarted);	//If started, hide the "start" text
			gui.showSetB(isStarted);
			
			//For Debugging
			if(isStarted)
				System.out.println("Sim: Started");
			else
				System.out.println("Sim: Stopped");
		}
		
		
		/** Set the reset and set buttons */
		void setDisplay(boolean doSet){
			isSet = doSet;	
			gui.showSetB(doSet);	
			
			//For Debugging
			if(doSet)
				System.out.println("Sim: Set");
			else
				System.out.println("Sim: Reset");
		}		
	} //End of ViewListener class
} //End of Controller class