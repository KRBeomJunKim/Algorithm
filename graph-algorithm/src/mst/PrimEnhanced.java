package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class PrimEnhanced {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Node>[] nodes = new List[V+1];
		for(int i=1;i<nodes.length;i++)
			nodes[i] = new ArrayList<>();
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			nodes[v1].add(new Node(v1, v2, w));
			nodes[v2].add(new Node(v2, v1, w));
		}
		
		int[] graph = new int[V+1];
		Arrays.fill(graph, Integer.MAX_VALUE);
		
		int start=1;
		graph[start] = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(start);
		
		int result=0;
		List<int[]> mst = new ArrayList<int[]>();
		
		Set<Integer> set = new HashSet<>();
		
		while(!pq.isEmpty()) {
			int currentNode = pq.poll();
			int currentW = graph[currentNode];
			
			set.add(currentNode);
			
			result += currentW;
			
			for(Node node :nodes[currentNode]) {
				int nextEnd = node.end;
				int nextW = node.w;
				
				if(graph[nextEnd] > nextW && !set.contains(nextEnd)) {
					graph[nextEnd] = nextW;
					pq.offer(nextEnd);
				}
			}
		}
		
		System.out.println("result : " + result);
		System.out.println("====================");
		for(int[] edge:mst) {
			System.out.println(Arrays.toString(edge));
		}
		System.out.println("====================");
		
		
	}
	
	static class Node{
		int start;
		int end;
		int w;
		
		public Node(int start, int end, int w) {
			this.start = start;
			this.end = end;
			this.w = w;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", w=" + w + "]";
		}
	}

}
