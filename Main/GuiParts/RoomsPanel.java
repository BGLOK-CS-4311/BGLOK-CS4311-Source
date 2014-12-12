package Main.GuiParts;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import Main.Commands;
import Main.GuiParts.Layout.Device;
import Main.GuiParts.Layout.Home;
import Main.GuiParts.Layout.ReadLayout;
import Main.GuiParts.Layout.Room;

public class RoomsPanel extends JPanel implements Commands {
	private static final long serialVersionUID = 1L;
	static JPanel panel = new JPanel();
	Home home = new Home();
	List<Room> roomsList;
	
	public RoomsPanel() {
		setupPanel();
		getRoomInfo();
	}
	
	public void setupPanel() {
		panel.setLayout(new GridLayout(2,4));
		//panel.setPreferredSize(getMaximumSize());
		panel.setBackground(Color.GRAY);
		panel.setVisible(true);
	}
	
	void getRoomInfo() {
		ReadLayout read = new ReadLayout();
		roomsList = home.getAllRooms();
		Iterator<Room> iterRoom = roomsList.iterator();
		
		while(iterRoom.hasNext()) {
			Room tempRoom = iterRoom.next();
			JPanel roomPanel = new JPanel();
			roomPanel.setLayout(new BoxLayout(roomPanel, BoxLayout.PAGE_AXIS));
			//roomPanel.setBorder(BorderFactory.createMatteBorder(3,3,3,3, Color.GRAY));
			roomPanel.setVisible(true);
			
			String roomName = tempRoom.getName();
			TitledBorder titleBorder = new TitledBorder(roomName);
			titleBorder.setTitleFont(BOLD);
			roomPanel.setBorder(titleBorder);
			
			List<Device> devList = tempRoom.getDevices();
			Iterator<Device> iterD = devList.iterator();
			while(iterD.hasNext()){
				Device device = iterD.next();
				String dev = device.getName();
				JLabel devLbl = new JLabel(dev);
				devLbl.setFont(FONT);
				roomPanel.add(devLbl);
			}
			panel.add(roomPanel);
		}
	}
	
	public JPanel get(){
		return panel;
	}
}