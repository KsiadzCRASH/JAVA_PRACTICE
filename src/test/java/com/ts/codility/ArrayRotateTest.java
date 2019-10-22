package com.ts.codility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ArrayRotateTest {

	@Test
	void shouldPass() {

		//given
		ArrayRotate.Solution solution = new ArrayRotate.Solution();

		//when
		assertThat(solution.solution(new int[]{9}, 0)).isEqualTo(new int[]{9});
		assertThat(solution.solution(new int[]{9}, 1)).isEqualTo(new int[]{9});
		assertThat(solution.solution(new int[]{9}, 2)).isEqualTo(new int[]{9});
		assertThat(solution.solution(new int[]{9, 3}, 0)).isEqualTo(new int[]{9, 3});
		assertThat(solution.solution(new int[]{9, 3}, 1)).isEqualTo(new int[]{3, 9});
		assertThat(solution.solution(new int[]{9, 3}, 2)).isEqualTo(new int[]{9, 3});
		assertThat(solution.solution(new int[]{1, 2, 3}, 1)).isEqualTo(new int[]{3, 1, 2});
		assertThat(solution.solution(new int[]{1, 2, 3}, 2)).isEqualTo(new int[]{2, 3, 1});
		assertThat(solution.solution(new int[]{1, 2, 3}, 3)).isEqualTo(new int[]{1, 2, 3});
		assertThat(solution.solution(new int[]{1, 2, 3}, 4)).isEqualTo(new int[]{3, 1, 2});
		assertThat(solution.solution(new int[]{1, 2, 3}, 5)).isEqualTo(new int[]{2, 3, 1});
		assertThat(solution.solution(new int[]{1, 2, 3}, 6)).isEqualTo(new int[]{1, 2, 3});
		assertThat(solution.solution(new int[]{1, 2, 3}, 7)).isEqualTo(new int[]{3, 1, 2});
		assertThat(solution.solution(new int[]{1, 2, 3, 4}, 1)).isEqualTo(new int[]{4, 1, 2, 3});
		assertThat(solution.solution(new int[]{1, 2, 3, 4}, 2)).isEqualTo(new int[]{3, 4, 1, 2});
		assertThat(solution.solution(new int[]{1, 2, 3, 4}, 3)).isEqualTo(new int[]{2, 3, 4, 1});
		assertThat(solution.solution(new int[]{1, 2, 3, 4}, 4)).isEqualTo(new int[]{1, 2, 3, 4});
		assertThat(solution.solution(new int[]{1, 2, 3, 4}, 5)).isEqualTo(new int[]{4, 1, 2, 3});
		assertThat(solution.solution(new int[]{1, 2, 3, 4}, 6)).isEqualTo(new int[]{3, 4, 1, 2});
		assertThat(solution.solution(new int[]{1, 2, 3, 4}, 7)).isEqualTo(new int[]{2, 3, 4, 1});
		assertThat(solution.solution(new int[]{1, 2, 3, 4}, 8)).isEqualTo(new int[]{1, 2, 3, 4});
		assertThat(solution.solution(new int[]{1, 2, 3, 4}, 9)).isEqualTo(new int[]{4, 1, 2, 3});
	}
	@Test
	void shouldPassDeb() {

		//given
		ArrayRotate.Solution solution = new ArrayRotate.Solution();
		assertThat(solution.solution(new int[]{1, 2, 3, 4}, 9)).isEqualTo(new int[]{4, 1, 2, 3});
	}


	}