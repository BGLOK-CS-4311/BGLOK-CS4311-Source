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
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements Commands{
	private static GUI gui;
	//Model classes variables go here
	private Security security;
	private Hardware hardware;

	private static boolean isRunning = false; 	//variable to know if sim is currently running
	private static boolean isPanicking;
	private static int speed = 0;
	
	//CONTRACT
	public String sendUpdatedDeviceInfo(Hardware device){		
		return "false";
	}
	
	//CONTRACT
	public String updateDeviceInfo(Hardware device, String info){	
		return "false";
	}
	
	/** Constructor instantiates view and model objects */
	public Controller(){
		setGui(new GUI()); //Controller creates the view
		security = new Security();
		setRunning(false);
	}

	/** This method, is meant to go from GUI to devices. In order to send user input */
	//String updateDeviceInfo(Hardware hardware, String info)
	
	/** This method, sends user preferences to the devices. Specific temp/humidity values.*/
	//int userInput (GUI deviceType, int value);

	
	public static void setSpeed(int val){
		speed = val;
	}

	public static boolean get_isRunning() {
		return isRunning;
	}

	public static void setRunning(boolean isRunning) {
		Controller.isRunning = isRunning;
	}

	public static GUI getGui() {
		return gui;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
	}
} 