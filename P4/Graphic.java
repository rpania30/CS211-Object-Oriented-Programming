/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class Graphic {
	/**
	 * fields:
	 * style: represents the style of the graphic
	 * description: provides a description of the graphic
	 */
	private String style;
	private String description;
	/**
	 * @param style this is the graphic style
	 * @param description this is the graphic description
	 */
	public Graphic(String style, String description) {
		this.style = style;
		this.description = description;
	}
	/**
	 * returns the style of the object
	 */
	public String getStyle() {
		return this.style;
	}
	/**
	 * sets the style of the object
	 */
	public void setStyle(String style) {
		this.style = style;
	}
	/**
	 * returns the description of the object
	 */
	public String getDescription() {
		return this.description;
	}
	/**
	 * sets the description of the object
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}