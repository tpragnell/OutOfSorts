import java.util.Random;
import java.util.Arrays;

public class CyeresesSortsTester {

	private int[][] testCases, sortedTestCases;

	CyeresesSortsTester() {
		testCases = generateTestCases();

		//I am using the ArrayList sort function here just for testing
		//and also so you don't steal my code
		sortedTestCases = TestCasesCopyMachine(testCases);
		for (int[] arr : sortedTestCases) {
			Arrays.sort(arr);
		}
	}

	public static int[][] TestCasesCopyMachine(int[][] data) {
		int[][] newCases = new int[data.length][1000];
		for (int row = 0; row < data.length; row++) {
//			System.out.println(Arrays.toString(data[row]));
			for (int col = 0; col < data[row].length; col++) {
				newCases[row][col] = data[row][col];
			}
		}
		return newCases;
	}

	//This is a lonely unused function llama :(
	public static boolean isSorted(int[] data) {
		for (int i = 1; i < data.length; i++) {
			if (data[i-1] > data[i]) {
				return false;
			}
		}
		return true;
	}

	public static int[] generateRandomArray() {
		Random rand = new Random();

		int[] data = new int[rand.nextInt(101)];
		for (int i = 0; i < data.length; i++) {
			data[i] = rand.nextInt(2000) - 1000;
		}
		return data;

	}

	public static int[][] generateTestCases() {
		int[][] a = new int[100][];
		int[] arr;
		for (int i = 0; i < 100; i++) {
			arr = generateRandomArray();
			a[i] = new int[arr.length];
			a[i] = arr;
		}
		return a;
	}

	public boolean bubbleSortTester() {
		int[][] data = TestCasesCopyMachine(testCases);
		boolean success = true;
		System.out.println("\nboolean isBubbleSortGud;\n...");
		for (int i = 0; i < data.length; i++) {
			Sorts.bubbleSort(data[i]);
			if (! Arrays.equals(data[i], sortedTestCases[i])) {
				success = false;
				System.out.println("Test Case " + i + " Unsuccessful:");
				for (int j : data[i]) {
					System.out.println(j);
				}
				System.out.println("\n");
			}
		}
		if (success) {
			System.out.println("isBubbleSortGud = true;\n");
		} else {
			System.out.println("isBubbleSortGud = false;\n");
		}
		return success;
	}

	public boolean selectionSortTester() {
		int[][] data = TestCasesCopyMachine(testCases);
		boolean success = true;
		System.out.println("\nboolean isSelectionSortGud;\n...");
		for (int i = 0; i < data.length; i++) {
			Sorts.selectionSort(data[i]);
			if (! Arrays.equals(data[i], sortedTestCases[i])) {
				success = false;
				System.out.println("Test Case " + i + " Unsuccessful:");
				for (int j : data[i]) {
					System.out.println(j);
				}
				System.out.println("\n");
			}
		}
		if (success) {
			System.out.println("isSelectionSortGud = true;\n");
		} else {
			System.out.println("isSelectionSortGud = false;\n");
		}
		return success;
	}

	public boolean insertionSortTester() {
		int[][] data = TestCasesCopyMachine(testCases);
		boolean success = true;
		System.out.println("\nboolean isInsertionSortGud;\n...");
		for (int i = 0; i < data.length; i++) {
			Sorts.insertionSort(data[i]);
			if (! Arrays.equals(data[i], sortedTestCases[i])) {
				success = false;
				System.out.println("Test Case " + i + " Unsuccessful:");
				System.out.println(Arrays.toString(data[i]));
				System.out.println(Arrays.toString(sortedTestCases[i]));
				System.out.println("\n");
			}
		}
		if (success) {
			System.out.println("isInsertionSortGud = true;\n");
		} else {
			System.out.println("isInsertionSortGud = false;\n");
		}
		return success;
	}

	public boolean daUltimateTester() {
		if (! bubbleSortTester()) {
			return false;
		}
		if (! selectionSortTester()) {
			return false;
		}
		if (! insertionSortTester()) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) {

		CyeresesSortsTester isYouEpicSorterLlamaTester = new CyeresesSortsTester();

		System.out.println("\n// I will determine if you is an Epic Sorter Llama...\n");

		boolean isYouEpicSorterLlama = isYouEpicSorterLlamaTester.daUltimateTester();

		System.out.println("\n// My ultimate consensus...\n");
		if (isYouEpicSorterLlama) {
			System.out.println("boolean isYouEpicSorterLlama = true;");
		} else {
			System.out.println("boolean isYouEpicSorterLlama = false;");
		}

	}
}
