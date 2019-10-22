package com.ts.codility;

import java.util.Arrays;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CountTest {

	@Parameterized.Parameters
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{{0, 0}, {1, 1}, {2, 3},
				{3, 6}, {4, 10}});
	}

	@Parameterized.Parameter(0)
	public int N;

	@Parameterized.Parameter(1)
	public int expectedResult;

	@Test
	public void test_0() {
		Assertions.assertThat(Count.Solution.solution_0(N)).isEqualTo(expectedResult);
	}

	@Test
	public void test_1() {
		Assertions.assertThat(Count.Solution.solution_1(N)).isEqualTo(expectedResult);
	}

	@Test
	public void test_2() {

		Assertions.assertThat(Count.Solution.solution_2(N)).isEqualTo(expectedResult);
	}

	@Test
	public void test_3() {
		Assertions.assertThat(Count.Solution.solution_3(N)).isEqualTo(expectedResult);
	}

	@Test
	public void test_4() {
		Assertions.assertThat(Count.Solution.solution_4(N)).isEqualTo(expectedResult);
	}

	@Test
	public void test_5() {
		Assertions.assertThat(Count.Solution.solution_5(N)).isEqualTo(expectedResult);
	}
}