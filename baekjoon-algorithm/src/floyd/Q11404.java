package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] weights = new int[n+1][n+1];
		for(int i=0;i<weights.length;i++) {
			for(int j=0;j<weights[i].length;j++) {
				if(i==j) {
					weights[i][j] = 0;
				} else {
					weights[i][j] = 10000001;
				}
			}
		}
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(weights[a][b] == 10000001) {
				weights[a][b] = c;
			} else {
				weights[a][b] = Math.min(weights[a][b], c);
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int p=1;p<=n;p++) {
					weights[j][p] = Math.min(weights[j][p], weights[j][i]+weights[i][p]);
				}
			}
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(weights[i][j] == 10000001) {
					System.out.print(0 + " ");
				} else {
					System.out.print(weights[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

}
