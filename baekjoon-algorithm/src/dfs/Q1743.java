package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q1743 {
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] map;
	static boolean[][] visited;
	static int N;
	static int M;
	static int dfsResult=0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		visited = new boolean[N][M];
		for(int i=0;i<K;i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] = true;
		}
		
		int result=0;
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				if(!visited[i][j] && map[i][j]) {
					dfsResult = 0;
					dfs2(i, j);
					result = Math.max(result, dfsResult);
				}
			}
		}
		
		System.out.println(result);
	}

	private static int dfs2(int i, int j) {
		Deque<int[]> deque = new ArrayDeque<>();
		
		int result=0;
		deque.push(new int[] {i, j});
		while(!deque.isEmpty()) {
			int[] current = deque.pop();
			int currentY = current[0];
			int currentX = current[1];
			visited[currentY][currentX] = true;
			result++;
			
			for(int p=0;p<dx.length;p++) {
				int nextY = currentY + dy[p];
				int nextX = currentX + dx[p];
				
				if(nextY < N && nextX < M && nextY>=0 && nextX>=0) {
					if(!visited[nextY][nextX] && map[nextY][nextX]) {
						deque.add(new int[] {nextY, nextX});
					}
				}
			}
		}
		
		return result;
	}
	
	private static void dfs(int i, int j) {
		
		visited[i][j] = true;
		dfsResult++;
			
		for(int p=0;p<dx.length;p++) {
			int nextY = i + dy[p];
			int nextX = j + dx[p];
				
			if(nextY < N && nextX < M && nextY>=0 && nextX>=0) {
				if(!visited[nextY][nextX] && map[nextY][nextX]) {
					dfs(nextY, nextX);
				}
			}
		}
	}

}
