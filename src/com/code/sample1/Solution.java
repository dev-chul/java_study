package com.code.sample1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
	
	public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        
        for (int[] command : commands) {
			int i = command[0] - 1, j = command[1], k = command[2];
			int[] arr = Arrays.copyOfRange(array, i, j);
			Arrays.sort(arr);
			answer.add(arr[k-1]);
		}
        
        return answer.stream().mapToInt(i->i).toArray();
    }
	
}
