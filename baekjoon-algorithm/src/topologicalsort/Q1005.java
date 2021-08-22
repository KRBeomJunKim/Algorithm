package topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1005 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(br.readLine());
		for(int z=0;z<T;z++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] indegree = new int[N+1];
			List<Integer>[] outdegree = new List[N+1];
			for(int i=1;i<N+1;i++) {
				outdegree[i] = new ArrayList<Integer>();
			}
			
			int[] time = new int[N+1];
			int[] result = new int[N+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<N+1;i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				indegree[end]++;
				outdegree[start].add(end);
			}
			
			int W = Integer.parseInt(br.readLine());
			
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int i=1;i<N+1;i++) {
				if(indegree[i] == 0) {
					result[i] = time[i];
					queue.offer(i);
				}
			}
			
			for(int i=1;i<N+1;i++) {
				
				if(queue.isEmpty()) {
					return;
				}
				
				int current = queue.poll();
				for(int next:outdegree[current]) {
					result[next] = Math.max(result[next], result[current]+time[next]);
					indegree[next]--;
					if(indegree[next] == 0) {
						queue.offer(next);
					}
				}
			}
			
			System.out.println(result[W]);
		}
	}

}
