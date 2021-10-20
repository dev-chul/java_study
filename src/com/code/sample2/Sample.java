package com.code.sample2;

public class Sample {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] answers = {1,2,3,4,5};
		int[] answers = {1,3,2,4,2};
		int[] result = solution.solution(answers);
		for (int i : result) {
			System.out.println(i);
		}
	}

}
