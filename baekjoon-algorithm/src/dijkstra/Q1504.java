package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1504 {
	
	static int N;
	static int E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		List<Node>[] adj = new List[N+1];
		for(int i=0;i<adj.length;i++) {
			adj[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			adj[a].add(new Node(b, c));
			adj[b].add(new Node(a, c));
		}
		
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());
		
		int result1 = dijkstra(adj, 1, v1);
		int result2 = dijkstra(adj, v1, v2);
		int result3 = dijkstra(adj, v2, N);
		
		if(result1==Integer.MAX_VALUE || result2==Integer.MAX_VALUE || result3==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		int result4 = dijkstra(adj, 1, v2);
		int result5 = dijkstra(adj, v2, v1);
		int result6 = dijkstra(adj, v1, N);
		
		if(result4==Integer.MAX_VALUE || result5==Integer.MAX_VALUE || result6==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		int totalResult1 = result1+result2+result3;
		int totalResult2 = result4+result5+result6;
		
		System.out.println(Math.min(totalResult1, totalResult2));
		
	}
	
	
	
	private static int dijkstra(List<Node>[] adj, int start, int end) {
		int[] weights = new int[N+1];
		Arrays.fill(weights, Integer.MAX_VALUE);
		
		weights[start] = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w - n2.w);
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int currentEnd = currentNode.end;
			int currentW = currentNode.w;
			
			if(weights[currentEnd] < currentW) {
				continue;
			}
			
			for(Node nextNode :adj[currentEnd]) {
				int nextEnd = nextNode.end;
				int nextW = nextNode.w + currentW;
				
				if(nextW < weights[nextEnd]) {
					weights[nextEnd] = nextW;
					pq.offer(new Node(nextEnd, nextW));
				}
			}
		}
		
		return weights[end];
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
