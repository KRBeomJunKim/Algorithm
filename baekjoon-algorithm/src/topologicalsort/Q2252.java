package topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q2252 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] indegree = new int[N+1];
		List<Integer>[] outdegree = new List[N+1];
		for(int i=0;i<outdegree.length;i++)
			outdegree[i] = new ArrayList<Integer>();
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int previous = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			
			indegree[next]++;
			outdegree[previous].add(next);
		}
		
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=1;i<N+1;i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		for(int i=1;i<N+1;i++) {
			if(queue.isEmpty()) {
				return;
			}
			
			int current = queue.poll();
			System.out.print(current + " ");
			for(int next:outdegree[current]) {
				indegree[next]--;
				if(indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		
	}

}
