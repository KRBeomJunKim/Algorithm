package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;

public class BubbleSort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] map = new int[N];
		
		for(int i=0;i<N;i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=N-1;i>0;i--) {
			boolean swap = false;
			for(int j=0;j!=i;j++) {
				if(map[j] > map[j+1]) {
					swap = true;
					int temp = map[j];
					map[j] = map[j+1];
					map[j+1] = temp;
				}
			}
			if(!swap) break;
		}
		
		for(int i:map) {
			System.out.println(i);
		}
	}

}
