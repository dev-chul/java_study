package com.code.sample7;

import java.util.PriorityQueue;
import java.util.Queue;
class Solution2 {
    public int[] solution(String[] operations) {
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        Queue<Integer> queue = new PriorityQueue<>((k,l)->Integer.compare(l, k));

        for(String a : operations) {
            String command = a.split(" ")[0];
            String num = a.split(" ")[1];

            if("I".equals(command)) {
                int i = Integer.parseInt(num);
                queue.add(i);
                continue;
            }

            if("D".equals(command)) {
                if(queue.size() == 0) {
                    continue;
                }

                if("1".equals(num)) {
                    queue.poll();
                }else {
                    Queue<Integer> upQueue = new PriorityQueue<>((k,l)->Integer.compare(k, l));
                    upQueue.addAll(queue);
                    upQueue.poll();
                    queue.clear();
                    queue.addAll(upQueue);
                }
            }
        }

        if(queue.size() == 0) {
            return new int[] {0, 0};
        }

        while(queue.size() > 0) {
            int q = queue.poll();
            maxNum = Math.max(maxNum, q);
            minNum = Math.min(minNum, q);
        }
        System.out.println(maxNum+":"+minNum);  
        return new int[] {maxNum, minNum};
    }   
}