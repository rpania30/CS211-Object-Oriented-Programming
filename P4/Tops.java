/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
abstract class Tops implements Clothing {
	/**
	 * fields:
	 * type: represents the type of the top
	 * size: represents the top size
	 * color: represents the top color
	 */
	private String type;
	private int size;
	private String color;
	/**
	 * @param type this is the type of the top
	 * @param size this is the top size
	 * @param color this is top color
	 */
	public Tops(String type, int size, String color) {
		this.type = type;
		this.size = size;
		this.color = color;
	}
 	/**
	 * sets the type of the object
	 */
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
	 * returns a string representation of the object
	 */
	@Override
	public String toString() {
		return "Type: " + this.getType() + " Size: " + this.getSize() + " Color: " + this.getColor();
	}
}