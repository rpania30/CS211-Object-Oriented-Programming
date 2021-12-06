/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class NoBakeCookies extends Cookies {
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
		Ingredient[] temp = new Ingredient[4]; {
			temp[0] = Ingredient.Sugar;
			temp[1] = Ingredient.Butter;
			temp[2] = Ingredient.Milk;
			temp[3] = Ingredient.Flavoring;
		}
        return temp;
	}
	/**
	 * returns a string representation of the object
	 */
	@Override
	public String description() {
		return "No-Bake Cookies";
	}
}