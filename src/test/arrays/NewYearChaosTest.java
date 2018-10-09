package arrays;

import org.junit.Assert;
import org.junit.Test;

import static arrays.NewYearChaos.minimumBribes;
import static org.junit.Assert.assertEquals;

/**
 * Created by martingejer on 08/10/18.
 */
public class NewYearChaosTest {

	@Test
	public void amountOfPeopleBribed() {
		int[] q = {2, 1, 5, 3, 4};
		assertEquals(NewYearChaos.amountOfPeopleBribed(q),  3);
	}

	@Test
	public void amountOfPeopleBribed_bribedByAll() {
		int[] q = {3, 4, 5, 2, 1};
		assertEquals(NewYearChaos.amountOfPeopleBribed(q),  7);
	}

	@Test(expected = NewYearChaos.TooManyBribedPeople.class)
	public void amountOfPeopleBribed_TooManyBribed() {
		int[] q = {2, 5, 1, 3, 4};
		NewYearChaos.amountOfPeopleBribed(q);
	}

	@Test
	public void amountOfPeopleBribed_noPeople() {
		int[] q = {};
		assertEquals(NewYearChaos.amountOfPeopleBribed(q),  0);
	}

	@Test
	public void amountOfPeopleBribed_noBribed() {
		int[] q = {1, 2, 3};
		assertEquals(NewYearChaos.amountOfPeopleBribed(q),  0);
	}

	@Test
	public void amountOfPeopleBribed_3_2_1() {
		int[] q = {3, 2, 1};
		assertEquals(NewYearChaos.amountOfPeopleBribed(q),  3);
	}

	@Test(expected = NewYearChaos.TooManyBribedPeople.class)
	public void amountOfPeopleBribed_TooManyBribed2() {
		int[] q = {2, 5, 1, 3, 4};
		NewYearChaos.amountOfPeopleBribed(q);
	}
}
