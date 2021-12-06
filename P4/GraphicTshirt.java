/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class GraphicTshirt extends Tops {
	/**
	 * fields:
	 * info: represents a Graphic object
	 */
	private Graphic info;
	/**
	 * @param info this is the Graphic object
	 * @param size this is the size of the t-shirt
	 * @param color this is the fit of the t-shirt
	 */
	public GraphicTshirt(Graphic info, int size, String color) {
		super("Graphic T-Shirt", size, color);
		this.info = info;
	}
	/**
	 * returns the type of the object
	 */
	@Override
	public String getType() {
		return "Graphic T-Shirt";
	}
	/**
	 * returns a string representation of the object
	 */
	@Override
	public String toString() {
		return super.toString() + " Graphic Style: " + info.getStyle() + " Graphic Description: " + info.getDescription();
	}
}