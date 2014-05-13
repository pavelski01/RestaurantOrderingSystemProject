
public class Stock {
	
	public Eatable[] getDrinks() { return drinks; }
	public Eatable[] getPolishMainCourses() { return polishMainCourses; }
	public Eatable[] getPolishDesserts() { return polishDesserts; }
	public Eatable[] getMexicanMainCourses() { return mexicanMainCourses; }
	public Eatable[] getMexicanDesserts() { return mexicanDesserts; }
	public Eatable[] getItalianMainCourses() { return italianMainCourses; }
	public Eatable[] getItalianDesserts() { return italianDesserts; }

	private Eatable[] drinks = {
			new Eatable(false, "coffee", 4.0),
			new Eatable(false, "cola", 3.0),
			new Eatable(false, "orange juice", 2.0),
			new Eatable(false, "water", 0.1)			
	};	
	private Eatable[] polishMainCourses = {
			new Eatable(true, "bigos", 13.0),
			new Eatable(true, "Russian dumplings", 3.0),
			new Eatable(true, "schnitzel & potatoes", 15.0)				
	};		
	private Eatable[] polishDesserts = {
			new Eatable(true, "apple cake", 16.0),
			new Eatable(true, "doughnuts", 2.0)								
	};		
	private Eatable[] mexicanMainCourses = {
			new Eatable(true, "burrito", 8.0),
			new Eatable(true, "nachos", 5.0),
			new Eatable(true, "taco", 7.0)		
	};		
	private Eatable[] mexicanDesserts = {
			new Eatable(true, "bean cake", 16.0),
			new Eatable(true, "pinata sweets", 2.0)								
	};		
	private Eatable[] italianMainCourses = {
			new Eatable(true, "pasta", 6.0),
			new Eatable(true, "risotto", 8.0),
			new Eatable(true, "pizza quattro formaggi", 20.0)
	};
	
	private Eatable[] italianDesserts = {
			new Eatable(true, "nutella", 2.0),
			new Eatable(true, "tomato cake", 16.0)				
	};
		
}
