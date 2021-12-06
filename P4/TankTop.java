/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class TankTop extends Tops {
	/**
	 * fields:
	 * strapType: represents the type of tanktop strap
	 */
	private String strapType;
	/**
	 * @param strapType this is the type of the tanktop strap
	 * @param size this is the size of the tanktop
	 * @param color this is tanktop color
	 */
	public TankTop(String strapType, int size, String color) {
		super("Tank Top", size, color);
		this.strapType = strapType;
	}
	/**
	 * sets the strap type of the object
	 */
	public void setStrapType(String strapType) {
		this.strapType = strapType;
	}
	/**
	 * returns the strap type of the object
	 */
	public String getStrapType() {
		return this.strapType;
	}
	/**
	 * returns the type of the object
	 */
	@Override
	public String getType() {
		return "Tank Top";
	}
	/**
	 * returns a string representation of the object
	 */
	@Override
	public String toString() {
		return super.toString() + " Strap Type: " + this.getStrapType();
	}
}