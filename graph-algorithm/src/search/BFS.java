package search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		for(int i=1;i<N+1;i++) {
			map.put(i, new PriorityQueue<>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map.get(start).add(end);
			map.get(end).add(start);
		}
		
		Queue<Integer> needVisit = new LinkedList<>();
		Queue<Integer> visited = new LinkedList<>();
		
		needVisit.add(V);
		
		while(!needVisit.isEmpty()) {
			int current = needVisit.poll();
			
			if(!visited.contains(current)) {
				visited.add(current);
				needVisit.addAll(map.get(current));
			}
		}
		
		visited.stream().forEach((i) -> System.out.print(i + " "));
	}

}
