package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Q9663 {

	static int result;
	static int N;
	static List<Integer> candidate; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		result = 0;
		candidate = new ArrayList<>();
		DFS(0);
		
		System.out.println(result);
	}

	private static void DFS(int row) {
		if(row == N) {
			result += 1;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(promise(row, i)) {
				candidate.add(i);
				DFS(row+1);
				candidate.remove(candidate.size()-1);
			}
		}
	}

	private static boolean promise(int row, int col) {
		for(int i=0;i<candidate.size();i++) {
			int previousRow = i;
			int previousCol = candidate.get(i);
			
			if(col==previousCol || Math.abs(col-previousCol)==row-previousRow)
				return false;
		}
		return true;
	}
	
	

}
