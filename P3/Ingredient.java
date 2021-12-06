/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public enum Ingredient {
	Eggs(3.48),
	Sugar(2.89),
	Butter(3.99),
	Flour(3.24),
	BakingPowder(1.99),
	BakingSoda(.85),
	Flavoring(2.99),
	Fruit(5.50),
	Salt(.99),
	Milk(2.72),
	Cinnamon(2.99),
	Cream(3.12),
	YogurtCulture(4.95),
	Gelatin(3.99);
	/**
	 * fields:
	 * price: this represents the price of the ingredient
	 */
	private final double price;
	/**
	 * @param input this is the price of the ingredient
	 */
	Ingredient(double input) {
		this.price = input;
	}
	/**
	 * returns the price of the ingredient
	 */
	public double getPrice() {
		return this.price;
	}
}