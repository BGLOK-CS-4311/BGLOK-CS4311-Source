package Main.GuiParts;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;

import javax.swing.Timer;

import Main.Controller;

public class SimClock implements Runnable{
	static Calendar calendar;
	static Boolean isRunning;
	static Thread thread, t;
	static int speed;
	final int sec = 1000;
	private ArrayList listeners = new ArrayList();
	
	static final SimpleDateFormat cFormat = 
			new SimpleDateFormat("MMM dd, 2014 HH:mm:ss");	

	public void start() {
		calendar = CalendarSelection.getCalendar();	
		speed = Controller.getSpeed();
		isRunning = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		t = Thread.currentThread();
		
		//while(!t.isInterrupted()){
		while(true){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("Simulator was paused ");
				return;
			}
			calendar.add(Calendar.SECOND, 1);
			fireEvent(new ClockEvent(this));
		}
	}
	
	public void stop() {
		if(thread != null){
			thread.interrupt();
		}
	}
	
	public void set(Calendar cal) {
		calendar = cal;
	}

	public String calToString(Calendar cal) {
		Date date = cal.getTime();
		String s = cFormat.format(date);
		return s;
	}

	public String clockText(){
		return calToString(calendar);
	}

	public static void setSpeed(int spd) {
		speed = spd;
	}
	
	private void fireEvent(ClockEvent e){
		int len = listeners.size();
		if(len > 0){
			for(int i=0; i<len; i++){
				((ClockListener) listeners.get(i)).clockChange(e);
			}
		}
	}
	
	public void addChangeListener(ClockListener l){
		listeners.add(l);
	}
	
	interface ClockListener extends EventListener {
		void clockChange(ClockEvent e);
	}
}