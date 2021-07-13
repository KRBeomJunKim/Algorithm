package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q1463 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] map = new int[1000001];
		Arrays.fill(map, Integer.MAX_VALUE);
		
		map[1] = 0;
		for(int i=1;i<N;i++) {
			int nextCount = map[i] + 1;
			map[i+1] = Math.min(map[i+1], nextCount);
			if(i*2<1000001)
				map[i*2] = Math.min(map[i*2], nextCount);
			if(i*3<1000001)
				map[i*3] = Math.min(map[i*3], nextCount);
		}
		
		System.out.println(map[N]);
	}

}
