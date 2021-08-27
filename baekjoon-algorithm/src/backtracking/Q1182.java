package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1182 {

	static int result=0;
	static int N;
	static int S;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(nums, 0, 0);
		
		if(S == 0)
			System.out.println(result-1);
		else
			System.out.println(result);
	}

	private static void dfs(int[] nums, int depth, int currentTotal) {
		if(depth == nums.length) {
			if(S == currentTotal) {
				result++;
			}
			return;
		}
		
		dfs(nums, depth+1, currentTotal);
		dfs(nums, depth+1, currentTotal+nums[depth]);
	}

}
