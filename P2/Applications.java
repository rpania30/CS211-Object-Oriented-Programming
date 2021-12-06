import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Applications {
	/*public static void main(String[] args) {	
		Applications w = new Applications("applications.csv");
        System.out.print(w.toString());
	}
	*/
	//Initializes fields
	private int[] studIden;
	private int[][] univIden;
	//Input Constructor Method
	public Applications(String filename) {
		int counter = 0;
		int counter1 = 0;
		int[] holder = new int[0];
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
			this.studIden = new int[counter];
			//Initializes the array with the amount of elements necessary and empty placeholder
			this.univIden = new int[counter][0];
			//Opens a file with a scanner
			File inputInfo = new File(filename);
			Scanner scnr = new Scanner(inputInfo);
			counter = 0;
			while (scnr.hasNextLine()) {
				//Splits each line by a comma
				String[] studentInputs = scnr.nextLine().split(",");
				//Gets the studentid value
				this.studIden[counter] = Integer.parseInt(studentInputs[0]);
				for (int i = 1; i < studentInputs.length; i++) {
					counter1++;
				}
				for (int i = 1; i < studentInputs.length; i++) {
					int[] temp = new int[counter1];
					//Adds all university ids to a placeholder
					temp[i - 1] = Integer.parseInt(studentInputs[i]);
					holder = temp;
				}
				//Uses holder value to add to the array
				this.univIden[counter] = holder;
				counter++;
			}
			scnr.close();
		}
		//If not working, throws exception
		catch (FileNotFoundException var) {
		}
	}
	//Determines the size of the array
	public int size() {
		return this.studIden.length;
	}
	//Returns the id of the student at a given index
	public int getStudentId(int index) {
		return this.studIden[index];
	}
	//Finds the universities applied to by the given student
	public int[] getStudentSelections(int studentId) {
		for (int i = 0; i < this.studIden.length; i++) {
			//Compares the studentid with every id in studIden
			if (this.studIden[i] == studentId) {
				return this.univIden[i];
			}
		}
		throw new RuntimeException();
	}
	//Returns the array of student ids that applied to a given university
	public int[] getStudentsByUniversity(int universityId) {
		int count = 0;
		for (int i = 0; i < this.studIden.length; i++) {
			for (int j = 0; j < this.univIden[i].length; j++) {
				//compares every value in univIden to the university id
				if (this.univIden[i][j] == universityId) {
					count += 1;
					break;
				}
			}
		}
		//Creates a new array
		int[] temp = new int[count];
		count = 0;
		for (int i = 0; i < this.studIden.length; i++) {
			for (int j = 0; j < this.univIden[i].length; j++) {
				//compares every value in univIden to the university id
				if (this.univIden[i][j] == universityId) {
					//Sets the temporary element to the student id
					temp[count] = this.studIden[i];
					++count;
					break;
				}
			}
		}
		return temp;
	}
	//Finds the university at a given rank on the student's array
	public int getUniversityByStudentsRank(int studentId, int rank) {
		for (int i = 0; i < this.studIden.length; i++) { 
			//Compares the studentid with every id in studIden
			if (this.studIden[i] == studentId) {
				return this.univIden[i][rank];
			}
		}
		return 0;
	}
	//String representation of the object
	@Override
	public String toString() {
		String rstr = "{";
		int index = 0;
		for (int i = 0; i < this.studIden.length; i++) {
			//Adds every student id to the string
			rstr += this.studIden[i] + ":";
			//Adds every university id to the string up
			for (int j = 0; j < this.univIden[i].length; j++) {
				rstr += " " + this.univIden[i][j];
			}
			if (i < this.studIden.length - 1) {
				rstr += ", ";
			}
		}
		rstr += "}";
		return rstr;
	}
}