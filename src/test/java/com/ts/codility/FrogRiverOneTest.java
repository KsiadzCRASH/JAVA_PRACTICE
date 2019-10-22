package com.ts.codility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class FrogRiverOneTest {

	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{new int[]{1, 2, 3, 4, 5}, 5, 4},
				{new int[]{5, 2, 4, 1, 3}, 5, 4},
				{new int[]{1, 2, 1, 2, 3}, 3, 4},
				{new int[]{3, 2, 3, 2, 1}, 3, 4},
				{new int[]{1, 1, 2, 3, 5}, 3, 3},
				{new int[]{1, 2, 3, 4, 5}, 3, 2},
				{new int[]{1, 2, 3, 4, 5}, 5, 4},
				{new int[]{1, 2, 3, 4, 5}, 2, 1},
				{new int[]{1, 4, 2, 3, 5}, 3, 3},
				{new int[]{1, 2}, 1, 0},
				{new int[]{1, 2}, 2, 1},
				{new int[]{1}, 1, 0},
				{new int[]{1, 2, 1, 4, 5}, 5, -1},
				{new int[]{1, 2, 2, 2, 1}, 3, -1},
				{new int[]{7, 8, 9, 10, 11}, 3, -1},
				{new int[]{1, 2, 3, 4, 5}, 7, -1},
				{new int[]{1, 2}, 3, -1},
				{new int[]{4, 5}, 1, -1},
				{new int[]{2}, 1, -1},

		});
	}

	@Parameterized.Parameter(0)
	public int[] array;
	@Parameterized.Parameter(1)
	public int x;
	@Parameterized.Parameter(2)
	public int expectedResult;

	@Test
	public void test_0() {
		assertThat(FrogRiverOne.Solution.solution_0(array, x)).isEqualTo(expectedResult);
	}
}