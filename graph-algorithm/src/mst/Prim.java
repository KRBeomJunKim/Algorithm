package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Prim {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Edge> mst = new ArrayList<Prim.Edge>();
		
		List<Node>[] nodes = new List[V+1];
		for(int i=1;i<nodes.length;i++) {
			nodes[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			nodes[v1].add(new Node(v2, w));
			nodes[v2].add(new Node(v1, w));
		}
		
		Set<Integer> connectedVertex = new HashSet<>();
		PriorityQueue<Edge> candidateEdges = new PriorityQueue<>();
		connectedVertex.add(1);
		for(Node n:nodes[1]) {
			candidateEdges.offer(new Edge(1, n.end, n.w));
		}
		
		while(!candidateEdges.isEmpty()) {
			Edge currentEdge = candidateEdges.poll();
			int currentStart = currentEdge.start;
			int currentEnd = currentEdge.end;
			int currentW = currentEdge.w;
			
			if(!connectedVertex.contains(currentEnd)) {
				connectedVertex.add(currentEnd);
				mst.add(new Edge(currentStart, currentEnd, currentW));
				
				for(Node n:nodes[currentEnd]) {
					if(!connectedVertex.contains(n.end)) {
						candidateEdges.offer(new Edge(currentEnd, n.end, n.w));
					}
				}
				
			}
		}
		
		System.out.println(mst);
		
	}
	
	static class Node{
		int end;
		int w;
		
		public Node(int end, int w) {
			this.end = end;
			this.w = w;
		}		
	}
	
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int w;
		
		public Edge(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public int compareTo(Edge o) {
			return w - o.w;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", w=" + w + "]";
		}
		
		
	}

}
