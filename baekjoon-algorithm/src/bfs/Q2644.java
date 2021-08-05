package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2644 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] map = new ArrayList[n+1];
		for(int i=1;i<map.length;i++) {
			map[i] = new ArrayList<>();
		}
		
		st = new StringTokenizer(br.readLine());
		int inputV1 = Integer.parseInt(st.nextToken());
		int inputV2 = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		
		for(int i=0;i<m;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			map[v1].add(v2);
			map[v2].add(v1);
		}
		
		System.out.println(bfs(map, inputV1, inputV2));
	}

	private static int bfs(List<Integer>[] map, int inputV1, int inputV2) {
		boolean[] visited = new boolean[map.length];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(inputV1);
		int depth=0;
		while(!queue.isEmpty()) {
			int queueSize = queue.size();
			for(int i=0;i<queueSize;i++) {
				int current = queue.poll();
				
				if(!visited[current]) {
					if(current == inputV2) {
						return depth;
					}
					
					visited[current] = true;
					
					for(int z:map[current]) {
						queue.add(z);
					}
				}
			}
			depth++;
		}
		
		return -1;
	}
	
	
}
