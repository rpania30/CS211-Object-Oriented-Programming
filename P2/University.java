public class University {
	/*
	public static void main(String[] args) {
		University university = new University(189,"Washington University in St. Louis",6589,1409);
		System.out.println(university.lastAdmittedStudentSAT());
	}
	*/
	//Initializes fields
	private int id;
	private String name;
	private int numOfPositions;
	private int minSAT;
	private String disabled;
	private StudentList admitted;
	//Input constructor method
	public University(int id, String name, int numOfPositions, int minSAT) {
		this.id = id;
		this.name = name;
		this.numOfPositions = numOfPositions;
		this.minSAT = minSAT;
		this.admitted = new StudentList();
	}
	//Getter methods
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public int getNumOfPositions() {
		return this.numOfPositions;
	}
	public int getMinSAT() {
		return this.minSAT;
	}
	//Determines whether there is a minimum SAT requirement for the university
	public void activateMinSAT(boolean value) {
		if (value == true) {
			this.disabled = "enabled";
		}
		else {
			this.disabled = null;
		}
	}
	//Determines if a student can be admitted
	public boolean admit(Student value) {
		//Checks if the SAT requirement is enabled
		if (this.disabled == null) {
			//Checks to see if there are remaining spots
			if (this.numOfPositions > 0) {
				//Adds the value to the list
				admitted.add(value);
				//Decreases the amount of spots left by 1
				this.numOfPositions -= 1;
				return true;
			}
			else {
				return false;
			}
		}
		else {
			if (value.getSAT() >= this.minSAT) {
				if (this.numOfPositions > 0) {
					admitted.add(value);
					this.numOfPositions -= 1;
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
	}
	//Returns the array of admitted students
	public StudentList getAdmittedStudents() {
		return admitted;
	}
	//Gives the lowest SAT score in admitted students
	public int lastAdmittedStudentSAT() {
		//Creates an initial value for the lowest score
		int lowestScore = 0;
		for (int i = 0; i < admitted.studarr.length; i++) {
			//If the score is lower, the lowestScore is set with the new value
			if (admitted.studarr[i].getSAT() < lowestScore || i == 0) {
				lowestScore = admitted.studarr[i].getSAT();
			}
		}
		return lowestScore;
	}
	//Clears the internal storage of admitted students
	public void resetAdmissions() {
		//Sets the array to an empty list
		StudentList resetArr = new StudentList();
		admitted = resetArr;
	}
	//String representation of the object
	@Override
	public String toString() {
		return this.getId() + ": " + this.getName(); 
	}
	//Compares two objects
	@Override
	public boolean equals(Object other) {
		//Checks if object is an instance of Student
		if (!(other instanceof University)) {
			return false;
		}
		else {
			//Compares the ids and names
			University compare2 = (University) other;
			if (this.getId() == compare2.getId()) {
				if (this.getName().equals(compare2.getName()) == true) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
	}
}