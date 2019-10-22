package com.ts.codility;

import java.util.Arrays;

public class PermMissingElement {

	/**
	 *

	 An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

	 Your goal is to find that missing element.

	 Write a function:

	 class Solution { public int solution(int[] A); }

	 that, given an array A, returns the value of the missing element.

	 For example, given array A such that:
	 A[0] = 2
	 A[1] = 3
	 A[2] = 1
	 A[3] = 5

	 the function should return 4, as it is the missing element.

	 Write an efficient algorithm for the following assumptions:

	 N is an integer within the range [0..100,000];
	 the elements of A are all distinct;
	 each element of array A is an integer within the range [1..(N + 1)].

	 */

	public static class Solution {

		public static int solution_0(int[] array) {

			if(array.length == 0){
				return 1;
			}

			long n = array.length + 1;
			long expectedSum = (n * (n + 1)) / 2;
			long sum = 0;

			for (int i = 0; i < array.length; i++) {
				sum += array[i];
			}

			return (int)(expectedSum - sum);
		}

		public static int solution_1(int[] array) {

			if(array.length == 0){
				return 1;
			}

			Arrays.sort(array);

			int prev = 0;
			for (int i = 0; i < array.length; i++) {
				if(array[i] - prev > 1){
					return prev + 1;
				}
				prev = array[i];
			}
			return prev + 1;
		}
	}
}
