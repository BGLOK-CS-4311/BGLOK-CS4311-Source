package Main.GuiParts.Layout;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Hardware.Hardware;

public class Room {
	String roomName;
	List<Device> devList = new ArrayList<Device>();
	
	Room(String name) {
		roomName = name;
	}
	
	public boolean addDevice(String n, Class<?> hardware) {
		if(!isDuplicate(n, hardware)){
			devList.add(new Device(n, hardware));
			return true;
		}
		return false;
	}
	
	public boolean isDuplicate(String n, Class<?> hardware) {
		Iterator<Device> iter = devList.iterator();
		if(iter.hasNext()){
			Device elem = iter.next();
			
			if(elem.devName == n){
				return true;
			}
		}
		return false;
	}
	
	public String getName(){
		return roomName;
	}
	
	public List<Device> getDevices() {
		return devList;
	}
}