package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[10][N+1];
		
		for(int i=1;i<10;i++)
			dp[i][1] = 1;
		
		for(int i=2;i<N+1;i++) {
			for(int j=0;j<10;j++) {
				if(j==0)
					dp[0][i] = dp[1][i-1];
				else if(j==9)
					dp[9][i] = dp[8][i-1];
				else {
					dp[j][i] = (dp[j-1][i-1] + dp[j+1][i-1]) % 1000000000;
				}
			}
		}
		
		long result=0;
		for(int i=0;i<10;i++) {
			result += dp[i][N];
		}
		System.out.println(result% 1000000000);

	}

}
