package kb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class alphabet {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		input = input.trim();
		
		String[] arr = input.split("");
		
		String output = "";
		
		for( int i=0; i<arr.length; i++ ) {
			String alpha = arr[i];
			alpha = alpha.toLowerCase();
			char[] c = alpha.toCharArray();
			
			for( int j=97; j<=122; j++ ) {
				if( j == ((int) c[0]) ) {
					output = output + "," + Integer.toString(j);
				}
			}
		}
		
		String[] cArr = output.split(",");
		System.out.println("=====");
		for (String s : cArr) {
			System.out.println(s);
		}
		System.out.println("=====");
		
		for( int i=97; i<=122; i++ ) {
			int count = 0;
			for( int j=0; j<cArr.length; j++ ) {
				if( cArr[j].equals(Integer.toString(i)) ) {
					count++;
				}
			}
			System.out.println(Character.toString((char)i) + " : " + count);
		}
		
	}

}
