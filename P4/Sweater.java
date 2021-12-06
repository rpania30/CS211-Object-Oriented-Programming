/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class Sweater extends Tops {
	/**
	 * fields:
	 * sweaterType: represents the type of the sweater
	 */
	private SWEATERTYPE sweaterType;
	/**
	 * @param sweaterType this is the type of sweater
	 * @param size this is the size of the sweater
	 * @param color this is the color of the sweater
	 */
	public Sweater(SWEATERTYPE sweaterType, int size, String color) {
		super(sweaterType.toString(), size, color);
		this.sweaterType = sweaterType;
	}
	/**
	 * returns the type of the object
	 */
	@Override
	public String getType() {
		return "Sweater(" + this.sweaterType.toString() + ")";
	}
}