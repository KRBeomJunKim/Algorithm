package search;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class DFS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		for(int i=1;i<=N;i++) {
			graph.put(i, new ArrayList<>());
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		
		for(int i=1;i<=N;i++) {
			graph.get(i).sort(Comparator.reverseOrder());
		}
		
		Queue<Integer> visited = new LinkedList<>();
		Deque<Integer> needVisit = new ArrayDeque<>();
		
		needVisit.add(V);
		while(!needVisit.isEmpty()) {
			int current = needVisit.pollLast();
			if(!visited.contains(current)) {
				visited.add(current);
				needVisit.addAll(graph.get(current));
			}
		}
		
		visited.stream().forEach(i -> System.out.print(i + " "));
	}

}
