package com.code.sample7;

public class Sample {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		String[] operations = {"I 16","D 1"};
//		String[] operations = {"I 7","I 5","I -5","D -1"};
//		String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
		String[] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
		
		int[] answer = solution.solution(operations);
		for (int i : answer) {
			System.out.print(i + " ");
		}
	}

}
