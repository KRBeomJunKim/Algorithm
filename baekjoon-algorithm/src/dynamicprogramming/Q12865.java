package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q12865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weights = new int[N];
		int[] values = new int[N];
		int[] maxWeights = new int[K+1];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			weights[i] = W;
			values[i] = V;
		}
		
		for(int i=0;i<N;i++) {
			for(int j=K;j>=weights[i];j--) {
				maxWeights[j] = Math.max(maxWeights[j], maxWeights[j-weights[i]] + values[i]);
			}
		}
		
		System.out.println(maxWeights[K]);
	}

}
