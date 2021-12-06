import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/**
 *
 * @author Rishi
 * @version 1.0
 *
 */
public class InsideCloset {
	/**
	 * fields:
	 * myCloset: represents an ArrayList of Label objects
	 */
	private ArrayList<Label<String, Clothing>> myCloset = new ArrayList<Label<String, Clothing>>();
	/**
	 * @param filename this is the file input
	 */
	/**
	 * creates an InsideCloset object using data from a file
	 * creates a list of strings for every line in the file
	 * uses the list to access various inputs for clothing constructors and creates objects
	 * uses the Label class to create an object to add to myCloset
	 * if the filename is not recognized or a clothing type does not exist, throws error
	 */
	public InsideCloset(String filename) {
		Scanner input = null;
		try {
			File inFile = new File(filename);
            input = new Scanner(inFile);
		}
		catch (FileNotFoundException exception1) {
			System.out.println(exception1);
		}
		try {
			while (input.hasNextLine()) {
				String[] currArr = input.nextLine().split(",");
				if (currArr[0].equals("Graphic T-Shirt")) {
					String color = "";
					color += currArr[3];
					int i = 4;
					while (i < currArr.length - 1) {
						color += " " + currArr[i];
						++i;
					}
					GraphicTshirt currObj = new GraphicTshirt(new Graphic(currArr[1], currArr[2]), Integer.parseInt(currArr[currArr.length - 1]), color);
					Label<String, Clothing> testLab = new Label<String, Clothing>("Graphic T-Shirt", currObj);
					myCloset.add(testLab);
				}
				else if (currArr[0].equals("Jeans")) {
					String color = "";
					color += currArr[2];
					int i = 3;
					while (i < currArr.length - 1) {
						color += " " + currArr[i];
						++i;
					}
					JEANFIT jeanFit = JEANFIT.Skinny;
					if (currArr[1].equals("skinny")) {
						jeanFit = JEANFIT.Skinny;
					}
					else if (currArr[1].equals("straight")) {
						jeanFit = JEANFIT.Straight;
					}
					else if (currArr[1].equals("bootcut")) {
						jeanFit = JEANFIT.Bootcut;
					}
					Jeans currObj = new Jeans(Integer.parseInt(currArr[currArr.length - 1]), color, jeanFit);
					Label<String, Clothing> testLab = new Label<String, Clothing>("Jeans", currObj);
					myCloset.add(testLab);
				}
				else if (currArr[0].equals("Legging")) {
					String color = "";
					color += currArr[2];
					int i = 3;
					while (i < currArr.length - 1) {
						color += " " + currArr[i];
						++i;
					}
					Legging currObj = new Legging(Integer.parseInt(currArr[currArr.length - 1]), color, currArr[1]);
					Label<String, Clothing> testLab = new Label<String, Clothing>("Legging", currObj);
					myCloset.add(testLab);
				}
				else if (currArr[0].equals("Shorts")) {
					String color = "";
					color += currArr[2];
					int i = 3;
					while (i < currArr.length - 1) {
						color += " " + currArr[i];
						++i;
					}
					Shorts currObj = new Shorts(Integer.parseInt(currArr[currArr.length - 1]), color, currArr[1]);
					Label<String, Clothing> testLab = new Label<String, Clothing>("Shorts", currObj);
					myCloset.add(testLab);
				}
				else if (currArr[0].equals("Sweater")) {
					String color = "";
					color += currArr[2];
					int i = 3;
					while (i < currArr.length - 1) {
						color += " " + currArr[i];
						++i;
					}
					SWEATERTYPE sweaterFit = SWEATERTYPE.Cardigan;
					if (currArr[1].equals("cardigan")) {
						sweaterFit = SWEATERTYPE.Cardigan;
					}
					else if (currArr[1].equals("pullover")) {
						sweaterFit = SWEATERTYPE.Pullover;
					}
					else if (currArr[1].equals("shrug")) {
						sweaterFit = SWEATERTYPE.Shrug;
					}
					Sweater currObj = new Sweater(sweaterFit, Integer.parseInt(currArr[currArr.length - 1]), color);
					Label<String, Clothing> testLab = new Label<String, Clothing>("Sweater", currObj);
					myCloset.add(testLab);
				}
				else if (currArr[0].equals("Tank Top")) {
					String color = "";
					color += currArr[2];
					int i = 3;
					while (i < currArr.length - 1) {
						color += " " + currArr[i];
						++i;
					}
					TankTop currObj = new TankTop(currArr[1], Integer.parseInt(currArr[currArr.length - 1]), color);
					Label<String, Clothing> testLab = new Label<String, Clothing>("Tank Top", currObj);
					myCloset.add(new Label<String, Clothing>("Tank Top", currObj));
				}
				else {
					throw new ClothingException("invalid item");
				}
			}
			input.close();
		}
		catch (ClothingException exception2) {
			System.out.println(exception2);
		}
	}
	/**
	 * prints all objects in myCloset
	 */
	public void printWholeCloset() {
		for (int i = 0; i < myCloset.size(); ++i) {
			System.out.println(myCloset.get(i).getValue());
		}
	}
	/**
	 * prints all objects of a specific clothing type in myCloset
	 * if the clothing type does not exist, throws exception
	 */
	public void printSpecificClothing(String type) throws ClothingException {
		if (type.equals("Graphic T-Shirt") || type.equals("Jeans") || type.equals("Shorts") || type.equals("Sweater") || type.equals("Tank Top") || type.equals("Legging")) {
			for (int i = 0; i < myCloset.size(); ++i) {
				if (myCloset.get(i).getKey() == type) {
					System.out.println(myCloset.get(i).getValue());
				}
			}
		}
		else {
			throw new ClothingException("invalid item");
		}
	}
	/**
	 * creates a new Clothing type ArrayList and adds all objects in myCloset to it
	 * adds the the objects in the order of Graphic T-shirt, Jeans, Legging, Shorts, Sweater, Tank Top
	 */
	public ArrayList<Clothing> organizedCloset() {
		ArrayList<Clothing> orgClos = new ArrayList<Clothing>();
		for (int i = 0; i < myCloset.size(); ++i) {
			if (myCloset.get(i).getKey() == "Graphic T-Shirt") {
				orgClos.add(myCloset.get(i).getValue());
			}
		}
		for (int i = 0; i < myCloset.size(); ++i) {
			if (myCloset.get(i).getKey() == "Jeans") {
				orgClos.add(myCloset.get(i).getValue());
			}
		}
		for (int i = 0; i < myCloset.size(); ++i) {
			if (myCloset.get(i).getKey() == "Legging") {
				orgClos.add(myCloset.get(i).getValue());
			}
		}
		for (int i = 0; i < myCloset.size(); ++i) {
			if (myCloset.get(i).getKey() == "Shorts") {
				orgClos.add(myCloset.get(i).getValue());
			}
		}
		for (int i = 0; i < myCloset.size(); ++i) {
			if (myCloset.get(i).getKey() == "Sweater") {
				orgClos.add(myCloset.get(i).getValue());
			}
		}
		for (int i = 0; i < myCloset.size(); ++i) {
			if (myCloset.get(i).getKey() == "Tank Top") {
				orgClos.add(myCloset.get(i).getValue());
			}
		}
		return orgClos;
	}
	/**
	 * creates and returns a new Clothing type ArrayList and adds objects to it
	 * add objects that are for the opposite body area (tops, bottoms) and checks to see if the color desired is represented
	 * if the clothing type does not exist or the color is not represented, throws error
	 */
	public ArrayList<Clothing> colorCoordinate(String item, String color) throws ClothingException {
		ArrayList<Clothing> coordination = new ArrayList<Clothing>();
		String[] colors;
		int counter = 0;
		if (item.equals("Graphic T-Shirt") || item.equals("Sweater") || item.equals("Tank Top")) {
			for (int i = 0; i < myCloset.size(); ++i) {
				if (myCloset.get(i).getKey().equals("Jeans") || myCloset.get(i).getKey().equals("Shorts") || myCloset.get(i).getKey().equals("Legging")) {
					if (myCloset.get(i).getValue().getColor().contains(color)) {
						coordination.add(myCloset.get(i).getValue());
						++counter;
					}
				}
			}
			if (counter == 0) {
				throw new ClothingException("nothing of that color in your closet");
			}
		}
		else if (item.equals("Jeans") || item.equals("Shorts") || item.equals("Legging")){
			for (int i = 0; i < myCloset.size(); ++i) {
				if (myCloset.get(i).getKey().equals("Graphic T-Shirt") || myCloset.get(i).getKey().equals("Sweater") || myCloset.get(i).getKey().equals("Tank Top")) {
					if (myCloset.get(i).getValue().getColor().contains(color)) {
						coordination.add(myCloset.get(i).getValue());
						++counter;
					}
				}
			}
			if (counter == 0) {
				throw new ClothingException("nothing of that color in your closet");
			}
		}
		else {
			throw new ClothingException("invalid item");
		}
		return coordination;
	}
}