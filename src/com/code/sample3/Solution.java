package com.code.sample3;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String[] solution(String[][] tickets) {
        List<String> answer = new ArrayList<>();
        String departure = "ICN";
    	String arrival = "";
    	int index = -1;
    	
    	answer.add(departure);
    	
    	for (int j=0; j<tickets.length; j++) {

    		for (int i=0; i<tickets.length; i++) {
    			if( tickets[i][0].equals(departure) ) {
    				if( "".equals(arrival) ) {
    					arrival = tickets[i][1];
    					index = i;
    				} else {
    					if(!"USED".equals(tickets[i][0]) && (arrival.codePointAt(0))>(tickets[i][1].codePointAt(0))) {
    						arrival = tickets[i][1];
    						index = i;
    					}
    				}
    			}
    			
    		}
    		
    		answer.add(arrival);
    		departure = arrival;
    		arrival = "";
    		if( -1 != index ) {
    			tickets[index][0] = "N/A";
    			tickets[index][1] = "N/A";
    			index = -1;
    		}
    		
		}
    	
        return answer.toArray(String[]::new);
    }

}