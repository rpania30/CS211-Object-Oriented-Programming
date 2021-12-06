/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class Cobbler extends Pastry implements Dessert {
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
	 */
	@Override
	public Ingredient[] ingredientsNeeded() {
		Ingredient[] temp = new Ingredient[8]; {
			temp[0] = Ingredient.Fruit;
			temp[1] = Ingredient.Sugar;
			temp[2] = Ingredient.Salt;
			temp[3] = Ingredient.Butter;
			temp[4] = Ingredient.Flour;
			temp[5] = Ingredient.BakingPowder;
			temp[6] = Ingredient.Milk;
			temp[7] = Ingredient.Cinnamon;
		}
        return temp;
	}
	/**
	 * returns a string representation of the object
	 */
	@Override
	public String description() {
		return "Cobbler";
	}
}