package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5014 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int F = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int U = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		if(S==G) {
			System.out.println(0);
			return;
		}
		
		boolean[] visited = new boolean[F+1];
		visited[0] = true;
		
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(S);
		visited[S] = true;
		
		int depth=0;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			
			for(int i=0;i<queueSize;i++) {
				int current = queue.poll();
				
				if(current == G) {
					System.out.println(depth);
					return;
				}
				
				int nextUp = current + U;
				if(nextUp <= F && !visited[nextUp]) {
					visited[nextUp] = true;
					queue.offer(nextUp);
				}
				
				int nextDown = current - D;
				if(nextDown > 0 && !visited[nextDown]) {
					visited[nextDown] = true;
					queue.offer(nextDown);
				}
			}
			depth++;
		}
		
		System.out.println("use the stairs");
	}

}
