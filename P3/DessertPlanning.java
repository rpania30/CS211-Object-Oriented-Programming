/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class DessertPlanning {
	/**
	 * fields:
	 * dessert: represents a Dessert object
	 * newIngredients: represents a list of new ingredients
	 * newPrices: represents a list of new prices
	 */
	private Dessert dessert;
	private String[] newIngredients;
	private Double[] newPrices;
	/**
	 * @param input this is the dessert type
	 */
	public DessertPlanning(Dessert input) {
		this.dessert = input;
		this.newIngredients = new String[0];
		this.newPrices = new Double[0];
	}
	/**
	 * prints each of the base ingredients of the dessert (with price)
	 */
	public void printBaseIngredients() {
		System.out.println(this.dessert.description() + " Base Ingredients: ");
		for (int i = 0; i < this.dessert.ingredientsNeeded().length; ++i) {
			System.out.println(this.dessert.ingredientsNeeded()[i] + " $" + String.format("%.2f", this.dessert.ingredientsNeeded()[i].getPrice()));
		}
	}
	/**
	 * prints the base cost of the dessert
	 */
	public void printBasePrice() {
		System.out.println("Base Cost: $" + String.format("%.2f", this.dessert.baseCost()));
	}
	/**
	 * adds an ingredient and its price to the string and double arrays
	 * creates two new arrays (1 larger) and copies all existing values to the new arrays
	 * adds the given ingredient and price to the end of their respective arrays
	 * sets the new lists back to their original lists
	 */
	public void addNewIngredient(String placeholder, Double temp) {
		String[] newArrStr = new String[this.newIngredients.length + 1];		
		Double[] newArrDou = new Double[this.newPrices.length + 1];
		for (int i = 0; i < this.newIngredients.length; ++i) {
			newArrStr[i] = this.newIngredients[i];
			newArrDou[i] = this.newPrices[i];
		}
		newArrStr[this.newIngredients.length] = placeholder;
		newArrDou[this.newPrices.length] = temp;
		this.newIngredients = newArrStr;
		this.newPrices = newArrDou;
	}
	/**
	 * removes an ingredient and its price from the string and double arrays
	 * creates two new arrays (1 smaller) and copies all existing values to the new arrays, besides the given string (and price)
	 * sets the new lists back to their original lists
	 */
	public boolean removeNewIngredient(String placeholder) {
		for (int i = 0; i < this.newIngredients.length; ++i) {
			if (this.newIngredients[i] == placeholder) {
				this.newIngredients[i] = null;
				this.newPrices[i] = null;
				String[] newArrStr = new String[this.newIngredients.length - 1];		
				Double[] newArrDou = new Double[this.newPrices.length - 1];
				int index = 0;
				for (int j = 0; j < this.newIngredients.length; ++j) {
					if (this.newIngredients[j] != null) {
						newArrStr[index] = this.newIngredients[j];
						newArrDou[index] = this.newPrices[j];
						index += 1;
					}
				}
				this.newIngredients = newArrStr;
				this.newPrices = newArrDou;
				return true;
			}
		}
		return false;
	}
	/**
	 * prints all ingredients
	 * prints base ingredients, then prints each ingredient in the string array (with their respective prices)
	 */
	public void printAllIngredients() {
		printBaseIngredients();
		System.out.println("New Ingredients: ");
		for (int i = 0; i < this.newIngredients.length; ++i) {
			System.out.println(this.newIngredients[i] + " $" + String.format("%.2f", this.newPrices[i]));
		}
	}
	/**
	 * prints the total cost of the ingredients
	 * finds the total cost of the base ingredients and the total cost of the new ingredients
	 */
	public void printTotalPrice() {
		double total = 0.0;
		for (int i = 0; i < this.dessert.ingredientsNeeded().length; ++i) {
			total += this.dessert.ingredientsNeeded()[i].getPrice();
		}
		for (int i = 0; i < this.newPrices.length; ++i) {
			total += this.newPrices[i];
		}
		System.out.println("Total Cost: $" + String.format("%.2f", total));
	}
}