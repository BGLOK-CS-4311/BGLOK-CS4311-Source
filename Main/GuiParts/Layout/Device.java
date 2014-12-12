package Main.GuiParts.Layout;

import java.util.Random;

import javax.swing.JLabel;

import Hardware.Hardware;
import Hardware.Thermostat;
import Main.Commands;
import Main.GuiParts.ClockEvent;
import Main.GuiParts.ClockListener;

public class Device implements Commands {
	String devName;
	Class<?> type;
	String status;
	JLabel label;
	
	Device(String n, Class<?> hardware) {
		devName = n;
		type = hardware;
		setStatus();
		label = new JLabel(devName + ":  " + status);
	}

	public void setStatus(){
		String c = type.getCanonicalName();
		if(c.equals("Hardware.Thermostat")) {
			int temp = (int)(Math.random() * 25 + 70); 
			status = Integer.toString(temp) + "°";
		} else if (c.equals("Hardware.Humidistat")) {
			int humid = (int)(Math.random() * 30 + 1);
			status = Integer.toString(humid) + "%";
		} else {
			double onOff = Math.random();
			if(onOff > 0.5){
				status = "ON" ;
			} else {
				status = "OFF";
			}
		}
		label = new JLabel(devName + ":  " + status);
	}
	
	public String getName() {
		return devName;
	}
	
	public String getType() {
		return type.toString();
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setLabel(JLabel l) {
		label = l;
	}
	
	public JLabel getLabel() {
		return label;
	}
}