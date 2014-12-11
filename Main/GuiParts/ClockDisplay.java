package Main.GuiParts;

import Main.GuiParts.CalendarSelection;
import Main.GuiParts.SimClock;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClockDisplay implements Main.GuiParts.SimClock.ClockListener {
	private JPanel panel = new JPanel();
	private static JLabel label = new JLabel();
	private SimClock model;
	
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
	}
	
	public void clockChange(ClockEvent e){
		label.setText(model.clockText());
	}
}