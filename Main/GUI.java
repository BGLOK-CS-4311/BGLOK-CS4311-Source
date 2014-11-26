/* Created Nov 21, 2014
 * Displays the GUI componenets for the DigitalHome simulator */

package Main;
import Main.Commands;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame implements Commands{
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	protected ActionListener listener;
	//Panels
	private JPanel panel;
	private JPanel homePanel;
	private JPanel buttonPanel;
	//Buttons
	private JButton startStopB;
	private JButton setB;
	
	//CONTRACT
	public int panicButton(Security status){		
		return 0;
	}
	
	//CONTRACT
	public int userInput(GUI deviceType, int value){		
		return 0;
	}
	
	/** Constructor method, sets up View */
	public GUI(ActionListener l) {
		listener = l;
		
		//Containers
		frame = new JFrame("DigitalHome Simulator");
		panel = new JPanel();
		homePanel = new JPanel();
		buttonPanel = new JPanel(new GridBagLayout());
		
		//Setup containers with display preferences
		buttonsSetup();		//Call before panel.
		homePanelSetup();	//Call before panel.
		panelSetup();
		frameSetup();		//Call last

		//Add the components into the containers
		frame.add(panel, BorderLayout.CENTER);
		panel.add(buttonPanel, BorderLayout.NORTH);
		panel.add(homePanel, BorderLayout.CENTER);
	}
	
	/** Sets the frame options */
	private void frameSetup() {
		try { //Sets the system's look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);	//Comment out during debugging
		frame.setSize(new Dimension(600, 400));				//Un-comment during debugging
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	/** Sets the panel options */
	private void panelSetup(){
		panel.setVisible(true);
		panel.setLayout(new BorderLayout());	
	}
		
	/** Creates the simulator control buttons and sets the button options*/
	private void buttonsSetup(){
		addButton(startStopB = new JButton(START));
		startStopB.setForeground(Color.GREEN);
		
		addButton(setB = new JButton(SET));
		setB.setEnabled(true);
	}
	
	/** Creates a button, registers the button listener, adds button  to panel
	 *  @param String name of the button */
	private void addButton(JButton button){
		buttonPanel.add(button);
		button.addActionListener(listener);
	}
	
	/**Toggle start/stop timer button text 
	 * @return */
	void showStartB(boolean val){
		if(val == true){
			startStopB.setText(START);
			startStopB.setForeground(Color.GREEN);
		} else if (val == false) {
			startStopB.setText(STOP);
			startStopB.setForeground(Color.RED);
		}
	}
	
	/**Toggle "Alarm on"/"Alarm off" button text 
	 * @param boolean true will display "alarm on" */
	void showSetB(boolean val){
		if(val == true){
			setB.setText(SET); 
		} else if (val == false) {
			setB.setText(RESET);
		}
	}
	
	/** Sets up the home information panel*/
	void homePanelSetup(){
		homePanel.setSize(new Dimension(300,300));
		homePanel.setBackground(Color.WHITE);
		homePanel.setVisible(true);
	}
	
	/** Returns a constraints object */
	GridBagConstraints getC(){
		GridBagConstraints c = new GridBagConstraints();
		return c;
	}
}