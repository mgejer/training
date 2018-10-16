package arrays;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by martingejer on 16/10/18.
 */
public class MinimumSwaps {

	// Complete the minimumSwaps function below.
	static int minimumSwaps(int[] arr) {
		int minimumSwaps = 0;
		for (int i = 0; i < arr.length; i++) {
			while (desiredValuePosition(i) != valueAtPosition(arr, i)) {
				swapPosition(arr, indexFromValue(valueAtPosition(arr, i)), i);
				minimumSwaps++;
			}
		}

		return minimumSwaps;
	}

	private static void swapPosition(int[] arr, int indexA, int indexB) {
		int auxiliar = arr[indexA];
		arr[indexA] = arr[indexB];
		arr[indexB] = auxiliar;
	}

	private static int valueAtPosition(int[] arr, int i) {
		return arr[i];
	}

	private static int indexFromValue(int someValue) {
		return someValue -1;
	}

	private static int desiredValuePosition(int someIndex) {
		return someIndex + 1;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int res = minimumSwaps(arr);

		bufferedWriter.write(String.valueOf(res));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}

}
