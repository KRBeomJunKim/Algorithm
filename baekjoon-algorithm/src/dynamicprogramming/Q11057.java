package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[10][N+1];
		for(int i=0;i<10;i++) {
			dp[i][1] = 1;
		}
		for(int i=2;i<N+1;i++) {
			dp[0][i] = 1;
		}
		
		for(int i=2;i<N+1;i++) {
			for(int j=1;j<10;j++) {
				int jResult=0;
				for(int k=0;k<=j;k++) {
					jResult += dp[k][i-1];
				}
				dp[j][i] = jResult%10007;
			}
		}
		
		int result=0;
		for(int i=0;i<10;i++) {
			result += dp[i][N];
		}
		System.out.println(result%10007);
	}

}
