package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
			
		List<Node>[] graph = new List[n+1];
		for(int i=0;i<n+1;i++)
			graph[i] = new ArrayList<>();
			
		for(int i=0;i<d;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
				
			graph[b].add(new Node(a, s));
		}
		
		int[] distances = new int[n+1];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[c] = 0;
			
		PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) 
				-> n1.distance - n2.distance);
		pq.add(new Node(c, 0));
			
		while(!pq.isEmpty()) {
			Node currentNode = pq.poll();
			int currentEnd = currentNode.end;
			int currentDistance = currentNode.distance;
			
			if(distances[currentEnd] < currentDistance)
				continue;
				
			for(Node n_:graph[currentEnd]) {
				int distance_ = currentDistance + n_.distance;
					
				if(distance_ < distances[n_.end]) {
					distances[n_.end] = distance_;
					pq.add(new Node(n_.end, distance_));
				}
			}
		}
			
		System.out.println(Arrays.toString(distances));

	}
	
	static class Node{
		int end;
		int distance;
				
		public Node(int end, int distance) {
			this.end = end;
			this.distance = distance;
		}
		
		@Override
		public String toString() {
			return "Node [end=" + end + ", distance=" + distance + "]";
		}
		
		
	}

}
