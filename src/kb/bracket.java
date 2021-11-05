package kb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bracket {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String input = br.readLine();
		
		String input = "{(})}){)}{(}{)})(";
		
		String[] arr = input.split("");
		
		boolean result = checkBracket(arr);
		System.out.println(result);
		
	}
	
	public static boolean checkBracket(String[] arr) {
		String open = "({[";
		List<String> list = new ArrayList<>();
		for( int i=0; i<arr.length; i++ ) {
			if( -1 < open.indexOf(arr[i]) ) {
				list.add(arr[i]);
			} else {
				int idx = list.size() - 1;
				if( idx < 0 ) {
					return false;
				}
				
				String s = list.get(idx);
				if ( ")".equals(arr[i]) && "(".equals(s) ) {
					list.remove(idx);
				} else if ( "}".equals(arr[i]) && "{".equals(s) ) {
					list.remove(idx);
				} else if ( "]".equals(arr[i]) && "[".equals(s) ) {
					list.remove(idx);
				} else {
					break;
				}
				
			}
		}
		
		return (list.size() > 0)? false : true;
	}

}
