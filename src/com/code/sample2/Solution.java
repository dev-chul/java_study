package com.code.sample2;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public int[] solution(int[] answers) {
		int[] p1 = { 1, 2, 3, 4, 5 };
		int[] p2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] p3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int[][] students = {p1, p2, p3};
		
		int[] result = new int[3];
		
		for (int i=0; i<answers.length; i++) {
			for (int j=0; j<students.length; j++) {
				if (answers[i] == students[j][i%(students[j].length)]) { result[j]++; }
			}
			
		}
		
		int max = Math.max(result[0], Math.max(result[1], result[2]));
		
		List<Integer> ranker = new ArrayList<>();
		for (int i=0; i<result.length; i++) {
			if( max == result[i] ) {
				ranker.add(i+1);
			}
			
		}
		
		return ranker.stream().mapToInt(i->i).toArray();
	}

}