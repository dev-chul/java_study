package com.code.sample5;

public class Sample {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
		int answer = solution.solution(jobs);
		System.out.println("answer : " + answer);
	}

}
