package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Selection {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] map = new int[N];
		for(int i=0;i<N;i++) {
			map[i] = Integer.parseInt(br.readLine());
		}
		
		for(int i=0;i<N-1;i++) {
			int min = i;
			for(int j=i+1;j<N;j++) {
				if(map[min] > map[j]) {
					min = j;
				}
			}
			
			int temp = map[min];
			map[min] = map[i];
			map[i] = temp;
		}
		
		for(int i:map) {
			System.out.println(i);
		}
	}

}
