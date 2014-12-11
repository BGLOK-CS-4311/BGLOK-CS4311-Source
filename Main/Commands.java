package Main;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Icon;

/** Interface will have all the following: public static and final */
public interface Commands {
	//Button names
	String START = "Start";
	String PAUSE = "Pause";
	String SET = "Set";
	String RESET = "Reset";
	String CLOCK = "Clock";

	//User Instructions
	String DATE_INS = "Starting Point:";
	String SLIDER_INS = "Run Speed:";
	String LATER_DATE = "Please use today's date or a future date.\n"
			+ "Today's date will be set for you.";
	String INVALID_START = "Invalid Starting Point";
			
	//Image names
	String FLOORPLAN = "/res/floorplan.jpg";
	String START_IMG = "/res/start.png";
	String PAUSE_IMG = "/res/pause.png";

	//Slider speed Strings
	String SECS = "realtime";
	String MINS = "min/s";
	String HOURS = "hr/s";
	String DAYS = "day/s";
	
	//Speed Settings
	int INIT = 0;
	int MAX = 3;
	int MIN = 0;
		
	//Display
	Color GRAY = new Color(80,80,80);
	Color WHITE = Color.WHITE;
	Font FONT = new Font("Arial", Font.PLAIN, 12);
	 
}