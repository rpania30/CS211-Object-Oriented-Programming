import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class UniversityList {
	//Initializes fields	
	private University[] univarr;
	//Default constructor
	public UniversityList() {
		this.univarr = new University[0];
	}
	//Input constructor method
	public UniversityList(String filename) {
		int counter = 0;
		try {
			//Opens a file with a scanner
			File inputCount = new File(filename);
			Scanner sc = new Scanner(inputCount);
			//Finds number of elements necessary
			while (sc.hasNextLine()) {
				counter += 1;
				sc.nextLine();
			}
			//Initializes the array with the amount of elements necessary
			this.univarr = new University[counter];
			sc.close();
			counter = 0;
			//Opens a file with a scanner
			File inputInfo = new File(filename);
			Scanner scnr = new Scanner(inputInfo);
			while (scnr.hasNextLine()) {
				//Splits each line by a comma
				String[] studentInputs = scnr.nextLine().split(",");
				//Gets int values from each of elements in studentInputs and makes an object
				University tempUniv = new University(Integer.parseInt(studentInputs[0]), 
				studentInputs[1], Integer.parseInt(studentInputs[2]), Integer.parseInt(studentInputs[3]));
				//Adds the object to the array
				this.univarr[counter] = tempUniv;
				counter += 1;
			}
			scnr.close();
		}
		//If not working, throws exception
		catch (FileNotFoundException var) {
		}
	}
	//Returns the amount of elements in the array
	public int size() {
		return this.univarr.length;
	}
	//Finds the value at the given index in the array
	public University get(int index) {
		//If the index does not exist, throws exception
		if (index > this.univarr.length - 1) {
			throw new RuntimeException();
		}
		else {
			return this.univarr[index];
		}
	}
	//Changes the value at index to a new value
	public void set(int index, University value) {
		//If the index does not exist, throws exception
		if (index > this.univarr.length - 1) {
			throw new RuntimeException();
		}
		else {
			this.univarr[index] = value;
		}
	}
	//Finds the index of value in the array
	public int indexOf(University value) {
		for (int i = 0; i < this.univarr.length; ++i) {
			//Checks every value for equality
			if (this.univarr[i] == value) {
				return i;
			}
		}
		//If the value does not exist, returns -1
		return -1;
	}
	//Overloaded - Finds the index of value in the array
	public int indexOf(int universityId) {
		for (int i = 0; i < this.univarr.length; ++i) {
			//Checks every value for equality
			if (this.univarr[i].getId() == universityId) {
				return i;
			}
		}
		//If the value does not exist, returns -1
		return -1;
	}
	//Inserts a value at a specific index in the array
	public void insert(University value) {
		int holder = univarr.length;
		//If the index does not exist, throws exception
		if (value == null) {
			throw new RuntimeException();
		}
		else if (this.univarr.length == 0) {
			this.univarr = new University[] {value};
		}
		else {
			//Creates a list of Students one larger than the original array
			University[] temp = new University[this.univarr.length + 1];
			for (int i = 0; i < this.univarr.length; i++) {
				//Stops when it finds the index location and holds value
				if (this.univarr[i].getName().compareTo(value.getName()) > 0) {
					temp[i] = value;
					holder = i;
					break;
				}
				else {
					//Adds values from univarr to temp in alphabetical order
					temp[i] = this.univarr[i];
				}
			}
			//Inserts the held value into the new array
			temp[holder] = value;
			for (int i = holder; i < this.univarr.length; ++i) {
				//Adds all other values from the original array to the new array
				temp[i + 1] = this.univarr[i];
			}
			//sets temp back equal to univarr
			this.univarr = temp;
		}
	}
	//String representation of the object
	@Override
	public String toString() {
		String rstr;
		rstr = "{";
		//Adds every value in the array up to the last with a comma and a space
		for (int i = 0; i < this.univarr.length - 1; ++i) {
			rstr += this.univarr[i] + ", ";
		}
		//Adds the last value in the array to the string
		if (this.univarr.length == 0) {
			rstr += this.univarr[this.univarr.length] + "}";
		}
		else {
			rstr += this.univarr[this.univarr.length - 1] + "}";
		}
		return rstr;
	}
}