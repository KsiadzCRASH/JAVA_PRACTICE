package com.ts.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;


class BinaryGapTest {

	@Test
	void testBinaryGapSol1() {

		//given
		BinaryGap.Solution solution = new BinaryGap.Solution();
		int val1 = 51712;
		int val2 = 9;
		int val3 = 15;
		//when
		int resVal1 = solution.solutionStr(val1);
		int resVal2 = solution.solutionStr(val2);
		int resVal3 = solution.solutionStr(val3);
		//then
		assertThat(resVal1).isEqualTo(0);
		assertThat(resVal2).isEqualTo(2);
		assertThat(resVal3).isEqualTo(0);
	}

	@Test
	void testBinaryGapSol2() {

		//given
		BinaryGap.Solution solution = new BinaryGap.Solution();
		int val1 = 51712;
		int val2 = 9;
		int val3 = 15;
		//when
		int resVal1 = solution.solutionBin(val1);
		int resVal2 = solution.solutionBin(val2);
		int resVal3 = solution.solutionBin(val3);
		//then
		assertThat(resVal1).isEqualTo(2);
		assertThat(resVal2).isEqualTo(2);
		assertThat(resVal3).isEqualTo(0);
	}

}