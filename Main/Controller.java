package Main;
import Hardware.Hardware;
import Main.Commands;
import Main.GuiParts.SimClock;

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
	private static SimClock clock;
	
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
		clock = new SimClock();
		setGui(new GUI()); //Controller creates the view
		security = new Security();
		setRunning(false);
	}

	/** This method, is meant to go from GUI to devices. In order to send user input */
	//String updateDeviceInfo(Hardware hardware, String info)
	
	/** This method, sends user preferences to the devices. Specific temp/humidity values.*/
	//int userInput (GUI deviceType, int value);

	/**
	 * Sets the simulator speed
	 * @param val
	 */
	public static void setSpeed(int val){
		speed = val;
	}

	/**
	 * Getter to tell if the Controller is running or not.
	 * @return boolean of whether the controller is running at the moment
	 */
	public static boolean get_isRunning() {
		return isRunning;
	}

	/**
	 * Starts running the clock and the Simulator
	 * @param isRunning boolean value sets if the controller is running.
	 */
	public static void setRunning(boolean isRunning) {
		Controller.isRunning = isRunning;
		
		if(isRunning)
			clock.start();
		else
			if(clock != null){
				clock.stop();
			}
	}

	public static GUI getGui() {
		return gui;
	}

	public void setGui(GUI gui) {
		this.gui = gui;
	}
	
	public static SimClock getClock(){
		return clock;
	}
	
	public static int getSpeed(){
		return speed;
	}
} 