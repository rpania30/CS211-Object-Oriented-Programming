/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public interface Dessert {
	public abstract double baseCost();
	public abstract Ingredient[] ingredientsNeeded();
	public abstract String description();
}