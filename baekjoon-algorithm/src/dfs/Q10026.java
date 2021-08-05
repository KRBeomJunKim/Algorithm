package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10026 {
	
	static final int R = 0;
	static final int G = 1;
	static final int B = 2;
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int globalResult;
	
	static int[] dy = {-1, 1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<map.length;i++) {
			String[] inputLine = br.readLine().split("");
			for(int j=0;j<inputLine.length;j++) {
				if(inputLine[j].equals("R")) {
					map[i][j] = R;
				} else if(inputLine[j].equals("G")) {
					map[i][j] = G;
				} else if(inputLine[j].equals("B")) {
					map[i][j] = B;
				}
			}
		}
		
		globalResult=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					globalResult++;
				}
			}
		}
		System.out.printf("%d ", globalResult);
		
		for(int i=0;i<N;i++)
			Arrays.fill(visited[i], false);
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==R)
					map[i][j]=G;
			}
		}
		
		globalResult=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j]) {
					dfs(i, j);
					globalResult++;
				}
			}
		}
		System.out.printf("%d\n", globalResult);
	}

	private static void dfs(int y, int x) {
		visited[y][x] = true;
		
		int currentValue = map[y][x];
		
		for(int i=0;i<dy.length;i++) {
			int nextY = y + dy[i];
			int nextX = x + dx[i];
				
			if(nextX>=0 && nextY>=0 && nextX<N && nextY<N) {
				if(!visited[nextY][nextX]) {
					int nextValue = map[nextY][nextX];
					if(currentValue == nextValue) {
						dfs(nextY, nextX);
					}
				}
			}
		}
	}

}
