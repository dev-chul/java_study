package com.code.sample7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
	Queue<Integer> q = new LinkedList<>();
	Queue<Integer> p_q = null;
	
    public int[] solution(String[] operations) {
    	for (String operation : operations) {
			String[] o = operation.split(" ");
			
			if( "I".equals(o[0]) ) {
				insert(Integer.valueOf(o[1]));
			} else if( "D".equals(o[0]) ) {
				delete(Integer.valueOf(o[1]));
			}
		}
    	
    	
    	if ( this.q.size() > 0 ) {
    		int[] result = q.stream().sorted(Collections.reverseOrder()).mapToInt(i->i).toArray();
    		int[] answer = {result[0], result[result.length-1]};
    		return answer;
    	} else {
    		int[] answer = {0, 0};
    		return answer;
    	}
    }
    
    public void insert(int value) {
    	this.q.add(value);
    }
    
    public void delete(int value) {
    	if( 1 == value ) {
    		this.p_q = new PriorityQueue<>((o1, o2) -> o2 - o1);
    	} else if( -1 == value ) {
    		this.p_q = new PriorityQueue<>((o1, o2) -> o1 - o2);
    	}
    	
    	while (!q.isEmpty()) {
			p_q.offer(q.poll());
			
		}
    	
    	p_q.poll();
    	
    	this.q = this.p_q;
    	
    }
    
}