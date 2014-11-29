package Main.GuiParts;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.event.ChangeEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimePicker implements ActionListener{
	private JPanel panel = new JPanel();
	private JButton button = new JButton("AM");
	private String middayS;
	private final String AM = "AM";
	private final String PM = "PM";
	private JSpinner hrSpinner;
	private JSpinner minSpinner;
	
	public TimePicker(){
		GridLayout grid = new GridLayout(2,3);
		panel.setLayout(grid);
	
		hrSpinner = setSpinner("hh");
		minSpinner = setSpinner("mm");
		button.addActionListener(this);
		
		panel.add(new JLabel("Hr"));
		panel.add(new JLabel("Min"));
		panel.add(new JLabel("AM/PM"));
		
		panel.add(hrSpinner);
		panel.add(minSpinner);
		panel.add(button);
	}
	
	private JSpinner setSpinner(String format){
		JSpinner spinner = new JSpinner(new SpinnerDateModel());
		JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(spinner, format);
		spinner.setEditor(timeEditor);
		spinner.setValue(new Date());
		spinner.setPreferredSize(new Dimension(40, 26));
		return spinner;
	}
	
	public JPanel get(){
		return panel;
	}
	
	public void stateChanged(ChangeEvent e) {
		System.out.println(hrSpinner.getValue()
				+ " " + minSpinner.getValue()
				+ " " );
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		System.out.println(str);
		
		if (str.equals(AM)) {
			button.setText(PM);
			middayS = PM;
		} else if (str.equals(PM)) {
			button.setText(AM);
			middayS = AM;
		}		
	}
}
