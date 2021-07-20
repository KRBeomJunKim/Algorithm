package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] trees = new int[N];
		long max=0;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}
		
		long start = 0;
		long end = max;
		
		while(start <= end) {
			long mid = (start+end)/2;
			
			long sum = 0;
			for(int tree:trees) {
				if(tree>mid) {
					sum+=tree-mid;
				}
			}
			
			if(sum>=M) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		
		System.out.println(end);
		
	}

}
