package uebung6;

import java.util.Random;

public class QuickSort {

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

		//Prints the unsorted list
		System.out.println("Before:");
		printArray(numbers);

		//the array gets sorted
		quicksort(numbers);

		//Prints the sorted list
		System.out.println("\nAfter:");
		printArray(numbers);
	}

	private static void quicksort(int[] array) {
		quicksort(array, 0, array.length - 1);
	}

	private static void quicksort(int[] array, int lowIndex, int highIndex) {

		if (lowIndex >= highIndex) {
			return;
		}

		//some random index for the pivot between the lowIndex and the highIndex
		int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
		int pivot = array[pivotIndex];
		swap(array, pivotIndex, highIndex);

		int leftPointer = partition(array, lowIndex, highIndex, pivot);

		quicksort(array, lowIndex, leftPointer - 1);
		quicksort(array, leftPointer + 1, highIndex);

	}

	private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
		//the left pointer is the first element of the index
		int leftPointer = lowIndex;
		
		//the last number is the pivot
		int rightPointer = highIndex - 1;

		while (leftPointer < rightPointer) {

			// Walk from the left until we a number greater than the pivot is found, or hit the
			// right pointer.
			while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
				leftPointer++;
			}

			// Walk from the right until a number less than the pivot is found, or hit the
			// left pointer.
			while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
				rightPointer--;
			}

			swap(array, leftPointer, rightPointer);
		}

		if (array[leftPointer] > array[highIndex]) {
			swap(array, leftPointer, highIndex);
		} else {
			leftPointer = highIndex;
		}

		return leftPointer;
	}

	//swaps the pivot with the higher number
	private static void swap(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

	private static void printArray(int[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}

}
