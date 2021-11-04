package com.code.sample6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
	List<Stack<String>> ways = new ArrayList<>();
	boolean[] used;
	
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        
        Stack<String> stack = new Stack<>();
        stack.push(begin);
        
        used = new boolean[words.length];
    
		findWay(stack, words, target);
		
		for (Stack<String> way : ways) {
			if(answer == 0) {
				answer = way.size()-1;
			} else {
				answer = Math.min(answer, way.size()-1);
			}
		}
        
        return answer;
    }
    
    public void findWay(Stack<String> stack, String[] words, String target) {
    	String word1 = stack.peek();
    	if( word1.equals(target) ) {
    		Stack<String> res = new Stack<>();
            for (String s : stack) {
                res.push(s);
            }

            ways.add(res);
    		
    		return;
    	}
    	
    	
    	for (int i=0; i<words.length; i++) {
			if( !used[i] && compareWord(word1, words[i]) ) {
				
				stack.push(words[i]);
				used[i] = true;
				findWay(stack, words, target);
				
				used[i] = false;
				stack.pop();
			} else {
			}
			
		}
    }
    
    public static boolean compareWord(String word1, String word2) {
		if (word1.length() != word2.length()) {
            return false;
        }

        int differentCnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                differentCnt++;
            }
        }
        return differentCnt == 1;
    }
    
//    public boolean compareWord(String word1, String word2) {
//    	int cnt = 1;
//    	if( !word1.equals(word2) ) {
//    		String[] arr1 = word1.split("");
//    		String[] arr2 = word2.split("");
//    		for (String c2 : arr2) {
//    			 for (String c1 : arr1) {
//    				 if(c1.equals(c2)) {
//    					 cnt++;
//    					 if( cnt > word1.length()-1 ) {
//    						 return true;
//    					 }
//    				 }
//				}
//			}
//    	}
//    	
//    	return false;
//    }
}