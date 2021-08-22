package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1956 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		final int MAX = 987654321;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[][] dist = new int[V+1][V+1];
		for(int i=0;i<dist.length;i++) {
			for(int j=0;j<dist[i].length;j++) {
				if(i!=j)
					dist[i][j] = MAX;
			}
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			dist[a][b] = c;
		}
		
		for(int p=1;p<V+1;p++) {
			for(int i=1;i<V+1;i++) {
				for(int j=1;j<V+1;j++) {
					if(i==j)
						continue;
					
					dist[i][j] = Math.min(dist[i][j], dist[i][p] + dist[p][j]);
				}
			}
		}
		
		int result = MAX;
		for(int i=1;i<V+1;i++) {
			for(int j=1;j<V+1;j++) {
				if(i==j) {
					continue;
				}
				
				if(dist[i][j] != MAX && dist[j][i] != MAX)
					result = Math.min(result, dist[i][j] + dist[j][i]);
			}
		}
		
		System.out.println(result==MAX ? -1 : result);
	}

}
