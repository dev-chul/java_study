package kb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ÀÌÂ÷¿ø {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][n];

		for( int i = 0; i < n; i++ ) {
			st = new StringTokenizer(br.readLine());
			for( int j = 0; j < n; j++ ) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());

		int result = 0;

		for( int a = x1; a <= x2; a++ ) {
			for( int b = y1; b <= y2; b++ ) {
				result += map[a][b];
			}
		}

		System.out.println(result);

	}
}