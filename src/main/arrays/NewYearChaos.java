package arrays;

import java.util.Scanner;

/**
 * Created by martingejer on 08/10/18.
 */
public class NewYearChaos {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {

		try {
			System.out.println(amountOfPeopleBribed(q));
		} catch (TooManyBribedPeople e) {
			System.out.println("Too chaotic");
		}
	}

	static int amountOfPeopleBribed(int[] q) {
		int minimumBribes = 0;
		for (int personIndex = 0; personIndex < q.length; personIndex++ ) {
			int peopledBribed = amountOfPeopleBribedBy(q, personIndex);

			if (peopledBribed <= 2) {
				minimumBribes += peopledBribed;
			} else {
				throw new TooManyBribedPeople();
			}
		}
		return minimumBribes;
	}

	static int amountOfPeopleBribedBy(int[] q, int briberIndex) {
		int amountOfPeopleBribed = 0;

		for (int personIndex = briberIndex + 1 ; personIndex < q.length; personIndex++ ) {
			if (q[personIndex] < q[briberIndex]) {
				amountOfPeopleBribed++;
			}
		}

		return amountOfPeopleBribed;
	}

	static class TooManyBribedPeople extends RuntimeException {

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
