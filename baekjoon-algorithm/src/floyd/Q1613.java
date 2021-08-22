package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1613 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		final int MAX = 10000001;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[n+1][n+1];
		
		for(int i=1;i<dist.length;i++) {
			for(int j=1;j<dist[i].length;j++) {
				dist[i][j] = MAX;
			}
		}
		
		for(int i=0;i<k;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			dist[v1][v2] = 1;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int p=1;p<n+1;p++) {
				for(int q=1;q<n+1;q++) {
					dist[p][q] = Math.min(dist[p][q], dist[p][i]+dist[i][q]);
				}
			}
		}
		
		int s = Integer.parseInt(br.readLine());
		for(int i=0;i<s;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			if(dist[v1][v2] != MAX) {
				System.out.println(-1);
			} else if(dist[v2][v1] != MAX) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}
}
