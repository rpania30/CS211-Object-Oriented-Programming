/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class Pie extends Pastry implements Dessert {
	/**
	 * fields:
	 * type: represents the type of pie
	 */
	public PieType type;
	/**
	 * @param type this is the type of pie
	 */
	public Pie(PieType input) {
		this.type = input;
	}
	public Pie() {
		this.type = PieType.Cream;
	}
	/**
	 * @param input this is the type of pie
	 */
	public void setPieType(PieType input) {
		this.type = input;
	}
	/**
	 * returns the type of pie
	 */
	public PieType getPieType() {
		return this.type;
	}
	/**
	 * returns an cost total of ingredients in an array
	 * adds the price of each ingredient to a total
	 */
	@Override
	public double baseCost() {
		double total = 0.0;
		for (int i = 0; i < this.ingredientsNeeded().length; ++i) {
			total += this.ingredientsNeeded()[i].getPrice();
		}
		return total;
	}
	/**
	 * returns an array of ingredients
	 * compares the given pie type to all the pie types in order to return the correct array
	 */
	@Override
	public Ingredient[] ingredientsNeeded() {
		if (this.getPieType() == PieType.Cream) {
			Ingredient[] temp = new Ingredient[5]; {
				temp[0] = Ingredient.Milk;
				temp[1] = Ingredient.Cream;
				temp[2] = Ingredient.Sugar;
				temp[3] = Ingredient.Flour;
				temp[4] = Ingredient.Eggs;
			}
            return temp;
		}
		else if (this.getPieType() == PieType.Fruit) {
			Ingredient[] temp = new Ingredient[6]; {
				temp[0] = Ingredient.Fruit;
				temp[1] = Ingredient.Sugar;
				temp[2] = Ingredient.Salt;
				temp[3] = Ingredient.Flour;
				temp[4] = Ingredient.Butter;
				temp[5] = Ingredient.Eggs;
			}
            return temp;
		}
		else {
			Ingredient[] temp = new Ingredient[4]; {
				temp[0] = Ingredient.Milk;
				temp[1] = Ingredient.Cream;
				temp[2] = Ingredient.Sugar;
				temp[3] = Ingredient.Eggs;
			}
            return temp;
		}
	}
	/**
	 * returns a string representation of the object
	 * compares the given pie type to all the pie types in order to return the correct string
	 */
	@Override
	public String description() {
		if (this.getPieType() == PieType.Cream) {
			return "Cream Pie";
		}
		else if (this.getPieType() == PieType.Fruit) {
			return "Fruit Pie";
		}
		else {
			return "Custard Pie";
		}
	}
}