package com.ts.codility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TapeEquilibriumV2Test {

	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{new int[]{1, 2, 3, 4, 5}, 3},
				{new int[]{3, 1, 2, 4, 3}, 1},
				{new int[]{3, 1}, 2},
				{new int[]{3, 1, 2}, 0},
				{new int[]{-3, 1, 2}, 4}
		});
	}

	@Parameterized.Parameter(0)
	public int[] array;
	@Parameterized.Parameter(1)
	public int expectedResult;

	@Test
	public void test_0() {
		assertThat(TapeEquilibriumV2.Solution.solution_0(array)).isEqualTo(expectedResult);
	}


	@Test
	public void test_1() {
		assertThat(TapeEquilibriumV2.Solution.solution_1(array)).isEqualTo(expectedResult);
	}

}