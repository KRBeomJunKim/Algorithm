package topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Q1766 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		List<Integer>[] outdegree = new List[N+1];
		for(int i=1;i<N+1;i++) {
			outdegree[i] = new ArrayList<Integer>();
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			indegree[end]++;
			outdegree[start].add(end);
		}
		
		for(int i=1;i<indegree.length;i++) {
			if(indegree[i] == 0) {
				pq.add(i);
			}
		}
		
		for(int i=1;i<N+1;i++) {
			int current = pq.poll();
			System.out.print(current + " ");
			for(int next:outdegree[current]) {
				indegree[next]--;
				if(indegree[next] == 0) {
					pq.offer(next);
				}
			}
		}
		
	}

}
