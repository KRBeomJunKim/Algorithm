package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1238 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<Node>[] vertices = new List[N + 1];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			vertices[start].add(new Node(end, T));
		}
		
		int total = 0;
		int[] forward = dijkstra(vertices, X);
		for(int i=1;i<forward.length;i++) {
			int forwardW = forward[i];
			int[] back = dijkstra(vertices, i);
			int backW = back[X];
			
			total = Math.max(total, forwardW + backW);
		}
		
		System.out.println(total);
	}

	private static int[] dijkstra(List<Node>[] vertices, int X) {
		int[] weights = new int[vertices.length];
		Arrays.fill(weights, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.w-n2.w);
		
		weights[X] = 0;
		pq.offer(new Node(X, 0));
		
		while(!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int currentEnd = currentNode.end;
			int currentW = currentNode.w;
			
			if(weights[currentEnd] < currentW)
				continue;
			
			for(Node nextNode: vertices[currentEnd]) {
				int nextEnd = nextNode.end;
				int nextW = nextNode.w + currentW;
				
				if(weights[nextEnd] > nextW) {
					weights[nextEnd] = nextW;
					pq.add(new Node(nextEnd, nextW));
				}
			}
		}
		
		return weights;
	}

	static class Node {
		int end;
		int w;

		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}
	}

}
