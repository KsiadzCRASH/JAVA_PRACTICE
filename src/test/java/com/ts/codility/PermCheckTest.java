package com.ts.codility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PermCheckTest {

	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{new int[]{1, 2, 3, 4}, 1},
				{new int[]{2, 3, 1, 4}, 1},
				{new int[]{2, 3, 5, 4}, 0},
				{new int[]{2, 3, 5, 4}, 0},
				{new int[]{1, 2, 5, 3}, 0},
				{new int[]{4, 2, 1, 3}, 1},
				{new int[]{1000000000, 99999999, 99999998, 99999997}, 0},
				{new int[]{2, 3}, 0},
				{new int[]{1}, 1},
				{new int[]{2}, 0},
				{new int[]{1, 2}, 1},
				{new int[]{1, 3}, 0},
				{new int[]{3, 1}, 0},
				{new int[]{2, 2}, 0},

		});
	}

	@Parameterized.Parameter(0)
	public int[] array;
	@Parameterized.Parameter(1)
	public int expectedResult;

	@Test
	public void test_0() {
		assertThat(PermCheck.Solution.solution_0(array)).isEqualTo(expectedResult);
	}
}