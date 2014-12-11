package Main.GuiParts;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Main.Controller;

public class MyChangeListener implements ChangeListener {
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource();
		if (!source.getValueIsAdjusting()) {
			int speed = (int)source.getValue();
			Controller.setSpeed(speed);
			SimClock.setSpeed(speed);
			System.out.println(speed);
		}
	}
}
