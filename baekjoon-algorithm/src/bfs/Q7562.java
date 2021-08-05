package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q7562 {
	
	static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int t = Integer.parseInt(br.readLine());
		for(int z=0;z<t;z++) {
			int I = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int targetY = Integer.parseInt(st.nextToken());
			int targetX = Integer.parseInt(st.nextToken());
			
			System.out.println(bfs(startX, startY, targetX, targetY, I));
		}
	}

	private static int bfs(int startX, int startY, int targetX, int targetY, int I) {
		if(startX==targetX && startY==targetY)
			return 0;
		
		boolean[][] visited = new boolean[I][I];
		
		Queue<int[]> queue = new LinkedList<>();
		
		queue.offer(new int[] {startY, startX});
		visited[startY][startX] = true;
		
		int depth=1;
		
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			for(int j=0;j<queueSize;j++) {
				int[] currentPosition = queue.poll();
				
				int currentY = currentPosition[0];
				int currentX = currentPosition[1];
				
				for(int i=0;i<dx.length;i++) {
					int nextY = currentY + dy[i];
					int nextX = currentX + dx[i];
					
					if(nextX == targetX && nextY==targetY)
						return depth;
					
					if(nextX>=0 && nextY>=0 && nextX<I && nextY<I) {
						if(!visited[nextY][nextX]) {
							visited[nextY][nextX] = true;
							queue.offer(new int[] {nextY, nextX});
						}
					}
				}
			}
			depth++;
		}
		
		return -1;
	}

}
