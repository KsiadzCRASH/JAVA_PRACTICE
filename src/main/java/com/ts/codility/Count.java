package com.ts.codility;

public class Count {


	/**
	 * You are given an integern. Count the total of 1+2+...+n.
	 * **/
	static class Solution {

		//0
		public static int solution_0(int N) {
			return (N * (N + 1)) / 2;
		}
		//1
		public static int solution_1(int N) {

			int accu = 0;
			for (int i = 0; i <= N; i++) {
				accu += i;
			}

			return accu;
		}

		//2
		public static int solution_2(int N) {
			return recu(N);
		}

		public static int recu(int val){

			if(val == 0){
				return 0;
			}
			return val + recu(val - 1);
		}

		//3
		public static int solution_3(int N) {
			return accuRecu(N, 0);
		}

		public static int accuRecu(int val, int accu){
			if(val == 0){
				return accu;
			}
			return accuRecu(val - 1, accu + val);
		}

		//4
		public static int solution_4(int fInput) {
			Accu accu = new Accu();
			realAccuRecu(fInput, accu);
			return accu.val;
		}

		public static void realAccuRecu(int val, Accu accu){
			if(val == 0){
				return;
			}
			accu.val +=val;
			realAccuRecu(val - 1, accu);
		}

		static class Accu{
			int val;
		}
		//6
		public static int solution_5(int N){

			int accu = 0;
			for (int i = 0; i <= N; i++) {
				for (int j = 0; j < i; j++) {
					accu += 1;
				}
			}
			return accu;
		}
	}
}
