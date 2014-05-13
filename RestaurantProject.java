import java.awt.EventQueue;
import javax.swing.JFrame;

public class RestaurantProject {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				RestaurantFrame frame = new RestaurantFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
}