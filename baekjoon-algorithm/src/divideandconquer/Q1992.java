package divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1992 {
	
	static boolean[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		map = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			String row = br.readLine();
			for(int j=0;j<N;j++) {
				if(row.charAt(j) == '0') {
					map[i][j] = false;
				}
				else {
					map[i][j] = true;
				}
			}
		}
		
		encoding(0, 0, N);
		System.out.println();
	}

	private static void encoding(int row, int column, int count) {
		boolean isAllSame = true;
		boolean criteria = map[row][column];
		for(int i=0;i<count;i++) {
			for(int j=0;j<count;j++) {
				if(map[row+i][column+j] != criteria) {
					isAllSame = false;
					break;
				}
			}
			if(!isAllSame)
				break;
		}
		
		if(isAllSame) {
			if(criteria)
				System.out.print(1);
			else
				System.out.print(0);
			return;
		}
		
		System.out.print("(");
		
		encoding(row, column, count/2);
		encoding(row, column+count/2, count/2);
		encoding(row+count/2, column, count/2);
		encoding(row+count/2, column+count/2, count/2);
		
		System.out.print(")");
		
		
	}

}
