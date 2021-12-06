/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class Shorts extends Pants {
	/**
	 * @param size this is the size of shorts
	 * @param color this is color of shorts
	 * @param fit this is the fit of shorts
	 */
	public Shorts(int size, String color, String fit) {
		super("Shorts", size, color, fit);
	}
	/**
	 * returns the type of the object
	 */
	@Override
	public String getType() {
		return "Shorts";
	}
}