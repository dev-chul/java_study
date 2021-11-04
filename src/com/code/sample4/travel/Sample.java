package com.code.sample4.travel;

public class Sample {
	public static void main(String[] args) {
		Solution s = new Solution();
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		String[] answer = s.solution(tickets);
		System.out.println("=====");
		for (String a : answer) {
			System.out.println(a);
		}
	}
}
