package divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1725 {
	
	static int[] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N];
		for(int i=0;i<N;i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		System.out.println(histogram(0, N));
	}
	
	static int histogram(int s, int e) {
		if(s==e) return 0;
		else if(s+1==e) return map[s];
		
		int mid = (s+e) / 2;
		int result = Math.max(histogram(s, mid), histogram(mid, e));
		
		int w = 1, h= map[mid], l=mid, r = mid;
		while(r-l+1 < e-s) {
			int p = l>s ? Math.min(h, map[l-1]) : -1;
			int q = r<e-1 ? Math.min(h, map[r+1]) : -1;
			
			if(p >= q) {
				h = p;
				l--;
			}
			else {
				h = q;
				r++;
			}
			
			result = Math.max(result, ++w*h);
		}
		return result;
	}

}
