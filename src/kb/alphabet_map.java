package kb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class alphabet_map {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		input = input.trim();
		if( "".equals(input) || null == input ) {
			System.out.println("문자열 입력이 필요합니다.");
			return;
		}
		
		String[] arr = input.split("");
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for( int i=0; i<arr.length; i++ ) {
			String alpha = arr[i];
			alpha = alpha.toLowerCase();
			char[] c = alpha.toCharArray();
			
			for( int j=97; j<=122; j++ ) {
				if( j == ((int) c[0]) ) {
					if( map.containsKey(j) ) {
						int value = map.get(j);
						value++;
						map.put(j, value);
					} else {
						map.put(j, 1);
					}
				}
			}
		}
		
		for( int i=97; i<=122; i++ ) {
			System.out.println( Character.toString( (char)i) + " : " + ( (map.get(i) == null)? 0 : map.get(i) ) );
		}
		
	}

}
