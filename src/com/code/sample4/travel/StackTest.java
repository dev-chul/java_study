package com.code.sample4.travel;

import java.util.Stack;

public class StackTest {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<>();
		st.push(1);
		st.push(2);
		st.push(3);
		
		System.out.println("=====");
		for (Integer integer : st) {
			System.out.println(integer);
		}
		System.out.println("=====");
		System.out.println(st.size());
		System.out.println(st.get(2));
		System.out.println(st.size());
		System.out.println(st.pop());
		System.out.println(st.size());
	}
	
}
