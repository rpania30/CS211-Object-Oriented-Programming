/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class Label <Type1, Type2> {
	/**
	 * fields:
	 * Type1: represents the type of clothing in a Label object
	 * Type2: represents a clothing object of the given clothing type
	 */
	private Type1 key;
	private Type2 value;
	/**
	 * @param key this is the String of the clothing type
	 * @param value this is the object of the clothing type
	 */
	public Label(Type1 key, Type2 value) {
		this.key = key;
		this.value = value;
	}
	/**
	 * sets the String type of the object
	 */
	public void setKey(Type1 key) {
		this.key = key;
	}
	/**
	 * returns the String type of the object
	 */
	public Type1 getKey() {
		return this.key;
	}
	/**
	 * sets the clothing object
	 */
	public void setValue(Type2 value) {
		this.value = value;
	}
	/**
	 * returns the clothing object
	 */
	public Type2 getValue() {
		return this.value;
	}
}