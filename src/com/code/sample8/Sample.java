package com.code.sample8;

public class Sample {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		
		int[] answer = solution.solution(genres, plays);
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}

}