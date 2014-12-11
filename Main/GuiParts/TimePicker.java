package Main.GuiParts;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TimePicker 
	extends CalendarSelection 
	implements ActionListener, ChangeListener{
	
	private JPanel panel = new JPanel();
	private SpinnerDateModel hrModel = new SpinnerDateModel();
	private SpinnerDateModel minModel = new SpinnerDateModel();
	private JButton button;
	private JSpinner hrSpinner;
	private JSpinner minSpinner;
	
	private final String AM = "AM";
	private final String PM = "PM";
	
	private final int AM_INT = 0;
	private final int PM_INT = 1;
	private int midday;
	
	private int hr;
	private int min;
	
	public TimePicker(){
		GridLayout grid = new GridLayout(2,3);
		panel.setLayout(grid);
	
		hrSpinner = setSpinner(hrModel, "hh");	
		minSpinner = setSpinner(minModel, "mm");
		
		String am_pm = getMidday();
		button = new JButton(am_pm);
		button.addActionListener(this);
		
		panel.add(new JLabel("Hr"));
		panel.add(new JLabel("Min"));
		panel.add(new JLabel(" "));		//Placeholder.
		
		panel.add(hrSpinner);
		panel.add(minSpinner);
		panel.add(button);
	}
	
	/** Needed by constructor class to add hour and minute spinner */
	private JSpinner setSpinner(SpinnerDateModel model, String format){
		JSpinner spinner = new JSpinner(model);
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinner, format);
		spinner.setEditor(timeEditor);
		spinner.setValue(new Date());
		spinner.setPreferredSize(new Dimension(40, 26));
		spinner.addChangeListener(this);
		
		return spinner;
	}
	
	/** Gets the current meridiem */
	String getMidday(){
		midday = calendar.get(Calendar.AM_PM);
		
		if(midday == 0)
			return AM;
		return PM;
	}
	
	/** Returns this JPanel to display */
	public JPanel get(){
		return panel;
	}
		
	@SuppressWarnings("deprecation")
	public void setSelection(){
		hr = hrModel.getDate().getHours();
		min = minModel.getDate().getMinutes();
		
		calendar.set(Calendar.HOUR, hr);
		calendar.set(Calendar.MINUTE, min);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.AM_PM, midday);
		
		//System.out.println(calendar.getTime()); //for debugging
	}
	
	public Calendar getSelection(){
		setSelection();
		return calendar;
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		setSelection();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		System.out.println(str);
		
		if (str.equals(AM)) {
			button.setText(PM);
			midday = PM_INT;
			calendar.set(Calendar.AM_PM, midday);
		} else if (str.equals(PM)) {
			button.setText(AM);
			midday = AM_INT;
			calendar.set(Calendar.AM_PM, midday);
		}		
	}
}