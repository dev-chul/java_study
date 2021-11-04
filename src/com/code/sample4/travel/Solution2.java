package com.code.sample4.travel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Solution2 {
    List<Stack<String>> result;
    String[][] tickets;

    public String[] solution(String[][] tickets) {
        result = new ArrayList<>();
        this.tickets = tickets;

        // default�� false�� �����ȴ�.
        boolean[] visited = new boolean[tickets.length];
        Stack<String> st = new Stack<>();
        st.push("ICN");

        dfs(visited, st, 0);
        
        System.out.println("***** ***** ***** ***** ***** *****");
        for (Stack<String> s : result) {
        	System.out.println("-----");
			for (String string : s) {
				System.out.println(string);
			}
			System.out.println("-----");
		}
        System.out.println("***** ***** ***** ***** ***** *****");
        
        if (result.size() > 1) {
            Collections.sort(result, new Comparator<Stack<String>>() {
                @Override
                public int compare(Stack<String> o1, Stack<String> o2) {
                    for (int i = 0; i < o1.size(); i++) {
                    	// stack�� get�� ������ stack�� �����ִ� peek�� �޸� ���� index ���� �Է��Ͽ� �ش� ���� �����ְ� stack�� �Һ����� �ʴ´�.
                        String s1 = o1.get(i);
                        String s2 = o2.get(i);

                        if (!s1.equals(s2)) {
                            return s1.compareTo(s2);
                        }
                    }

                    return 0;
                }
            });
        }
        
        Stack<String> res = result.get(0);
        String[] answer = new String[res.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public void dfs(boolean[] visited, Stack<String> st, int len) {
    	// �Ʒ� ������ tickets.length ���� ��ŭ ������ �Ǿ� �־� ������ Ƽ���� �Һ��ϰ� ���� ���ܿ��� ����� ��ȯ
        if (len == tickets.length) {
        	System.out.println("===== RETURN");
        	// foreach ���� pop�� �ƴϱ⿡ �Һ����� �ʴ´�.
            Stack<String> res = new Stack<>();
            for (String s : st) {
                res.push(s);
            }

            result.add(res);
            return;
        }

        // Stack�� peek�� stack�� �Һ������� ���� ���¿��� ������ ���� �����ش�.
        String arrive = st.peek();
        
        // ���� ū ������ �ᱹ ���޹��� ticket�� ���� ��ū ������� ����� ����.
        for (int i = 0; i < tickets.length; i++) {
            String[] tic = tickets[i];

            System.out.print(len + " : " + visited[i] + "/" + i + " : " + arrive + " : " + tic[0] + " : " + tic[1] + " : ");
            
            if (!visited[i] && arrive.equals(tic[0])) {
            	System.out.println("O");
                st.push(tic[1]);
                // ���� ��� �� Ƽ���� index�� ��ŷ
                visited[i] = true;

                // �ᱹ ��͸� ȣ���Ͽ� ��ü�� �������� ���Ͽ� Ž���� ���ε�, �̸� ��ͷ� ����ϰ� ���� ���̴�.
                dfs(visited, st, len + 1);

                // ���� ������ ���� ���� �ٽ� release 
                visited[i] = false;
                st.pop();
            } else { 
            	System.out.println("X");
            }
        }
    }
}