package com.code.sample8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
    	Map<String, Meta> map = new HashMap<>();
    	
    	for (int i=0; i<genres.length; i++) {
    		if ( ! map.containsKey(genres[i]) ) {
    			Meta meta = new Meta();
    			meta.total += plays[i];
    			meta.album.put(i, plays[i]);
    			
    			map.put(genres[i], meta);
    		} else {
    			Meta meta = map.get(genres[i]);
    			meta.total += plays[i];
    			meta.album.put(i, plays[i]);
    			
    			map.put(genres[i], meta);
    		}
    	}
    	
    	List<Map.Entry<String, Meta>> entries = new LinkedList<>(map.entrySet());
    	Collections.sort(entries, (o1, o2) -> o2.getValue().total - o1.getValue().total);
    	
    	LinkedHashMap<String, Meta> result = new LinkedHashMap<>();
    	for (Entry<String, Meta> entry : entries) {
			result.put(entry.getKey(), entry.getValue());
		}
    	
    	Set<String> keys = result.keySet();
    	List<Integer> list = new ArrayList<>();
    	for (String key : keys) {
    		Meta meta = result.get(key);
    		meta.doSort();
    		System.out.println(key + " : " + meta.total + " : " + meta.rank);
    		
    		list.add(meta.rank.get(0).getKey());
    		if( meta.rank.size() > 1 ) {
    			list.add(meta.rank.get(1).getKey());
    		}
    		
		}
    	
        return list.stream().mapToInt(i->i).toArray();
    }
    
    class Meta {
    	int total;
    	Map<Integer, Integer> album = new HashMap<>();
    	List<Map.Entry<Integer, Integer>> rank = null;
    	
    	void doSort( ) {
    		List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(this.album.entrySet());
        	Collections.sort(entries, (o1, o2) -> o2.getValue() - o1.getValue());
        	this.rank = entries;
    	}
    }
}