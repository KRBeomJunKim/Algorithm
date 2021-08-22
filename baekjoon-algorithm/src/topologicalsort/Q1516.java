package topologicalsort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1516 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(br.readLine());
		
		int[] indegree = new int[N+1];
		List<Integer>[] outdegree = new List[N+1];
		for(int i=0;i<outdegree.length;i++)
			outdegree[i] = new ArrayList<>();
		
		int[] time = new int[N+1];
		int[] result = new int[N+1];
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=1;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			
			int temp = Integer.parseInt(st.nextToken());
			time[i] = temp;
			while((temp = Integer.parseInt(st.nextToken()))!=-1) {
				indegree[i]++;
				outdegree[temp].add(i);
			}
			
			if(indegree[i] == 0) {
				result[i] = time[i]; 
				queue.add(i);
			}
				
		}
		
		for(int i=1;i<N+1;i++) {
			int curr = queue.poll();
			for(int next :outdegree[curr]) {
				result[next] = Math.max(result[next], result[curr]+time[next]);
				indegree[next]--;
				if(indegree[next] == 0)
					queue.offer(next);
			}
		}
		
		for(int i=1;i<N+1;i++) {
			System.out.println(result[i]);
		}
	}

}
