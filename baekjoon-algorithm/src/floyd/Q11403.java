package floyd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11403 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] dist = new int[N][N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int w = Integer.parseInt(st.nextToken());
				if(w == 0) {
						dist[i][j] = 100000001;
				}
				else
					dist[i][j] = w;
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int p=0;p<N;p++) {
				for(int q=0;q<N;q++) {
					dist[p][q] = Math.min(dist[p][q], dist[p][i] + dist[i][q]);
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(dist[i][j] == 100000001)
					System.out.print(0 + " ");
				else
					System.out.print(1 + " ");
			}
			System.out.println();
		}
	}

}
