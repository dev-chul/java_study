package com.code.sample6;

public class Sample {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words = {"cog", "log", "lot", "dog", "dot", "hot"};
		int answer = solution.solution("hit", "cog", words);
		System.out.println(answer);
	}

}
