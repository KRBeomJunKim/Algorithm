package treedp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q15681 {
	
	static List<Integer>[] tree;
	static int[] dp;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 첫문장 parse
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		// 위에 쓰이는 3개 초기화
		dp = new int[N+1];
		for(int i=0;i<dp.length;i++) {
			dp[i] = 1;			
		}
		visited = new boolean[N+1];
		tree = new List[N+1];
		for(int i=1;i<tree.length;i++) {
			tree[i] = new ArrayList<>();
		}
		
		// U, V입력받음
		for(int i=0;i<N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			tree[U].add(V);
			tree[V].add(U);
		}
		
		// dfs
		dfs(R);
		
		// 출력
		for(int i=0;i<Q;i++) {
			int query = Integer.parseInt(br.readLine());
			System.out.println(dp[query]);
		}
	}

	private static int dfs(int current) {
		if(visited[current]) return dp[current];
		visited[current] = true;
		
		for(int next :tree[current]) {
			if(visited[next]) continue;
			dp[current] = dp[current] + dfs(next);
		}
		
		return dp[current];
	}

}
