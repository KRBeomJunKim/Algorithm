package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Q1987 {
	
	static String[][] map;
	static boolean[][] visited;
	static int R;
	static int C;
	static int result=0;
	
	static int[] dy = {-1, 1, 0, 0}; 
	static int[] dx = {0, 0, 1, -1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		visited = new boolean[R][C];
		
		for(int i=0;i<R;i++) {
			String[] row = br.readLine().split("");
			for(int j=0;j<C;j++) {
				map[i][j] = row[j];
			}
		}
		
		Set<String> currentAlphabet = new HashSet<>();
		dfs(0, 0, currentAlphabet, 1);
		
		System.out.println(result);
	}

	private static void dfs(int currentRow, int currentCol, Set<String> currentAlphabet, int depth) {
		currentAlphabet.add(map[currentRow][currentCol]);
		visited[currentRow][currentCol] = true;
		
		for(int i=0;i<4;i++) {
			int nextRow = currentRow + dy[i];
			int nextCol = currentCol + dx[i];
			
			if((nextRow >= 0 && nextRow < R) && (nextCol >= 0 && nextCol < C)) {
				if(!visited[nextRow][nextCol]) {
					if(!currentAlphabet.contains(map[nextRow][nextCol])) {
						dfs(nextRow, nextCol, currentAlphabet, depth+1);
					}
				}
			}
		}
		
		result = Math.max(result, currentAlphabet.size());
		
		currentAlphabet.remove(map[currentRow][currentCol]);
		visited[currentRow][currentCol] = false;
	}

}
