package com.ts.codility;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OddNumberTest {

	@Test
	void shouldPass() {

		//given
		OddNumber.Solution solution = new OddNumber.Solution();

		//when
		Assertions.assertThat(solution.solution(new int[]{9, 3, 9, 3, 9, 7, 9})).isEqualTo(7);
		Assertions.assertThat(solution.solution(new int[]{9, 9, 9})).isEqualTo(9);
		Assertions.assertThat(solution.solution(new int[]{9})).isEqualTo(9);
		Assertions.assertThat(solution.solution(new int[]{1, 2, 3, 4, 5, 4, 3, 2, 1})).isEqualTo(5);
		Assertions.assertThat(solution.solution(new int[]{1, 2, 3, 4, 5, 5, 4, 3, 2})).isEqualTo(1);
	}
}