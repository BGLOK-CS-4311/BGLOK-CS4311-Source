package Main.GuiParts;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarSelection {
	static Calendar calendar;
	static final SimpleDateFormat myFormat = 
			new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//In SQL format
	
	CalendarSelection(){
		calendar = Calendar.getInstance();
	}
	
	public static Calendar getCalendar(){
		return calendar;
	}
	
	public static String getString(){
		DatePicker.setSelection();
		Date date = calendar.getTime();
		String s = myFormat.format(date);
		return s;
	}
}