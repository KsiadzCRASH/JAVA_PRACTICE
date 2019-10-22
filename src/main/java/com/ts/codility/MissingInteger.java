package com.ts.codility;

import java.util.Arrays;

public class MissingInteger {

	/**
	 * This is a demo task.
	 * <p>
	 * Write a function:
	 * <p>
	 * class Solution { public int solution(int[] A); }
	 * <p>
	 * that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.
	 * <p>
	 * For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
	 * <p>
	 * Given A = [1, 2, 3], the function should return 4.
	 * <p>
	 * Given A = [−1, −3], the function should return 1.
	 * <p>
	 * Write an efficient algorithm for the following assumptions:
	 * <p>
	 * N is an integer within the range [1..100,000];
	 * each element of array A is an integer within the range [−1,000,000..1,000,000].
	 **/

	public static class Solution {

		public static int solution_0(int[] array) {

			if (array.length == 1) {
				if (array[0] != 1) {
					return 1;
				} else {
					return 2;
				}
			}

			Arrays.sort(array);
			int lastValue = array[0];
			if (lastValue > 0 && lastValue != 1) {
				return 1;
			}

			boolean foundOne = false;
			for (int i = 1; i < array.length; i++) {
				if (lastValue > 0) {
					if (!foundOne) {
						if (lastValue != 1) {
							return 1;
						}
						foundOne = true;
					}
					if (array[i] >= 0) {
						if (array[i] - lastValue > 1) {
							return lastValue + 1;
						}
					}
				}
				lastValue = array[i];
			}

			if (lastValue > 0) {
				if (!foundOne && lastValue != 1) {
					return 1;
				}
				return lastValue + 1;
			} else {
				return 1;
			}
		}

		// not optimal
		public static int solution_1(int[] array) {

			Arrays.sort(array);
			int result = array[array.length - 1] + 1;
			int lastValue = result;

			for (int i = array.length - 1; i >= 0; i--) {

				if (lastValue - 1 != array[i]) {
					result = array[i] + 1;
				}

				if (array[i] <= 1) {
					if (array[i] != 1) {
						return 1;
					} else {
						return result;
					}
				}

				lastValue = array[i];
			}

			return 1;
		}

		public static int solution_2(int[] array){




			return 1;
		}
	}
}
