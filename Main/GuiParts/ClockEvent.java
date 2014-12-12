package Main.GuiParts;

import java.util.EventObject;

public class ClockEvent extends EventObject {
	private static final long serialVersionUID = 1L;

	public ClockEvent(Object source) {
		super(source);
	}
}
