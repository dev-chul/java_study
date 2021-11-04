package com.code.sample4.travel;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("fst");
		list.add("sec");
		list.add("trd");
		
		String a = list.remove(0);
		System.out.println(a);

		System.out.println("=====");
		
		for (String string : list) {
			System.out.println(string);
		}
		
		boolean[] visited = new boolean[3];
		System.out.println(visited[1]);
	}
}
