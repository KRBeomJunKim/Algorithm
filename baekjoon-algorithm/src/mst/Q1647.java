package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1647 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
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
		Arrays.sort(vertices, (v1, v2) -> v1[2]-v2[2]);
		
		int[] parent = new int[N+1];
		for(int i=1;i<N+1;i++) {
			parent[i] = i;
		}
		int[] rank = new int[N+1];
		
		int result=0;
		int verticesNum=0;
		for(int i=0;i<M;i++) {
			int v1 = vertices[i][0];
			int v2 = vertices[i][1];
			int w = vertices[i][2];
			
			if(find(v1, parent) != find(v2, parent)) {
				if(verticesNum > N-3) {
					break;
				}
				verticesNum++;
				result += w;
				union(v1, v2, parent, rank);
			}
		}
		
		System.out.println(result);
		
	}

	private static void union(int v1, int v2, int[] parent, int[] rank) {
		
		int v1Parent = find(v1, parent);
		int v2Parent = find(v2, parent);
		
		if(rank[v1Parent] > rank[v2Parent]) {
			parent[v2Parent] = v1Parent;
		} else {
			if(v1Parent==v2Parent) {
				rank[v2Parent]++;
			}
			parent[v1Parent] = v2Parent;
		}
	}

	private static int find(int v, int[] parent) {
		if(parent[v] == v) {
			return v;
		}
		
		return parent[v] = find(parent[v], parent);
	}

}
