package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		long inputMax=0;
		long[] wires = new long[K];
		for(int i=0;i<K;i++) {
			long wire = Long.parseLong(br.readLine());
			wires[i] = wire;
			inputMax = inputMax > wire ? inputMax : wire;
		}
		
		long start=1;
		long end=inputMax;
		
		while(start<=end) {
			long mid = (start+end)/2;
			
			int currentN=0;
			for(long wire:wires) {
				currentN += (wire/mid);
			}
			
			if(currentN>=N) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		
		System.out.println(end);
		
	}

}
