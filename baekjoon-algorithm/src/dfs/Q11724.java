package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Q11724 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		List<Integer>[] map = new List[V+1];
		for(int i=1;i<V+1;i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map[u].add(v);
			map[v].add(u);
		}
		
		boolean[] visited = new boolean[V+1];
		int result=0;
		for(int i=1;i<V+1;i++) {
			if(!visited[i]) {
				dfs(map, visited, i);
				result++;
			}
		}
		
		System.out.println(result);
		
		br.close();
	}

	private static void dfs(List<Integer>[] map, boolean[] visited, int start) {
		Deque<Integer> deque = new ArrayDeque<Integer>();
		deque.push(start);
		
		while(!deque.isEmpty()) {
			int current = deque.pop();
			if(!visited[current]) {
				visited[current] = true;
				map[current].forEach(i -> deque.push(i));
			}
		}
	}

}
