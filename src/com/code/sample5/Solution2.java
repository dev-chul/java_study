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
			 * 1. "jobs[idx][0] <= time" ���� ���� ���� �۾� �ȿ� �͵��� �켱 ������ ���� ����
			 * ���� �׷��� ������ �ٷ� �ڷ� ���ĵǴ� �켱������ ���� ��ü���� ���ϰ� �ȴ�.
			 */
			while (idx < len && jobs[idx][0] <= time) {
				q.offer(jobs[idx++]);
			}
			
			// 2. ���� 1���� �ƹ��͵� ���� �������� �׳� ��������
			if (q.isEmpty())
				time = jobs[idx][0];
			else {
				/*
				 * 3. 2�� ������ �����ϱ� ���� �׻� ť�� poll�ؼ� ������ �Ѵ�.
				 * �׷��� ���� 1���� �ƹ��͵� ���� ��������, 2�� �ɷ��� ���� index���� job�� ����ִ´�.
				 */
				int[] job = q.poll();
				answer += time - job[0] + job[1];
				time += job[1];
			}
		}
		
		return answer / len;
    }
}