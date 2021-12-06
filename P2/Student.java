public class Student {
	//Initializes fields
	private int id;
	private String name;
	private int SAT;
	//Input constructor method
	public Student(int id, String name, int SAT) {
		this.id = id;
		this.name = name;
		this.SAT = SAT;
	}
	//Getter methods
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public int getSAT() {
		return this.SAT;
	}
	//Creates and returns a copy of the object
	public Student copy() {
		Student copy = new Student(this.getId(), this.getName(), this.getSAT());
		return copy;
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
		if (!(other instanceof Student)) {
			return false;
		}
		else {
			//Compares the ids and names
			Student compare = (Student) other;
			if (this.getId() == compare.getId()) {
				if (this.getName().equals(compare.getName()) == true) {
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