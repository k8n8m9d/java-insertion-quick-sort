package uebung6;

public class InsertionSort {

	public static void main(String[] args) {
		int[] numbers = new int[15];
		numbers[0] = 19;
		numbers[1] = 46;
		numbers[2] = 3;
		numbers[3] = 10;
		numbers[4] = 27;
		numbers[5] = 62;
		numbers[6] = 100;
		numbers[7] = 71;
		numbers[8] = 88;
		numbers[9] = 13;
		numbers[10] = 45;
		numbers[11] = 72;
		numbers[12] = 7;
		numbers[13] = 81;
		numbers[14] = 56;

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = numbers[i];
		}

		//prints the unsorted list
		System.out.println("Before:");
		printArray(numbers);

		insertionSort(numbers);

		//prints the sorted list
		System.out.println("\nAfter:");
		printArray(numbers);
	}

	private static void insertionSort(int[] inputArray) {
		//the first element is already sorted
		for (int i = 1; i < inputArray.length; i++) {
			
			//the currant value of the "pointer" is copied in an other variable
			int currentValue = inputArray[i];

			//the value left from our current position
			int j = i - 1;
			
			//walk back till there is an bigger value or we are on the left side of the array
			while (j >= 0 && inputArray[j] > currentValue) {
				//move the value of j on position to the right
				inputArray[j + 1] = inputArray[j];
				j--;
			}
			inputArray[j + 1] = currentValue;
		}
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

}
