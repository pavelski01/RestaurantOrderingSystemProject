
public class Eatable {
	
	public Eatable(boolean food, String name, double price) {
		this.food = food;
		this.name = name;
		this.price = price;
	}
	
	public boolean isFood() { return food; }
	public void setFood(boolean food) { this.food = food; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public double getPrice() { return price; }
	public void setPrice(double price) { this.price = price; }

	private boolean food;
	private String name;
	private double price;
}
