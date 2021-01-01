import java.util.Arrays;
import java.util.Random;

public class SelectionTester{
	private static boolean DEBUG = false;

	public static void main(String[] args) {
		boolean failure = false;
		int[][] sorts = {
			{64, 25, 12, 22, 11},
			{2, 3, 4, 5, 1},
			{6, 1, 2, 3, 4, 5},
			{1, 2, 3, 4, 5},
			{},
			{0},
			{5, 4, 3, 2, 1},
		};

		int[][][] expectedPrints = {
			{
				{64, 25, 12, 22, 11},
				{11, 25, 12, 22, 64},
				{11, 12, 25, 22, 64},
				{11, 12, 22, 25, 64},
				{11, 12, 22, 25, 64}
			},
			{
				{2, 3, 4, 5, 1},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
			},
			{
				{6, 1, 2, 3, 4, 5},
				{1, 6, 2, 3, 4, 5},
				{1, 2, 6, 3, 4, 5},
				{1, 2, 3, 6, 4, 5},
				{1, 2, 3, 4, 6, 5},
				{1, 2, 3, 4, 5, 6}
			},
			{
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5},
			},
			{
				{}
			},
			{
				{0}
			},
			{
				{5, 4, 3, 2, 1},
				{1, 4, 3, 2, 5},
				{1, 2, 4, 3, 5},
				{1, 2, 3, 4, 5},
				{1, 2, 3, 4, 5}
			},
		};

		for (int test = 0; test < sorts.length; test++) {
			System.out.println("selectionPrint");
			Sorts.selectionSort(sorts[test]);

			System.out.println("expectedPrints");
			for (int line = 0; line < expectedPrints[test].length; line++) {
				System.out.println(Arrays.toString(expectedPrints[test][line]));
			}

		}
		System.out.println("expectedPrints EVALUATE YOURSELF");

		failure = seededRandomSort(1000, 1000);
		failure = seededRandomSort(10, 1) || failure;
		failure = seededRandomSort(10, 0) || failure;
		failure = seededRandomSort(10, 2) || failure;

		TesterMethods.overall(failure);
	}

	public static boolean seededRandomSort(int tests, int arrLen) {
		TesterMethods.tester("seededRandomSort");
		boolean fail = false;

		for (int test = 0; test < tests; test++) {
			Random rng = new Random(test);
			int[] sort = new int[arrLen];
			int[] expected = new int[arrLen];

			for (int i = 0; i < arrLen; i++) {
				int val = rng.nextInt(arrLen) - arrLen / 2;
				sort[i] = val;
				expected[i] = val;
			}

			if (DEBUG) {
				System.out.println(Arrays.toString(sort));
				System.out.println(Arrays.toString(expected));
			}

			Sorts.selectionSort(sort);
			Arrays.sort(expected);

			if (DEBUG) {
				System.out.println(Arrays.toString(sort));
				System.out.println(Arrays.toString(expected));
			}

			if (Arrays.equals(sort, expected)) {
				if (DEBUG) {
					TesterMethods.passMessage(test);
				}
			} else {
				fail = true;
				TesterMethods.errorMessage(test, Arrays.toString(expected), Arrays.toString(sort));
			}
		}

		TesterMethods.methodMessage("seededRandomSort", fail);
		return fail;
	}
}
