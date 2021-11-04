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

        // default가 false로 생성된다.
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
                    	// stack의 get은 마지막 stack을 보여주는 peek와 달리 직접 index 값을 입력하여 해당 값을 보여주고 stack을 소비하지 않는다.
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
    	// 아래 루프가 tickets.length 길이 만큼 고정이 되어 있어 마지막 티켓을 소비하고 이후 스텝에서 결과를 반환
        if (len == tickets.length) {
        	System.out.println("===== RETURN");
        	// foreach 역시 pop이 아니기에 소비하지 않는다.
            Stack<String> res = new Stack<>();
            for (String s : st) {
                res.push(s);
            }

            result.add(res);
            return;
        }

        // Stack의 peek는 stack을 소비하지는 않은 상태에서 마지막 값을 보여준다.
        String arrive = st.peek();
        
        // 제일 큰 루프가 결국 전달받은 ticket의 길이 만큰 대루프를 만들어 낸다.
        for (int i = 0; i < tickets.length; i++) {
            String[] tic = tickets[i];

            System.out.print(len + " : " + visited[i] + "/" + i + " : " + arrive + " : " + tic[0] + " : " + tic[1] + " : ");
            
            if (!visited[i] && arrive.equals(tic[0])) {
            	System.out.println("O");
                st.push(tic[1]);
                // 현재 사용 한 티켓의 index를 마킹
                visited[i] = true;

                // 결국 재귀를 호출하여 전체를 목적지와 비교하여 탐색한 것인데, 이를 재귀로 깔끔하게 만든 것이다.
                dfs(visited, st, len + 1);

                // 다음 루프를 위해 현재 다시 release 
                visited[i] = false;
                st.pop();
            } else { 
            	System.out.println("X");
            }
        }
    }
}