package com.ts.codility;

public class FrogJmp {

	/**
	 * A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.
	 * <p>
	 * Count the minimal number of jumps that the small frog must perform to reach its target.
	 * <p>
	 * Write a function:
	 * <p>
	 * class Solution { public int solution(int X, int Y, int D); }
	 * <p>
	 * that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.
	 * <p>
	 * For example, given:
	 * X = 10
	 * Y = 85
	 * D = 30
	 * <p>
	 * the function should return 3, because the frog will be positioned as follows:
	 * <p>
	 * after the first jump, at position 10 + 30 = 40
	 * after the second jump, at position 10 + 30 + 30 = 70
	 * after the third jump, at position 10 + 30 + 30 + 30 = 100
	 * <p>
	 * Write an efficient algorithm for the following assumptions:
	 * <p>
	 * X, Y and D are integers within the range [1..1,000,000,000];
	 * X ≤ Y.
	 */

	static class Solution {

		public static int solution_0(int x, int y, int d) {

			if (x == y) {
				return 0;
			}
			if (y - x < d) {
				return 1;
			}

			int delta = y - x;
			if (delta % d > 0) {
				return delta / d + 1;
			} else {
				return delta / d;
			}
		}

		public static int solution_1(int x, int y, int d) {

			if (x == y) {
				return 0;
			}
			if (y - x < d) {
				return 1;
			}

			int accu = x + d;
			int counter = 1;
			while (accu < y) {
				accu += d;
				counter++;
			}
			return counter;
		}

	}

}
