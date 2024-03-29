package kb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bracket_stack {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		String[] arr = input.split("");
		
		String result = checkBracket(arr);
		System.out.println(result);
		
	}
	
	public static String checkBracket(String[] arr) {
		String open = "({[";
		Stack<String> st = new Stack<>();
		for( int i=0; i<arr.length; i++ ) {
			if( -1 < open.indexOf(arr[i]) ) {
				st.push(arr[i]);
			} else {
				int idx = st.size() - 1;
				if( idx < 0 ) {
					return "False";
				}
				
				String s = st.peek();
				if( ")".equals(arr[i]) && "(".equals(s) ) {
					st.pop();
				} else if( "}".equals(arr[i]) && "{".equals(s) ) {
					st.pop();
				} else if( "]".equals(arr[i]) && "[".equals(s) ) {
					st.pop();
				} else {
					break;
				}
				
			}
		}
		
		return (st.size() > 0)? "False" : "True";
	}
	
}
