package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1753 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
		
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;
		
		List<Node>[] vertices = new List[V+1]; 
		for(int i=0;i<vertices.length;i++) {
			vertices[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			vertices[start].add(new Node(end, weight));
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>((n1, n2) -> n1.w - n2.w);
		pq.offer(new Node(K, 0));
		while(!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int currentEnd = currentNode.end;
			int currentW = currentNode.w;
			
			if(dist[currentEnd] < currentW)
				continue;
			
			for(Node nextNode:vertices[currentEnd]) {
				int nextEnd = nextNode.end;
				int nextW = nextNode.w + currentW;
				
				if(dist[nextEnd] > nextW) {
					dist[nextEnd] = nextW;
					pq.offer(new Node(nextEnd, nextW));
				}
			}
		}
		
		for(int i=1;i<dist.length;i++) {
			if(dist[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
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
