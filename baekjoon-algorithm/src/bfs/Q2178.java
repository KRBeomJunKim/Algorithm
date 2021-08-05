package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2178 {
	
	static int N;
	static int M;
	static boolean[][] map;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new boolean[N][M];
		for(int i=0;i<N;i++) {
			String[] inputs_ = br.readLine().split("");
			for(int j=0;j<M;j++) {
				map[i][j] = inputs_[j].equals("1") ? true : false;
			}
		}
		
		System.out.println(bfs(0, 0));
	}

	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};

	private static int bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<Node>();
		boolean[][] visited = new boolean[N][M];
		
		queue.offer(new Node(startX, startY));
		visited[startY][startX] = true;
		int depth=1;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			for(int i=0;i<queueSize;i++) {
				Node currentNode = queue.poll();
				int currentX = currentNode.x;
				int currentY = currentNode.y;
				
				if(currentX == M-1 && currentY == N-1)
					return depth;
				
				for(int p=0;p<dx.length;p++) {
					int nextX = currentX + dx[p];
					int nextY = currentY + dy[p];
					
					if(nextX>=0 && nextY>=0 && nextX<M && nextY<N) {
						if(!visited[nextY][nextX] && map[nextY][nextX]) {
							visited[nextY][nextX] = true;
							queue.offer(new Node(nextX, nextY));
						}
					}
				}
			}
			depth++;
		}
		
		return -1;
	}
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	

}
