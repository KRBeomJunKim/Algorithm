package divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2447 {
	
	static char[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i=0;i<N;i++)
			Arrays.fill(map[i], ' ');
		
		star(0, 0, N);
		
		for(int i=0;i<N;i++) {
			System.out.println(map[i]);
		}
		
		br.close();
	}
	
	static void star(int r, int c, int count) {
		if(count == 1) {
			map[r][c] = '*';
			return;
		}
		
		int chunkCount = count/3;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(i==1 && j==1)
					continue;
				
				star(r+chunkCount*i, c+chunkCount*j, chunkCount);
			}
		}
	}

}
