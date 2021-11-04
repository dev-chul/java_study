package com.code.sample5;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution2 {
    public int solution(int[][] jobs) {
    	int answer = 0;
		int len = jobs.length;
		int time = 0;
		int idx = 0;
		Queue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
		
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
		
		while (idx < len || !q.isEmpty()) {
			/*
			 * 1. "jobs[idx][0] <= time" 현재 진행 중인 작업 안에 것들을 우선 적으로 집어 넣음
			 * 만약 그렇지 않으면 바로 뒤로 정렬되는 우선순위가 없이 전체에서 비교하게 된다.
			 */
			while (idx < len && jobs[idx][0] <= time) {
				q.offer(jobs[idx++]);
			}
			
			// 2. 만약 1에서 아무것도 넣지 못했으면 그냥 다음으로
			if (q.isEmpty())
				time = jobs[idx][0];
			else {
				/*
				 * 3. 2의 조건을 충족하기 위해 항상 큐는 poll해서 비워줘야 한다.
				 * 그래야 만약 1에서 아무것도 넣지 못했으면, 2에 걸려서 다음 index값의 job을 집어넣는다.
				 */
				int[] job = q.poll();
				answer += time - job[0] + job[1];
				time += job[1];
			}
		}
		
		return answer / len;
    }
}