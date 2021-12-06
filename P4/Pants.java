/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
abstract class Pants implements Clothing, Bottoms {
	/**
	 * fields:
	 * type: represents the type of the pants
	 * size: represents the pants size
	 * color: represents the pants color
	 * fit: represents the pants fit
	 */
	private String type;
	private int size;
	private String color;
	private String fit;
	/**
	 * @param type this is the type of pants
	 * @param size this is the size of pants
	 * @param color this is color of pants
	 * @param fit this is the fit of pants
	 */
	public Pants(String type, int size, String color, String fit) {
		this.type = type;
		this.size = size;
		this.color = color;
		this.fit = fit;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * returns the type of the object
	 */
	@Override
	public String getType() {
		return this.type;
	}
	/**
	 * sets the size of the object
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * returns the size of the object
	 */
	@Override
	public int getSize() {
		return this.size;
	}
	/**
	 * sets the color of the object
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * returns the color of the object
	 */
	@Override
	public String getColor() {
		return this.color;
	}
	/**
	 * sets the fit of the object
	 */
	public void setFit(String fit) {
		this.fit = fit;
	}
	/**
	 * returns the fit of the object
	 */
	@Override
	public String getFit() {
		return this.fit;
	}
	/**
	 * returns a string representation of the object
	 */
	@Override
	public String toString() {
		return "Type: " + this.getType() + " Size: " + this.getSize() + " Color: " + this.getColor() + " Fit: " + this.getFit();
	}
}