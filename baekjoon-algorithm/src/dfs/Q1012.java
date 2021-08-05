package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q1012 {
	
	static int M;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int z=0;z<T;z++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			boolean[][] map = new boolean[N][M];
			boolean[][] visited = new boolean[N][M];
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());	
				map[Y][X] = true;
			}
			
			System.out.println(dfs(map, visited));
		}
	}

	private static int dfs(boolean[][] map, boolean[][] visited) {
		int result = 0;
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(!visited[i][j] && map[i][j]) {
					dfs_search(map, visited, i, j);
					result++;
				}
			}
		}
		
		return result;
	}
	
	static final int[] top = {-1, 0};
	static final int[] down = {1, 0};
	static final int[] right = {0, 1};
	static final int[] left = {0, -1};
	static final int[][] directions = {top, down, right, left};

	private static void dfs_search(boolean[][] map, boolean[][] visited, int y, int x) {
		
		Deque<int[]> deque = new ArrayDeque<>();
		deque.push(new int[]{y, x});
		
		while(!deque.isEmpty()) {
			int[] xy = deque.pop();
			int currentY = xy[0];
			int currentX = xy[1];
			visited[currentY][currentX] = true;
			
			for(int[] direction:directions) {
				int nextX = currentX+direction[1];
				int nextY = currentY+direction[0];
				
				if(nextX >= 0 && nextY >=0 && nextX < M && nextY < N) {
					if(!visited[nextY][nextX] && map[nextY][nextX]) {
						deque.push(new int[] {nextY, nextX});
					}
				}
			}
		}
	}
	
	
	
	

}
