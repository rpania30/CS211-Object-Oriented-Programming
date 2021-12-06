import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class StudentList {
	//Initializes fields
	public Student[] studarr;
	//Default constructor method
	public StudentList() {
		this.studarr = new Student[0];
	}
	//Input constructor method
	public StudentList(String filename) {
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
			sc.close();
			//Initializes the array with the amount of elements necessary
			this.studarr = new Student[counter];
			counter = 0;
			//Opens a file with a scanner
			File inputInfo = new File(filename);
			Scanner scnr = new Scanner(inputInfo);
			while (scnr.hasNextLine()) {
				//Splits each line by a comma
				String[] studentInputs = scnr.nextLine().split(",");
				//Gets int values from each of elements in studentInputs and makes an object
				Student tempStud = new Student(Integer.parseInt(studentInputs[0]), 
				studentInputs[1], Integer.parseInt(studentInputs[2]));
				//Adds the object to the array
				this.studarr[counter] = tempStud;
				counter += 1;
			}
			scnr.close();
		}
		//If not working, throws exception
		catch (FileNotFoundException var) {
		}
	}
	//Private -- Constructor method used to make an object copy
	private StudentList(Student[] arr) {
		studarr = new Student[arr.length];
		//makes a copy of arr
		for (int i = 0; i < arr.length; ++i) {
			studarr[i] = arr[i];
		}
	}
	//Creates and returns a copy of the object
	public StudentList copy() {
		StudentList copy = new StudentList(this.studarr);
		return copy;
	}
	//Returns the size of the array
	public int size() {
		return this.studarr.length;
	}
	//Gives the student at index in a array
	public Student get(int index) {
		//If the index does not exist, throws exception
		if (index > this.studarr.length - 1) {
			throw new RuntimeException();
		}
		else {
			return this.studarr[index];
		}
	}
	//Changes the value at index to a new value
	public void set(int index, Student value) {
		//If the index does not exist, throws exception
		if (index > this.studarr.length - 1) {
			throw new RuntimeException();
		}
		else {
			this.studarr[index] = value;
		}
	}
	//Finds the index of value in the array
	public int indexOf(Student value) {
		for (int i = 0; i < this.studarr.length; ++i) {
			//Checks every value for equality
			if (this.studarr[i] == value) {
				return i;
			}
		}
		//Returns -1 if the value does not exist
		return -1;
	}
	//Adds value to the end of the array
	public void add(Student value) {
		if (value == null) {
			throw new RuntimeException();
		}
		else {
			//Creates a list of Students one larger than the original array
			Student[] temp = new Student[this.studarr.length + 1];
			for (int i = 0; i < this.studarr.length; ++i) {
				//Adds every value from studarr to temp
				temp[i] = studarr[i];
			}
			//Adds the new value to temp and sets temp back equal to studarr
			temp[studarr.length] = value;
			studarr = temp;
		}
	}
	//Inserts a value at a specific index in the array
	public void insert(int index, Student value) {
		//If the index does not exist, throws exception
		if (index > this.studarr.length) {
			throw new RuntimeException();
		}
		else {
			//Creates a list of Students one larger than the original array
			Student[] temp = new Student[this.studarr.length + 1];
			for (int i = 0; i < index; ++i) {
				//Adds every value from studarr to temp up to index
				temp[i] = studarr[i];
			}
			//Inserts the new value into the array
			temp[index] = value;
			//Adds the rest of values from studarr to temp
			for (int i = index; i < this.studarr.length; ++i) {
				temp[i + 1] = studarr[i];
			}
			//sets temp back equal to studarr
			studarr = temp;
		}
	}
	//Removes a value from the array
	public void remove(Student value) {
		//If the value doesnt exist, throws exception
		if (this.indexOf(value) == -1) {
			throw new RuntimeException();
		}
		else {
			//Creates a list of Students one smaller than the original array
			Student[] temp = new Student[this.studarr.length - 1];
			for (int i = 0; i < this.indexOf(value); ++i) {
				//Adds every value from studarr to temp up to the index of the value
				temp[i] = studarr[i];
			}
			for (int i = this.indexOf(value) + 1; i < this.studarr.length - 1; ++i) {
				//Adds the rest of the values from studarr to temp up skipping the index of the value
				temp[i] = studarr[i];
			}
			//sets temp back equal to studarr
			studarr = temp;
		}
	}
	//Finds the student with the highest SAT score
	public int getHighestScoreStudent() {
		//Finds an initial value for the highest score
		int highestScore = this.studarr[0].getSAT();
		for (int i = 1; i < this.studarr.length; ++i) {
			//If the score is higher, the highestScore is set with the new value
			if (this.studarr[i].getSAT() > highestScore) {
				highestScore = this.studarr[i].getSAT();
			}
		}
		return highestScore;
	}
	//String representation of the object
	@Override
	public String toString() {
		String rstr;
		rstr = "{";
		//Adds every value in the array up to the last with a comma and a space
		for (int i = 0; i < this.studarr.length - 1; ++i) {
			rstr += this.studarr[i] + ", ";
		}
		//Adds the last value in the array to the string
		rstr += this.studarr[this.studarr.length - 1] + "}";
		return rstr;
	}
}