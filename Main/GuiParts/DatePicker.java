package Main.GuiParts;    

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilCalendarModel;

public class DatePicker 
	extends CalendarSelection 
	implements ChangeListener, ActionListener{
	
	private static UtilCalendarModel model;
	static JDatePanelImpl panel;
	static JDatePickerImpl picker;
	Date current;
	
	public DatePicker(){		
		model = new UtilCalendarModel();
		model.setSelected(true);

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		panel = new JDatePanelImpl(model, p);
		
		picker = new JDatePickerImpl(panel, new DateLabelFormatter());
	}
	
	public class DateLabelFormatter extends AbstractFormatter {
		private static final long serialVersionUID = 1L;
		private String datePattern = "MMM dd, yyyy";	//Make easy for user to read
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

	    @Override
	    public Object stringToValue(String text) throws ParseException {
	        return dateFormatter.parseObject(text);
	    }

	    @Override
	    public String valueToString(Object value) throws ParseException {
	        if (value != null) {
	            Calendar cal = (Calendar) value;
	            return dateFormatter.format(cal.getTime());
	        }
	        return "";
	    }
	}
	
	/** Returns this object for displaying */
	public JDatePickerImpl get(){
		return picker;
	}
	
	/** Resets the Date Picker to have the current today's date. */
	public static void setToday(){
		Calendar today = Calendar.getInstance();
		model.setDate(today.get(Calendar.YEAR), today.get(Calendar.MONTH), today.get(Calendar.DATE));
	}
	
	/** Sets the current values into the calendar object */
	public static void setSelection(){
		//calendar = (Calendar) picker.getModel().getValue();
		int year = model.getYear();
		int month = model.getMonth();
		int day = model.getDay();
		
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DATE, day);
	}
	
	public Calendar getSelection(){
		setSelection();
		return calendar;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		setSelection();
		System.out.println(calendar.getTime());
	}

	public void actionPerformed(ActionEvent e) {
		setSelection();
		System.out.println(calendar.getTime());
	}
}