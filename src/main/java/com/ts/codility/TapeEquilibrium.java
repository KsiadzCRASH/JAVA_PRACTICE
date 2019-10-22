package com.ts.codility;

public class TapeEquilibrium {

	/**
	 * A non-empty array A consisting of N integers is given. Array A represents numbers on a tape.
	 * <p>
	 * Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].
	 * <p>
	 * The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|
	 * <p>
	 * In other words, it is the absolute difference between the sum of the first part and the sum of the second part.
	 * <p>
	 * For example, consider array A such that:
	 * A[0] = 3
	 * A[1] = 1
	 * A[2] = 2
	 * A[3] = 4
	 * A[4] = 3
	 * <p>
	 * We can split this tape in four places:
	 * <p>
	 * P = 1, difference = |3 − 10| = 7
	 * P = 2, difference = |4 − 9| = 5
	 * P = 3, difference = |6 − 7| = 1
	 * P = 4, difference = |10 − 3| = 7
	 * <p>
	 * Write a function:
	 * <p>
	 * class Solution { public int solution(int[] A); }
	 * <p>
	 * that, given a non-empty array A of N integers, returns the minimal difference that can be achieved.
	 * <p>
	 * For example, given:
	 * A[0] = 3
	 * A[1] = 1
	 * A[2] = 2
	 * A[3] = 4
	 * A[4] = 3
	 * <p>
	 * the function should return 1, as explained above.
	 * <p>
	 * Write an efficient algorithm for the following assumptions:
	 * <p>
	 * N is an integer within the range [2..100,000];
	 * each element of array A is an integer within the range [−1,000..1,000].
	 */

	public static class Solution {

		public static int solution_0(int[] array, int p) {
			int left = 0;
			for (int i = 0; i < p; i++) {
				left += array[i];
			}

			int right = 0;
			for (int i = p; i < array.length; i++) {
				right += array[i];
			}

			return Math.abs(left - right);
		}

		public static int solution_1(int[] array, int p) {
			int left = 0;
			int sign = 1;
			for (int i = 0; i < array.length; i++) {
				if (i >= p){
					sign = -1;
				}
				left += sign*array[i];
			}

			return Math.abs(left);
		}
	}
}
