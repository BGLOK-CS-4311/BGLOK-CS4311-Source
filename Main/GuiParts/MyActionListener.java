package Main.GuiParts;

import Main.Commands;
import Main.Controller;
import Main.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class MyActionListener implements ActionListener, Commands{
	@Override
	public void actionPerformed(ActionEvent e) {	
		String cmd = e.getActionCommand();
		System.out.print(cmd + " button pressed.\t");
		
		if (cmd.equals(START)) {
			startDisplay(true);
		} else if (cmd.equals(PAUSE)) {
			startDisplay(false);
		} else {
			System.out.println("Unknown command: "+ cmd +", ActionListener needs to be defined");
		} 	
	}	
	
	/** Display settings for when simulator has been started/paused
	 * @parm boolean decision to display a simulator that is running */
	void startDisplay(boolean isStarted){
		Controller.setRunning(isStarted); 			//If started then it is running
		Controller.getGui().showStartB(!isStarted);	//If started, hide the "start" text
		
		//For Debugging
		if(isStarted){
			System.out.println(CalendarSelection.getString());
			System.out.println("Sim: Started");
		}
		else
			System.out.println("Sim: paused");
	}
}