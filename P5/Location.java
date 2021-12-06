/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class Location {
	/**
	 * fields:
	 * locName: represents the name of a location object
	 * locDesc: represents the description of a location object
	 */
	private String locName, locDesc;
	/**
	 * @param locName this is the location's name
	 * @param locDesc this is the location's description
	 */
	public Location(String locName, String locDesc) {
		this.locName = locName;
		this.locDesc = locDesc;
	}
	/**
	 * sets the location name to a passed in string
	 */
	public void setLocName(String locName) {
		this.locName = locName;
	}
	/**
	 * sets the location description to a passed in string
	 */
	public void setLocDesc(String locDesc) {
		this.locDesc = locDesc;
	}
	/**
	 * returns the location name
	 */
	public String getLocName() {
		return this.locName;
	}
	/**
	 * returns the location description
	 */
	public String getLocDesc() {
		return this.locDesc;
	}
	/**
	 * returns a string representation of the object
	 */
	public String toString() {
		return this.locName + "(" + this.locDesc + ")";
	}
}