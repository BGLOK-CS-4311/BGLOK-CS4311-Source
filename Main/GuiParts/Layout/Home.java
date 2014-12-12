package Main.GuiParts.Layout;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import Hardware.Hardware;

public class Home {
	static LinkedList<Room> homeList = new LinkedList<Room>();
	
	public boolean addRoom(String name){
		if(!isDuplicate(name)){
			homeList.add(new Room(name));
			return true;
		}
		return false;
	}
	
	public boolean isDuplicate(String n) {
		Iterator<Room> iter = homeList.iterator();
		if(iter.hasNext()){
			Room elem = iter.next();
			
			if(elem.roomName == n){
				return true;
			}
		}
		return false;
	}
	
	public boolean addDevice(String devN, Class<?> hardware) {
		if(homeList != null){
			homeList.getLast().addDevice(devN, hardware);
		}
		return false;
	}
	
	public LinkedList<Room> getAllRooms(){
		return homeList;
	}
}