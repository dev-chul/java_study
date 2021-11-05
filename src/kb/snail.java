package kb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class snail {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		final String REGEX = "[0-9]+";
		if( !input.matches(REGEX) ) {
			System.out.println("숫자만 입력해주세요.");
			return;
		}
		
		int inputNumber = Integer.valueOf(input);
		
        int[][] snail = new int[inputNumber][inputNumber];
        
        int fillNumber = inputNumber;
        int k = 1;
        int right = -1;
        int bottom = 0;
        int top = 1;
        
        for( int i=inputNumber; i>0; i-- ) {
            for(int j=0; j<fillNumber; j++) {
                right += top;
                snail[bottom][right] = k;
                k++;
            }
            fillNumber--;
            
            for( int j=0; j<fillNumber; j++ ) {
                bottom += top;
                snail[bottom][right] = k;
                k++;
            }
            top = top * (-1);
            
        }
        
        // 출력
        for( int i=0; i<snail.length; i++ ) {
            for( int j=0; j<snail[i].length; j++ ) {
        	    System.out.printf("%3d ", snail[i][j]);
            }
            System.out.println();
        }
    }
}