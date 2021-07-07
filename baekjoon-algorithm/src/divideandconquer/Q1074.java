package divideandconquer;

import java.util.Scanner;

public class Q1074 {
	
	static int globalCount=0;
	static int inputR;
	static int inputC;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		inputR = sc.nextInt();
		inputC = sc.nextInt();
		
		z(0, 0, N);
		
		sc.close();
	}
	
	public static void z(int r, int c, int count) {
		if(count == 0) {
			if(inputR == r && inputC == c)
				System.out.println(globalCount);
			return;
		}
		
		int sum = (int)Math.pow(2, count-1);
		if((inputR >= r && inputR < r+sum) && (inputC >= c && inputC < c+sum)){
			z(r, c, count-1);
		} else globalCount += (int)Math.pow(4, count-1);
		
		if((inputR >= r && inputR < r+sum) && (inputC >= c+sum && inputC < c+sum+sum)){
			z(r, c+sum, count-1);
		} else globalCount += (int)Math.pow(4, count-1);
		
		if((inputR >= r+sum && inputR < r+sum+sum) && (inputC >= c && inputC < c+sum)){
			z(r+sum, c, count-1);
		} else globalCount += (int)Math.pow(4, count-1);
		
		if((inputR >= r+sum && inputR < r+sum+sum) && (inputC >= c+sum && inputC < c+sum+sum)){
			z(r+sum, c+sum, count-1);
		} else globalCount += (int)Math.pow(4, count-1);
	}

}
