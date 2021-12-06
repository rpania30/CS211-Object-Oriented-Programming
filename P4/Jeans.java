/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class Jeans extends Pants {
	/**
	 * fields:
	 * jeanFit: represents the fit of the jeans
	 */
	private JEANFIT jeanFit;
	/**
	 * @param size this is the size of jeans
	 * @param color this is color of jeans
	 * @param jeanFit this is the fit of jeans
	 */
	public Jeans(int size, String color, JEANFIT jeanFit) {
		super("Jeans", size, color, jeanFit.toString());
		this.jeanFit = jeanFit;
	}
	/**
	 * returns the type of the object
	 */
	@Override
	public String getType() {
		return "Jeans";
	}
	/**
	 * sets the fit of the object
	 */
	@Override
	public String getFit() {
		return jeanFit.toString();
	}
}