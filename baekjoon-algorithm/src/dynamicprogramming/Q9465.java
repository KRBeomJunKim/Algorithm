package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int z=0;z<T;z++) {
			int n = Integer.parseInt(br.readLine());
			int[][] inputs = new int[2][n];
			
			for(int i=0;i<2;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					inputs[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int[][] table = new int[3][n];
			table[0][0] = inputs[0][0];
			table[1][0] = inputs[1][0];
			for(int i=1;i<n;i++) {
				for(int j=0;j<3;j++) {
					table[0][i] = Math.max(table[1][i-1], table[2][i-1]) + inputs[0][i];
					table[1][i] = Math.max(table[0][i-1], table[2][i-1]) + inputs[1][i];
					table[2][i] = Math.max(table[0][i-1], table[1][i-1]);
				}
			}
			
			System.out.println(Math.max(table[0][n-1], table[1][n-1]));
		}
	}

}
