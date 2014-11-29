package Main;

import javax.swing.Icon;

/** Interface will have all the following: public static and final */
public interface Commands {
	//Button names
	String START = "Start";
	String STOP = "Stop";
	String SET = "Set";
	String RESET = "Reset";
	
	String DATE_INS = "Starting Point:";
	String SLIDER_INS = "Run Speed:";
	
	//Image names
	String FLOORPLAN = "floorplan.jpg";
	String START_IMG = "start.png";
	String STOP_IMG = "stop.png";
	
	//Speed Settings
	int INIT = 0;
	int MAX = 3;
	int MIN = 0;
	
	String SECS = "realtime";
	String MINS = "min/s";
	String HOURS = "hr/s";
	String DAYS = "day/s";
}