package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class kruskal {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[] parent = new int[V+1];
		int[] rank = new int[V+1];
		
		int[][] vertices = new int[E][3];
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			vertices[i][0] = w;
			vertices[i][1] = start;
			vertices[i][2] = end;
		}
		
		// 초기화
		for(int i=1;i<V+1;i++) {
			parent[i] = i;
		}
		
		// sort
		Arrays.sort(vertices, (v1, v2) -> v1[0] - v2[0]);
		
		// 알고리즘
		for(int[] vertice: vertices) {
			int w = vertice[0];
			int v1 = vertice[1];
			int v2 = vertice[2];
			
			if(find(parent, v1) != find(parent, v2)) {
				union(parent, rank, v1, v2);
				System.out.printf("(w, v1, v2) = (%d, %d, %d)\n", w, v1, v2);
			}
		}
	}

	private static void union(int[] parent, int[] rank, int v1, int v2) {
		int v1Parent = find(parent, v1);
		int v2Parent = find(parent, v2);
		
		if(rank[v1] > rank[v2]) {
			parent[v2Parent] = v1Parent;
		} else {
			parent[v1Parent] = v2Parent;
			if(rank[v1] == rank[v2]) {
				rank[v1] += 1;
			}
		}
	}

	private static int find(int[] parent, int v) {
		if(parent[v] != v)
			parent[v] = find(parent, parent[v]);
		return parent[v];
	}
	
	

}
