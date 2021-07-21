package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2512 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] budgets = new int[N];
		int maxBudget=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<budgets.length;i++) {
			budgets[i] = Integer.parseInt(st.nextToken());
			maxBudget = Math.max(maxBudget, budgets[i]);
		}
		
		int M = Integer.parseInt(br.readLine());
		
		int start = 0;
		int end = maxBudget;
		while(start <= end) {
			int mid = (start+end) / 2;
			
			int currentRequire = 0;
			for(int budget:budgets) {
				if(mid < budget)
					currentRequire += mid;
				else
					currentRequire += budget;
			}
			
			if(currentRequire > M) {
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		
		System.out.println(end);
		
	}

}
