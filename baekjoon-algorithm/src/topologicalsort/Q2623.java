package topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2623 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		List<Integer>[] outdegree = new List[N+1];
		for(int i=0;i<outdegree.length;i++)
			outdegree[i] = new ArrayList<>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			if(K==0) continue;
			
			int prev=Integer.parseInt(st.nextToken());
			int curr=0;
			for(int j=1;j<K;j++) {
				curr = Integer.parseInt(st.nextToken());
				indegree[curr]++;
				outdegree[prev].add(curr);
				prev=curr;
			}
		}
		
		List<Integer> result = new ArrayList<Integer>();
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<indegree.length;i++) {
			if(indegree[i] == 0) queue.offer(i);
		}
		
		for(int i=0;i<N;i++) {
			if(queue.isEmpty()) {
				System.out.println(0);
				return;
			}
			
			int curr = queue.poll();
			result.add(curr);
			
			for(int next:outdegree[curr]) {
				indegree[next] -= 1;
				if(indegree[next]==0)
					queue.offer(next);
			}
		}
		
		for(int i:result) {
			System.out.println(i);
		}
	}

}
