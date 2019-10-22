package com.ts.codility;

import java.util.Arrays;

public class PermCheck {

	/**
	 * A non-empty array A consisting of N integers is given.
	 * <p>
	 * A permutation is a sequence containing each element from 1 to N once, and only once.
	 * <p>
	 * For example, array A such that:
	 * A[0] = 4
	 * A[1] = 1
	 * A[2] = 3
	 * A[3] = 2
	 * <p>
	 * is a permutation, but array A such that:
	 * A[0] = 4
	 * A[1] = 1
	 * A[2] = 3
	 * <p>
	 * is not a permutation, because value 2 is missing.
	 * <p>
	 * The goal is to check whether array A is a permutation.
	 * <p>
	 * Write a function:
	 * <p>
	 * class Solution { public int solution(int[] A); }
	 * <p>
	 * that, given an array A, returns 1 if array A is a permutation and 0 if it is not.
	 * <p>
	 * For example, given array A such that:
	 * A[0] = 4
	 * A[1] = 1
	 * A[2] = 3
	 * A[3] = 2
	 * <p>
	 * the function should return 1.
	 * <p>
	 * Given array A such that:
	 * A[0] = 4
	 * A[1] = 1
	 * A[2] = 3
	 * <p>
	 * the function should return 0.
	 * <p>
	 * Write an efficient algorithm for the following assumptions:
	 * <p>
	 * N is an integer within the range [1..100,000];
	 * each element of array A is an integer within the range [1..1,000,000,000].
	 */

	static class Solution {

		public static int solution_0(int[] array) {
			Arrays.sort(array);
			int previous = array[0];
			if(previous != 1){
				return 0;
			}
			for (int i = 1; i < array.length; i++) {
				if (array[i] - 1 != previous){
					return 0;
				}
				previous = array[i];
			}
			return 1;
		}
	}
}
