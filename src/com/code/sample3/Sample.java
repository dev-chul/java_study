package com.code.sample3;

public class Sample {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
//		int[] answers = {1,2,3,4,5};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] answer = solution.solution(tickets);
		for (String a : answer) {
			System.out.println(a);
		}
	}

}
