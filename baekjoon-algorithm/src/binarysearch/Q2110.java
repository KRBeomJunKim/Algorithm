package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2110 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int[] wifi = new int[N];
		for(int i=0;i<wifi.length;i++) {
			wifi[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(wifi);
		
		int ans=0;
		
		int start=1;
		int end=wifi[N-1] - wifi[0];
		while(start<=end) {
			int mid = (start+end)/2;
			
			int startSearch = wifi[0];
			int resultTemp=1;
			for(int i=0;i<wifi.length;i++) {
				if(mid <= wifi[i]-startSearch) {
					startSearch=wifi[i];
					resultTemp++;
				}
			}
			
			if(resultTemp < C) {
				end = mid-1;
			} else {
				ans=resultTemp;
				start=mid+1;
			}
		}
		
		System.out.println(ans);
	}

}
