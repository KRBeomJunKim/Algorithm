package basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Insertion {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] map = new int[N];
		
		for(int i=0;i<N;i++)
			map[i] = Integer.parseInt(br.readLine());
		
		for(int i=1;i<N;i++) {
			for(int j=i;j>0;j--) {
				if(map[j] < map[j-1]) {
					int temp = map[j];
					map[j] = map[j-1];
					map[j-1] = temp;
				} else {
					break;
				}
			}
		}
		
		for(int i:map)
			System.out.println(i);
	}

}
