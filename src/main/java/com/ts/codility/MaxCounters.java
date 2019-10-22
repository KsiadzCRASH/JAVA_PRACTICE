package com.ts.codility;

public class MaxCounters {

	/**
	 * You are given N counters, initially set to 0, and you have two possible operations on them:
	 * <p>
	 * increase(X) − counter X is increased by 1,
	 * max counter − all counters are set to the maximum value of any counter.
	 * <p>
	 * A non-empty array A of M integers is given. This array represents consecutive operations:
	 * <p>
	 * if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
	 * if A[K] = N + 1 then operation K is max counter.
	 * <p>
	 * For example, given integer N = 5 and array A such that:
	 * A[0] = 3
	 * A[1] = 4
	 * A[2] = 4
	 * A[3] = 6
	 * A[4] = 1
	 * A[5] = 4
	 * A[6] = 4
	 * <p>
	 * the values of the counters after each consecutive operation will be:
	 * (0, 0, 1, 0, 0)
	 * (0, 0, 1, 1, 0)
	 * (0, 0, 1, 2, 0)
	 * (2, 2, 2, 2, 2)
	 * (3, 2, 2, 2, 2)
	 * (3, 2, 2, 3, 2)
	 * (3, 2, 2, 4, 2)
	 * <p>
	 * The goal is to calculate the value of every counter after all operations.
	 * <p>
	 * Write a function:
	 * <p>
	 * class Solution { public int[] solution(int N, int[] A); }
	 * <p>
	 * that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.
	 * <p>
	 * Result array should be returned as an array of integers.
	 * <p>
	 * For example, given:
	 * A[0] = 3
	 * A[1] = 4
	 * A[2] = 4
	 * A[3] = 6
	 * A[4] = 1
	 * A[5] = 4
	 * A[6] = 4
	 * <p>
	 * the function should return [3, 2, 2, 4, 2], as explained above.
	 * <p>
	 * Write an efficient algorithm for the following assumptions:
	 * <p>
	 * N and M are integers within the range [1..100,000];
	 * each element of array A is an integer within the range [1..N + 1].
	 */

	static class Solution {

		public static int[] solution_0(int n, int[] array) {

			int[] result = new int[n];
			int maxCounter = Integer.MIN_VALUE;
			int accumulatedMaxCounter = 0;

			for (int i = 0; i < array.length; i++) {

				if (array[i] > n) {
					if (maxCounter > 0) {
						result = new int[n];
						accumulatedMaxCounter += maxCounter;
						maxCounter = 0;
					}
				} else {
					int val = ++result[array[i] - 1];
					if (val > maxCounter) {
						maxCounter = val;
					}
				}
			}

			return addMaxCounter(accumulatedMaxCounter, result);
		}

		public static int[] solution_1(int n, int[] array) {

			int[] result = new int[n];
			int maxCounter = Integer.MIN_VALUE;
			int accumulatedMaxCounter = 0;

			for (int i = 0; i < array.length; i++) {

				if (array[i] > n) {
					if (maxCounter > 0) {
						result = flush(result);
						accumulatedMaxCounter += maxCounter;
						maxCounter = 0;
					}
				} else {
					int val = ++result[array[i] - 1];
					if (val > maxCounter) {
						maxCounter = val;
					}
				}
			}

			return addMaxCounter(accumulatedMaxCounter, result);
		}

		private static int[] flush(int[] result) {
			for (int i = 0; i < result.length; i++) {
				result[i] = 0;
			}
			return result;
		}

		private static int[] addMaxCounter(int lastMaxCounter, int[] result) {
			for (int i = 0; i < result.length; i++) {
				result[i] += lastMaxCounter;
			}

			return result;
		}
	}
}
