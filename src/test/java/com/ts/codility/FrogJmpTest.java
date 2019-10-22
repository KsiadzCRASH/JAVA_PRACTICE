package com.ts.codility;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class FrogJmpTest {

	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{
				{1, 3, 1, 2},
				{20, 100, 30, 3},
				{1, 9, 2, 4},
				{5, 6, 1, 1},
				{5, 6, 100, 1},
				{5, 6, 2, 1},
				{5, 5, 1, 0},
				{5, 5, 100, 0},
		});
	}

	@Parameterized.Parameter(0)
	public int x;

	@Parameterized.Parameter(1)
	public int y;

	@Parameterized.Parameter(2)
	public int d;

	@Parameterized.Parameter(3)
	public int expectedResult;

	@Test
	public void test_0() {
		assertThat(FrogJmp.Solution.solution_0(x, y, d)).isEqualTo(expectedResult);
	}

	@Test
	public void test_1() {
		assertThat(FrogJmp.Solution.solution_1(x, y, d)).isEqualTo(expectedResult);
	}
}