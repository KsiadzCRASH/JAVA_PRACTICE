package com.ts.codility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class PermMissingElementTest {
	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{new int[]{1, 2, 3, 5}, 4},
				{new int[]{2, 3, 1, 5}, 4},
				{new int[]{1, 2, 5, 3}, 4},
				{new int[]{1, 5, 3, 2}, 4},
				{new int[]{5, 2, 1, 3}, 4},
				{new int[]{2, 3}, 1},
				{new int[]{1}, 2},
				{new int[]{2}, 1},
				{new int[]{1, 2}, 3},
				{new int[]{1, 3}, 2},
				{new int[]{3, 2}, 1},
				{new int[]{3, 1}, 2},
				{new int[]{}, 1},
		});
	}

	@Parameterized.Parameter(0)
	public int[] array;
	@Parameterized.Parameter(1)
	public int expectedResult;

	@Test
	public void test_1() {
		assertThat(PermMissingElement.Solution.solution_1(array)).isEqualTo(expectedResult);
	}
}