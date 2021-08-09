package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1916 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		List<Node>[] map = new List[N+1];
		for(int i=1;i<map.length;i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			map[start].add(new Node(end, w)); 
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		int[] weightMap = new int[N+1];
		Arrays.fill(weightMap, Integer.MAX_VALUE);
		weightMap[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> n1.w-n2.w);
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int currentEnd = currentNode.end;
			int currentW = currentNode.w;
			
			if(weightMap[currentEnd] < currentW) {
				continue;
			}
			
			for(Node node:map[currentEnd]) {
				int nextEnd = node.end;
				int nextW = currentW + node.w;
				
				if(nextW < weightMap[nextEnd]) {
					weightMap[nextEnd] = nextW;
					pq.add(new Node(nextEnd, nextW));
				}
			}
		}
		
		System.out.println(weightMap[end]);
	}
	
	static class Node{
		int end;
		int w;
		
		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}
	}

}
