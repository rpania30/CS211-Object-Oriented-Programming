public class Project1 {
	//Task 1
	public static int pandemic(int numOfCases, byte dailyIncreaseRate, char today) {
		int startingCases = numOfCases;
		double increaseRate = dailyIncreaseRate;
		int num = 0;
		int days = 0;
	  
		//Sets different days to different indexes
		if (today == 'T') {
			num = 1;
		}
		else if (today == 'W') {
			num = 2;
		}
		else if (today == 'R') {
			num = 3;
		}
		else if (today == 'F') {
			num = 4;
		}
		else if (today == 'S') {
			num = 5;
		}
		else if (today == 'U') {
			num = 6;
		}
		num += 1;
		//Runs until the number of starting cases is doubled
		while (numOfCases < (startingCases * 2)) {
			//Executes if it is the first day of the week
			if (num == 0) {
				numOfCases *= (1 + (increaseRate/100));
				num += 1;
				days += 1;
				System.out.println(numOfCases);
			}
			//Executes on Saturdays and increases the rate by double
			else if (num % 5 == 0) {
				increaseRate *= 2;
				numOfCases *= (1 + (increaseRate/100));
				//Resets rate
				increaseRate /= 2;
				num += 1;
				days += 1;
				System.out.println(numOfCases);
			}
			//Executes on Sundays and increases the rate by triple
			else if (num % 6 == 0) {
				increaseRate *= 3;
				numOfCases *= (1 + (increaseRate/100));
				//Resets rate
				increaseRate /= 3;
				num = 0;
				days += 1;
				System.out.println(numOfCases);
			}
			//Executes on all other days of the week
			else {
				numOfCases *= (1 + (increaseRate/100));
				num += 1;
				days += 1;
				System.out.println(numOfCases);
			}
		}
		//Returns total amount of days
		return days;
	}
	//Task 2
	public static int numDivisors(int num) {
		int divCount = 1;
		int n = 1;
		//If num is less than 0, the branch executes
		if (num < 0) {
			return -1;
		}
		//Executes when num is greater than 0
		else {
			//Finds the amount of divisors in num
			while (n < num) {
				//If there is no remainder, it is a divisor
				if (num % n == 0) {
					//The number of divisors is incremented
					divCount += 1;
				}
				//Increases the value of the divisor
				n += 1;
			}
		return divCount;
		}
	}
	public static boolean highlyComposite(int num) {
		int curCount = 0;
		int i = 0;
		//Checks each value under num to see the maximum number of divisors
		while (i < num) {
			if (numDivisors(i) > curCount) {
				curCount = numDivisors(i);
			}
			i += 1;
		}
		//If a value under num has less divisors than it, the branch is executed
		if (numDivisors(num) == 1) {
			return true;
		}
		else if (curCount < numDivisors(num)) {
			return true;
		}
		//If a value under num has more divisors than it, the branch is executed
		else {
			return false;
		}
	}
	//Task 3
	public static int[][] triangularArray(int[][] arr) {
		int numElements = 0;
		int i;
		int j;
		//Finds number of elements in arr
		for (i = 0; i < arr.length; ++i) {
			//Adds to a counter for every element in arr
			for (j = 0; j < arr[i].length; ++j) {
				numElements += 1;
			}
		}
		int[] orgArray = new int[numElements];
		int index = 0;
		//Loops through every element in arr
		for (i = 0; i < arr.length; ++i) {
			//Puts all elements into a new array
			for (j = 0; j < arr[i].length; ++j) {
				orgArray[index] = arr[i][j];
				index += 1;
			}
		}
		int numArray = 0;
		int x = 1;
		int tempNum = numElements;
		//Determines amount of rows needed in finArray
		while (tempNum > 0) {
			tempNum -= x;
			x += 1;
			numArray += 1;
		}
	  
		int desAmt = 1;
		index = 0;
		int[][] finArray = new int[numArray][desAmt];
		//Adds elements from orgArray to finArray
		for (i = 0; i < numArray; ++i) {
			//Loops through based on the amount of digits needed in the certain sub array
			for (j = 0; j < desAmt; ++j) {
				 //Adds elements to the new array
				 finArray[i][j] = orgArray[index];
				 index += 1;
				 //Deincrements the amount of elements remaining
				 numElements -= 1;
			}
			//Executes when it is the second to last sub array
			if (i < numArray - 2) {
				finArray[i + 1] = new int[i + 2];
				desAmt += 1;
			}
			//Makes the final sub array based on how many elements are remaining
			else if (i < numArray - 1) {
				finArray[i + 1] = new int[numElements];
				desAmt = numElements;
			}
		}
		//Returns the newly created array
		return finArray;
	}
	//Task 4
	public static int[] maxSpan(int[] arr) {
		int[] testArray = new int[2];
		return testArray;
	}
	 //Task 5
	public static boolean isConsecutive(int[] arr, int gap) {
		int count = 0;
		//Loops through every element in arr
		while (count < arr.length) {
			//Loops through every element in arr
			for (int i = 0; i < arr.length; ++i) {
				//Compares two different values from arrReturns
				if (arr[count] == arr[i] && count != i) {
					//Returns false if there are any duplicate numbers
					return false;
				}
			}
			count += 1;
		}		
		int temp;
		int smallestNum = arr[0];
		//Loops through every element in arr
		for (int i = 0; i < arr.length; ++i) {
			//Finds the smallest number in arr
			if (arr[i] < smallestNum) {
				smallestNum = arr[i];
				temp = i;
			}
		}
		count = 0;
		int currNum = smallestNum;
		//Loops through arr.length times
		while (count < arr.length) {
			int minVal = arr[0];
			//Loops through every element of arr
			for (int i = 0; i < arr.length; ++i) {
				//Finds a new minimum value
				//Sets it to minVal if it is least 1 greater than the previous one
				if (arr[i] < minVal && arr[i] >= currNum + 1) {
					minVal = arr[i];
				}
			}
			//Checks if currNum + gap is greater than the minimum value
			if (currNum + gap >= minVal) {
				//Returns false if the minVal didnt change (assuming it is not the final run)
				if (currNum == minVal && count < arr.length - 1) {
					return false;
				}
				//Resets minVal to be the new currNum
				else {
					currNum = minVal;
				}
			}
			else {
				return false;
			}
			count += 1;
		}
		return true;
	}
	//Task 6
	public static int smallest(int[] arr, int k) { 
		int smallestNum;
		int count = 0;
		int temp = 0;
		int index;
		//Runs until the kth element is the smallest in the array
		while (count < k - 1) {
			temp = 0;
			smallestNum = arr[0];
			int[] finArray = new int[arr.length - 1];
			//Finds smallest number in arr and indexes it
			for (int i = 0; i < arr.length; ++i) {
				//The smallest number is replaced if another number is smaller
				if (arr[i] < smallestNum) {
					smallestNum = arr[i];
					temp = i;
				}
			}
			index = 0;
			//Adds every number to finArray except for smallestNum in arr
			for (int j = 0; j < arr.length; ++j) {
				//The branch is not executed if the index is temp (smallestNum's index)
				if (j != temp) {
					finArray[index] = arr[j];
					index += 1;
				}
			}
			//Sets arr to the newly created array
			arr = finArray;
			count += 1;
		}
		//Finds the new smallest value in the arr
		smallestNum = arr[0];
		for (int i = 0; i < arr.length; ++i) {
			//The smallest number is replaced if another number is smaller
			if (arr[i] < smallestNum) {
				smallestNum = arr[i];
			}
		}
		//Returns the smallest value in the final array
		return smallestNum;
	}
	//Task 7
	public static void partition(int[] arr) {
		//Loops through every element in arr
		for (int i = 0; i < arr.length; ++i) {
			//If the element is an odd digit, the branch executes
			if (arr[i] % 2 == 1 || arr[i] % 2 == -1) {
				int j = i + 1;
				//Loops through until an even number has been found and indexed
				while (j < arr.length && (arr[j] % 2 == 1 || arr[j] % 2 == -1)) {
					++j;
				}
				if (j < arr.length) {
					//The even number is swapped with the odd number
					for (int x = j; x > i; x--) {
						//A temporary placeholder is used to save the number being swapped
						int temp = arr[x];
						arr[x] = arr[x - 1];
						arr[x - 1] = temp;
					}
				}
			}
		}
		//No return value - in place modification
	}
}