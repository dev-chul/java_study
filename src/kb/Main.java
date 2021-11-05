package kb;

import java.io.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int inputNumber = Integer.valueOf(input);
		
		for(int i = 1; i <= inputNumber; i++){
			if(inputNumber % i == 0){
		    	System.out.print(i + " ");
		    }
		}
	}
}