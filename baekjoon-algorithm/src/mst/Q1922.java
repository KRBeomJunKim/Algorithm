package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1922 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[] parent = new int[N+1];
		for(int i=1;i<N+1;i++)
			parent[i] = i;
		
		int[] rank = new int[N+1];
		
		int[][] vertices = new int[M][3];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			vertices[i][0] = v1;
			vertices[i][1] = v2;
			vertices[i][2] = w;
		}
		
		Arrays.sort(vertices, (v1, v2)->v1[2]-v2[2]);
		
		int result=0;
		for(int[] vertex:vertices) {
			int v1 = vertex[0];
			int v2 = vertex[1];
			int w = vertex[2];
			
			if(find(parent, v1) != find(parent, v2)) {
				result += w;
				union(parent, v1, v2, rank);
			}
		}
		
		System.out.println(result);
		
	}

	private static void union(int[] parent, int v1, int v2, int[] rank) {
		int v1Parent = find(parent, v1);
		int v2Parent = find(parent, v2);
		
		if(rank[v1Parent] > rank[v2Parent]) {
			parent[v2Parent] = v1Parent;
		} else {
			parent[v1Parent] = v2Parent;
			if(rank[v1Parent] == rank[v2Parent]) {
				rank[v2Parent] += 1;
			}
		}
		
	}

	private static int find(int[] parent, int v) {
		if(parent[v] == v) {
			return v;
		}
		return parent[v] = find(parent, parent[v]);
	}

}
