package advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Quick {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] list = new int[n];
		
		for(int i=0;i<n;i++)
			list[i] = Integer.parseInt(br.readLine());
		
		quickSort(list, 0, list.length-1);
		
		for(int i:list) {
			System.out.println(i);
		}
	}
	
	static void quickSort(int[] list, int lo, int hi) {
		if(lo >= hi) {
			return;
		}
		
		int pivot = lo;
		
		int newlo = lo;
		int newhi = hi;
		while(newlo < newhi) {
			while(list[newhi] > list[pivot] && newlo < newhi)
				newhi--;
			while(list[newlo] < list[pivot] && newlo < newhi)
				newlo++;
			
			int temp = list[newlo];
			list[newlo] = list[newhi];
			list[newhi] = temp;
		}
		
		if(list[pivot] > list[newhi]) {
			int temp = list[pivot];
			list[pivot] = list[newhi];
			list[newhi] = temp;
		}
		
		quickSort(list, lo, pivot-1);
		quickSort(list, pivot+1, hi);
	}

}
