package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q2580 {
	static int N=9;
	static int[][] map = new int[N][N];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		
	}

	public static void dfs(int row, int col) {
		 
		// 해당 행이 다 채워졌을 경우 다음 행의 첫 번째 열부터 시작
		if (col == 9) {
			dfs(row + 1, 0);
			return;
		}
 
		// 행과 열이 모두 채워졌을 경우 출력 후 종료
		if (row == 9) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
 
			// 출력 뒤 시스템을 종료한다.
			System.exit(0);
		}
 
		// 만약 해당 위치가 0 이라면 1부터 9까지 중 가능한 수 탐색
		if (map[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				// i 값이 중복되지 않는지 검사
				if (promise(row, col, i)) {
					map[row][col] = i;
					dfs(row, col + 1);
				}
			}
			map[row][col] = 0;
			return;
		}
 
		dfs(row, col + 1);
 
	}

	private static boolean promise(int currentY, int currentX, int wantValue) {
		if(rowPromise(currentY, currentX, wantValue) 
				&& colPromise(currentY, currentX, wantValue)
				&& boxPromise(currentY, currentX, wantValue)) {
			return true;
		}
		
		return false;
	}
	
	private static boolean rowPromise(int currentY, int currentX, int wantValue) {
		boolean result = true;
		for(int i=0;i<N;i++) {
			if(map[currentY][i] == wantValue) {
				result = false;
			}
		}
		return result;
	}
	
	private static boolean colPromise(int currentY, int currentX, int wantValue) {
		boolean result = true;
		for(int i=0;i<N;i++) {
			if(map[i][currentX] == wantValue) {
				result = false;
			}
		}
		return result;
	}

	private static boolean boxPromise(int currentY, int currentX, int wantValue) {
		boolean result = true;
		
		int boxInitPosY = (currentY/3)*3;
		int boxInitPosX = (currentX/3)*3;
		
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int boxPosY = boxInitPosY+i;
				int boxPosX = boxInitPosX+j;
				if(map[boxPosY][boxPosX] == wantValue) {
					result = false;
				}
			}
		}
		
		return result;
	}
}
