public class Log {
	//Initializes fields
	private String[] readMsg;
	private String[] compare;
	//Default constructor
	public Log() {
		this.readMsg = new String[0];
	}
	//Private -- Constructor method used to make an object copy
	private Log(String[] arr) {
		//Initializes readMsg using an input array
		this.readMsg = new String[arr.length];
		for (int i = 0; i < arr.length; ++i) {
			//Sets all arr values to readMsg values
			readMsg[i] = arr[i];
		}
	}
	//Private -- Constructor method used to make an object with specified length
	private Log(int size) {
		this.compare = new String[size];
	}
	//Creates and returns a copy of the object
	public Log copy() {
		Log copy = new Log(this.readMsg);
		return copy;
	}
	//Returns an array of strings
	public String[] read() {
		return this.readMsg;
	}
	//Adds a message to the object
	public void record(String msg) {
		//Creates a list of Students one larger than the original array
		String[] temp = new String[readMsg.length + 1];
		if (this.readMsg.length == 0) {
			this.readMsg = new String[] {msg};
		}
		else {
			//Sets all readMsg values in the new array
			for (int i = 0; i < this.readMsg.length; ++i) {
				temp[i] = this.readMsg[i];
			}
			//Adds the message to the new array
			temp[readMsg.length] = msg;
			//Sets the new array back to the old array
			this.readMsg = temp;
		}
	}
}