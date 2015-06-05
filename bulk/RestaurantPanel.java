package bulk;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class RestaurantPanel extends JPanel {

	public RestaurantPanel(JFrame frame) {
		this.restaurantFrame = frame;
		restaurantFrame.setTitle("Polish cuisine");
		flag = "polish";
		stock = new Stock();
		sum = 0.0;
		setLayout(new BorderLayout());
		dishPanel = new JPanel();
		dishPanel.setLayout(new BorderLayout());
		dishPanel.add(new JLabel("Dishes", SwingConstants.CENTER), BorderLayout.NORTH);
		dishMenuPanel = new JPanel();
		dishMenuPanel.setLayout(new GridLayout(4, 1));		
		mainCourses = new JComboBox<String>();
		mainCourses.setEditable(false);
		for (Eatable e : stock.getPolishMainCourses()) mainCourses.addItem(e.getName()+" - "+e.getPrice()+" PLN");
		dishMenuPanel.add(new JLabel("   Main Course:"));
		dishMenuPanel.add(mainCourses);
		desserts = new JComboBox<String>();
		desserts.setEditable(false);
		for (Eatable e : stock.getPolishDesserts()) desserts.addItem(e.getName()+" - "+e.getPrice()+" PLN");
		dishMenuPanel.add(new JLabel("   Dessert:"));
		dishMenuPanel.add(desserts);
		dishPanel.add(dishMenuPanel, BorderLayout.CENTER);
		drinkPanel = new JPanel();
		drinkPanel.setLayout(new BorderLayout());
		drinkPanel.add(new JLabel("Drinks", SwingConstants.CENTER), BorderLayout.NORTH);
		extrasPanel = new JPanel();
		extrasPanel.setLayout(new GridLayout(2, 1));
		ice = new JCheckBox("Ice"+" - "+0.2+" PLN");
		extrasPanel.add(ice);
		lemon = new JCheckBox("Lemon"+" - "+0.3+" PLN");
		extrasPanel.add(lemon);
		drinks = new JComboBox<String>();
		drinks.setEditable(false);
		for (Eatable e : stock.getDrinks()) drinks.addItem(e.getName()+" - "+e.getPrice()+" PLN");
		drinkPanel.add(drinks, BorderLayout.CENTER);
		drinkPanel.add(extrasPanel, BorderLayout.SOUTH);
		cuisineButtonsPanel = new JPanel();
		cuisineListener = new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent event) {
				switch (event.getActionCommand().toLowerCase())	{
					case "polish cuisine":
						flag = "polish";
						restaurantFrame.setTitle("Polish cuisine");
						cuisine.setText("Polish cuisine");
						mainCourses.removeAllItems();
						for (Eatable e : stock.getPolishMainCourses()) mainCourses.addItem(e.getName()+" - "+e.getPrice()+" PLN");
						desserts.removeAllItems();
						for (Eatable e : stock.getPolishDesserts()) desserts.addItem(e.getName()+" - "+e.getPrice()+" PLN");
						break;
					case "mexican cuisine":
						flag = "mexican";
						restaurantFrame.setTitle("Mexican cuisine");
						cuisine.setText("Mexican cuisine");
						mainCourses.removeAllItems();
						for (Eatable e : stock.getMexicanMainCourses()) mainCourses.addItem(e.getName()+" - "+e.getPrice()+" PLN");
						desserts.removeAllItems();
						for (Eatable e : stock.getMexicanDesserts()) desserts.addItem(e.getName()+" - "+e.getPrice()+" PLN");
						break;
					case "italian cuisine":
						flag = "italian";
						restaurantFrame.setTitle("Italian cuisine");
						cuisine.setText("Italian cuisine");
						mainCourses.removeAllItems();
						for (Eatable e : stock.getItalianMainCourses()) mainCourses.addItem(e.getName()+" - "+e.getPrice()+" PLN");
						desserts.removeAllItems();
						for (Eatable e : stock.getItalianDesserts()) desserts.addItem(e.getName()+" - "+e.getPrice()+" PLN");
						break;
				}
			}
		};
		makeButton("Polish cuisine");
		makeButton("Mexican cuisine");
		makeButton("Italian cuisine");
		JButton count = new JButton("COUNT");
		countListener = new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent event) {
				sum = 0.0;
				String mainCourse = new StringTokenizer((String)mainCourses.getSelectedItem(), "-").nextToken().trim();
				String dessert = new StringTokenizer((String)desserts.getSelectedItem(), "-").nextToken().trim();
				String drink = new StringTokenizer((String)drinks.getSelectedItem(), "-").nextToken().trim();
				if (flag.equals("polish")) {
					for (Eatable e : stock.getPolishMainCourses()) if (e.getName().equals(mainCourse)) sum += e.getPrice();
					for (Eatable e : stock.getPolishDesserts()) if (e.getName().equals(dessert)) sum += e.getPrice();
				}
				else if (flag.equals("mexican")) {
					for (Eatable e : stock.getMexicanMainCourses()) if (e.getName().equals(mainCourse)) sum += e.getPrice();
					for (Eatable e : stock.getMexicanDesserts()) if (e.getName().equals(dessert)) sum += e.getPrice();
				}
				else if	(flag.equals("italian")) {
					for (Eatable e : stock.getItalianMainCourses()) if (e.getName().equals(mainCourse)) sum += e.getPrice();
					for (Eatable e : stock.getItalianDesserts()) if (e.getName().equals(dessert)) sum += e.getPrice();
				}
				for (Eatable e : stock.getDrinks()) if (e.getName().equals(drink)) sum += e.getPrice();
				if (lemon.isSelected()) sum += 0.3;
				if (ice.isSelected()) sum += 0.2;
				gross.setText("To pay: "+new DecimalFormat("#.##").format(sum)+" PLN");
			}
		};
		count.addActionListener(countListener);
		add(cuisine = new JLabel("Polish cuisine", SwingConstants.CENTER), BorderLayout.NORTH);
		cuisinePanel = new JPanel();
		cuisinePanel.setLayout(new GridLayout(2, 1));
		cuisinePanel.add(cuisineButtonsPanel);
		gross = new JLabel("Hit COUNT to make order: "+new DecimalFormat("#.##").format(sum)+" PLN");
		gross.setHorizontalAlignment(SwingConstants.CENTER);
		cuisinePanel.add(gross);
		add(cuisinePanel, BorderLayout.CENTER);
		add(count, BorderLayout.SOUTH);
		add(dishPanel, BorderLayout.WEST);
		add(drinkPanel, BorderLayout.EAST);
	}
	
	private void makeButton(String label) {
		JButton button = new JButton(label);
		button.addActionListener(cuisineListener);
		cuisineButtonsPanel.add(button);
	}
	
	private Stock stock;
	private ActionListener cuisineListener;
	private ActionListener countListener;
	private JFrame restaurantFrame;
	private JPanel cuisineButtonsPanel;
	private JPanel dishPanel;
	private JPanel drinkPanel;
	private JPanel extrasPanel;
	private JPanel dishMenuPanel;
	private JPanel cuisinePanel;
	private JLabel cuisine;
	private JLabel gross;
	private JCheckBox ice;
	private JCheckBox lemon;
	private JComboBox<String> mainCourses;
	private JComboBox<String> desserts;
	private JComboBox<String> drinks;
	private String flag;
	private double sum;
	private static final long serialVersionUID = 1L;
}
