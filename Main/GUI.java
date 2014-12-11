/* Created Nov 21, 2014
 * Displays the GUI componenets for the DigitalHome simulator */

package Main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

import javafx.scene.layout.Border;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Main.GuiParts.ClockDisplay;
import Main.GuiParts.DatePicker;
import Main.GuiParts.HomePanel;
import Main.GuiParts.MyActionListener;
import Main.GuiParts.MyChangeListener;
import Main.GuiParts.TimePicker;

public class GUI extends JFrame implements Commands{
	private static final long serialVersionUID = 1L;
	private static JFrame frame = new JFrame("DigitalHome Simulator");

	private JPanel panel =  new JPanel();;
	private JPanel homePanel = new JPanel();
	private JPanel ctrlPanel = new JPanel();

	private JButton startB = new JButton(START);
	private JSlider speedS = new JSlider(MIN,MAX,INIT);
	private DatePicker cal = new DatePicker();
	
	TimePicker timePicker = new TimePicker();
	ClockDisplay clock;
		
	public GUI() {
		clock = new ClockDisplay(Controller.getClock());
		
		ctrlPanelSetup();
		homePanelSetup();
		panelSetup();		//Call second to last
		frameSetup();		//Call last
		
		frame.add(panel, BorderLayout.CENTER);
		panel.add(ctrlPanel, BorderLayout.NORTH);
		panel.add(homePanel, BorderLayout.CENTER);
	}
	
	//CONTRACT
	public int panicButton(Security status) {		
		return 0;
	}
	
	//CONTRACT
	public int userInput(GUI deviceType, int value) {		
		return 0;
	}
	
	private void frameSetup() {
		try { //Sets the system's look and feel
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | 
				InstantiationException |
				IllegalAccessException |
				UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);	//Comment out during debugging
		frame.setSize(new Dimension(800, 400));				//Un-comment during debugging
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private void panelSetup() {
		panel.setLayout(new BorderLayout());	
		panel.setVisible(true);
	}
		
	private void ctrlPanelSetup() {
		//ctrlPanel.setLayout(new BoxLayout(ctrlPanel, BoxLayout.X_AXIS));
		//datePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JPanel datePanel = new JPanel();
		datePanel.setBorder(BorderFactory.createTitledBorder(DATE_INS));
		datePanel.setLayout(new BoxLayout(datePanel, BoxLayout.PAGE_AXIS));
		
		datePanel.add(cal.get(), Component.BOTTOM_ALIGNMENT);
		datePanel.add(timePicker.get(), Component.BOTTOM_ALIGNMENT);
		ctrlPanel.add(datePanel);
		
		JPanel sliderPanel = new JPanel();
		sliderPanel.add(sliderSetup());
		sliderPanel.setBorder(BorderFactory.createTitledBorder(SLIDER_INS));
		ctrlPanel.add(sliderPanel);
		
		
		//Clock Panel
		JPanel clockP = clock.get();
		clockP.setBorder(BorderFactory.createTitledBorder(CLOCK));
		clockP.setLayout(new BoxLayout(clockP, BoxLayout.PAGE_AXIS));
		
		startB.addActionListener(new MyActionListener());
		startB.setForeground(Color.BLACK);
		startB.setIcon(addImageIcon(START_IMG));
		startB.setPreferredSize(new Dimension(90, 26));
		
		clockP.add(new JLabel(""), Component.BOTTOM_ALIGNMENT);
		clockP.add(startB, Component.BOTTOM_ALIGNMENT);
		
		ctrlPanel.add(clockP);
	}
	
	JSlider sliderSetup() {
		Hashtable<Integer, JLabel> lbls = new Hashtable<Integer, JLabel>();
		lbls.put(new Integer(MIN), new JLabel(SECS));
		lbls.put(new Integer(1),new JLabel(MINS));
		lbls.put(new Integer(2), new JLabel(HOURS));
		lbls.put(new Integer(MAX), new JLabel(DAYS));
		speedS.setLabelTable(lbls);
		
		speedS.addChangeListener(new MyChangeListener());
		speedS.setMajorTickSpacing(3);
		speedS.setMinorTickSpacing(1);	
		speedS.setPaintTicks(true);
		speedS.setPaintLabels(true);
		
		return speedS;
	}
	
	/**
	 * Toggle start/pause timer button text 
	 * @return 
	 * */
	public void showStartB(boolean val) {
		if(val == true){
			startB.setText(START);
			startB.setForeground(Color.BLACK);
			startB.setIcon(addImageIcon(START_IMG));
		} else if (val == false) {
			startB.setText(PAUSE);
			startB.setForeground(Color.BLACK);
			startB.setIcon(addImageIcon(PAUSE_IMG));
		}
	}
	
	void homePanelSetup() {
		homePanel.setSize(new Dimension(300,300));
		homePanel.setBackground(Color.WHITE);
		homePanel.setVisible(true);
		homePanel.add(addImage(FLOORPLAN));
		//homeInfo = HomePanel.get();
		//homePanel.add(homeInfo);
	}
	
	/**
	 * Loads and adds an image
	 * @param component 
	 * @return JLabel containing an image
	 * */
	JLabel addImage(String imgName) {
		BufferedImage img = null;
		InputStream res = GUI.class.getResourceAsStream(imgName);
		try {
			img = ImageIO.read(res);
		} catch (IOException e) {
			System.out.println("ERROR: Could not load image"+ imgName);
			return null;
		}
		JLabel label = new JLabel(new ImageIcon(img));
		return label;
	}
	
	/**
	 * Loads and adds an image
	 * @param component 
	 * @return ImageIcon containing an image
	 * */
	ImageIcon addImageIcon(String imgName) {
		BufferedImage img = null;
		InputStream res = GUI.class.getResourceAsStream(imgName);
		try {
			img = ImageIO.read(res);
		} catch (IOException e) {
			System.out.println("ERROR: Could not load image "+ imgName);
			e.printStackTrace();
		}
		return new ImageIcon(img);
	}
	
	/**
	 * Getter method to return this frame object
	 * @return JFrame the application frame
	 */
	public static JFrame getFrame(){
		return frame;
	}
	
	class CompListener implements ComponentListener {
		@Override
		public void componentHidden(ComponentEvent e) {
		}

		@Override
		public void componentMoved(ComponentEvent e) {	
		}

		@Override
		public void componentResized(ComponentEvent e) {
		}

		@Override
		public void componentShown(ComponentEvent e) {
		}
	}
}