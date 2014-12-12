package Main.GuiParts;

import Main.GuiParts.CalendarSelection;
import Main.GuiParts.SimClock;
import Main.GuiParts.Layout.Device;
import Main.GuiParts.Layout.Home;
import Main.GuiParts.Layout.Room;

import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockDisplay implements Main.GuiParts.SimClock.ClockListener {
	private JPanel panel = new JPanel();
	private static JLabel label = new JLabel();
	private SimClock model;
	Home home = new Home();
	
	public ClockDisplay(SimClock m){
		model = m;
		model.addChangeListener(this);
		
		Font font = new Font("Lucida Sans Typewriter", Font.BOLD, 20);
		label.setFont(font);
		//label.setText(model.clockText());
		String s = model.calToString(CalendarSelection.getCalendar());
		label.setText(s);
		
		panel.add(label);
	}
	
	public JPanel get(){
		return panel;
	}
	
	public void set(){
		label.setText(model.clockText());
		/*
		List<Room> roomL = home.getAllRooms();
		Iterator<Room> itR = roomL.iterator();
		while(itR.hasNext()){
			Room room = itR.next();
			
			List<Device> dL = room.getDevices();
			Iterator<Device> itD = dL.iterator();
			while(itD.hasNext()){
				Device d = itD.next();
				d.setStatus();
			}
		}
		*/
	}
	
	public void clockChange(ClockEvent e){
		label.setText(model.clockText());
		/*
		List<Room> roomL = home.getAllRooms();
		Iterator<Room> itR = roomL.iterator();
		while(itR.hasNext()){
			Room room = itR.next();
			
			List<Device> dL = room.getDevices();
			Iterator<Device> itD = dL.iterator();
			while(itD.hasNext()){
				Device d = itD.next();
				d.setStatus();
			}
		}
		*/
	}
}