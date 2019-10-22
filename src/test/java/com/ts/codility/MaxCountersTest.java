package com.ts.codility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class MaxCountersTest {

	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{

				{new int[]{1, 2, 3, 4}, 4, new int[]{1, 1, 1, 1}},
				{new int[]{1, 2, 3, 5}, 4, new int[]{1, 1, 1, 1}},
				{new int[]{1, 1, 5, 1}, 4, new int[]{3, 2, 2, 2}},
				{new int[]{5, 5, 5, 5}, 4, new int[]{0, 0, 0, 0}},
				{new int[]{5, 5, 5, 4}, 4, new int[]{0, 0, 0, 1}},
				{new int[]{5, 5, 1, 5}, 4, new int[]{1, 1, 1, 1}},
				{new int[]{5, 1, 5, 5}, 4, new int[]{1, 1, 1, 1}},
				{new int[]{1, 5, 5, 5}, 4, new int[]{1, 1, 1, 1}},
				{new int[]{1}, 4, new int[]{1, 0, 0, 0}},
				{new int[]{5}, 4, new int[]{0, 0, 0, 0}},
				{new int[]{1}, 1, new int[]{1}},
				{new int[]{2}, 1, new int[]{0}},
		});
	}

	@Parameterized.Parameter(0)
	public int[] array;
	@Parameterized.Parameter(1)
	public int n;
	@Parameterized.Parameter(2)
	public int[] expectedResult;

	@Test
	public void test_0() {
		assertThat(MaxCounters.Solution.solution_0(n, array)).isEqualTo(expectedResult);
	}

	@Test
	public void test_1() {
		assertThat(MaxCounters.Solution.solution_1(n, array)).isEqualTo(expectedResult);
	}
}