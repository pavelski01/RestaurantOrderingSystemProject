package bulk;

import java.awt.Dimension;
import javax.swing.JFrame;

public class RestaurantFrame extends JFrame {

	public RestaurantFrame() {
		setTitle("Restaurant Shipping");
		setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
		RestaurantPanel panel = new RestaurantPanel(this);
		add(panel);
		pack();
	}
	
	public static final int DEFAULT_WIDTH = 900;
	public static final int DEFAULT_HEIGHT = 300;
	private static final long serialVersionUID = 1L;
}