package Main.GuiParts;    

import java.text.DateFormat;
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
import org.jdatepicker.impl.UtilDateModel;


public class DatePicker implements ChangeListener{
	UtilDateModel model;
	JDatePanelImpl panel;
	JDatePickerImpl picker;
	Date current;
	
	public DatePicker(){		
		model = new UtilDateModel();
		model.setSelected(true);
		model.addChangeListener(this);

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
	
	public JDatePickerImpl getCalendar(){
		return picker;
	}
	
	public Object getSelection(){
		Date selectedDate = (Date) picker.getModel().getValue();
		DateFormat formatD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	//Easier for system to read.
		String selection = formatD.format(selectedDate);
		return selection;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		System.out.println(getSelection());
	}
}