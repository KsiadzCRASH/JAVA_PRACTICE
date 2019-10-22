package com.ts.codility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TapeEquilibriumTest {

	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{new int[]{1, 2, 3, 4, 5}, 1, 13},
				{new int[]{1, 2, 3, 4, 5}, 2, 9},
				{new int[]{1, 2, 3, 4, 5}, 3, 3},
				{new int[]{1, 2, 3, 4, 5}, 4, 5},
				{new int[]{1, 2, 3, 4, -5}, 3, 7},
				{new int[]{1, 2}, 1, 1},
				{new int[]{-1, -2}, 1, 1},
				{new int[]{-1, 2}, 1, 3}

		});
	}

	@Parameterized.Parameter(0)
	public int[] array;
	@Parameterized.Parameter(1)
	public int p;
	@Parameterized.Parameter(2)
	public int expectedResult;

	@Test
	public void test_0() {
		assertThat(TapeEquilibrium.Solution.solution_0(array, p)).isEqualTo(expectedResult);
	}

	@Test
	public void test_1() {
		assertThat(TapeEquilibrium.Solution.solution_1(array, p)).isEqualTo(expectedResult);
	}

}