package Main.GuiParts.Layout;

import Hardware.Hardware;

public class Device {
	String devName;
	Class<?> type;
	
	Device(String n, Class<?> hardware) {
		devName = n;
		type = hardware;
	}
	
	public String getName() {
		return devName;
	}
	
	public String getType() {
		return type.toString();
	}
}