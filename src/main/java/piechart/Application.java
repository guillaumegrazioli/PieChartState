package piechart;

import java.awt.event.WindowEvent;
import javax.swing.JFrame;

public class Application {
	boolean packFrame = true;

	/**Construct the application*/
	public Application() {
		JFrame frame = new JFrame() {
			/**Overridden so we can exit when window is closed*/
			protected void processWindowEvent(WindowEvent e) {
				super.processWindowEvent(e);
				if (e.getID() == WindowEvent.WINDOW_CLOSING) {
					System.exit(0);
				}
			}
		};
		frame.setTitle("Model - View - Controller example");
		frame.getContentPane().add(new PercentagePanel());
		frame.pack();
		frame.setVisible(true);
	}
}
