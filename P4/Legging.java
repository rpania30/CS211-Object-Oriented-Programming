/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class Legging extends Pants {
	/**
	 * @param size this is the size of legging
	 * @param color this is color of legging
	 * @param fit this is the fit of legging
	 */
	public Legging(int size, String color, String fit) {
		super("Legging", size, color, fit);
	}
	@Override
	/**
	 * returns the type of the object
	 */
	public String getType() {
		return "Legging";
	}
}