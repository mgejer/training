package arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by martingejer on 16/10/18.
 */
public class MinimumSwapsTest {

	@Test
	public void minimumSwaps() throws Exception {
		int[] q = {2, 5, 1, 3, 4};
		assertEquals(MinimumSwaps.minimumSwaps(q), 4);
	}

	@Test
	public void minimumSwaps_noElems_return0() throws Exception {
		int[] q = {};
		assertEquals(MinimumSwaps.minimumSwaps(q), 0);
	}

	@Test
	public void minimumSwaps_oneElem_return0() throws Exception {
		int[] q = {1};
		assertEquals(MinimumSwaps.minimumSwaps(q), 0);
	}

	@Test
	public void minimumSwaps_twoElemz_return0() throws Exception {
		int[] q = {1, 2};
		assertEquals(MinimumSwaps.minimumSwaps(q), 0);
	}

	@Test
	public void minimumSwaps_twoSwappedElems_return1() throws Exception {
		int[] q = {2, 1};
		assertEquals(MinimumSwaps.minimumSwaps(q), 1);
	}

	@Test
	public void minimumSwaps_example_returns3() {
		int[] q = {1, 3, 5, 2, 4, 6, 7};
		assertEquals(MinimumSwaps.minimumSwaps(q), 3);
	}


}