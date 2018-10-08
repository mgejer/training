package arrays;

import java.util.ArrayList;
import java.util.List;
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
		List<Integer> bribeds = new ArrayList();

		for (int personIndex = q.length - 1; personIndex >= 0 ; personIndex-- ) {

			if (advancedTooManyPositions(personIndex, q)) {
				throw new TooManyBribedPeople();
			} else if (advanced2Positions(personIndex, q)) {
				minimumBribes += 2;
			} else if (advanced1Positions(personIndex, q)) {
				minimumBribes++;
			} else if (bribedSomeOne(q[personIndex], bribeds)) {
				minimumBribes++;
			}

			if (wasBribed(personIndex, q)) {
				bribeds.add(q[personIndex]);
			}

		}
		return minimumBribes;
	}

	private static boolean bribedSomeOne(int person, List<Integer> bribeds) {
		return bribeds.stream().anyMatch(bribed -> person > bribed);
	}

	private static boolean advanced1Positions(int personIndex, int[] q) {
		return q[personIndex] == getPositionAsValue(personIndex) + 1;
	}

	private static boolean advanced2Positions(int personIndex, int[] q) {
		return q[personIndex] == getPositionAsValue(personIndex) + 2;
	}

	private static boolean advancedTooManyPositions(int personIndex, int[] q) {
		return q[personIndex] > getPositionAsValue(personIndex) + 2;
	}

	private static boolean wasBribed(int personIndex, int[] q) {
		return q[personIndex] < getPositionAsValue(personIndex);
	}

	private static int getPositionAsValue(int personIndex) {
		return personIndex + 1;
	}


	static class TooManyBribedPeople extends RuntimeException {}

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
