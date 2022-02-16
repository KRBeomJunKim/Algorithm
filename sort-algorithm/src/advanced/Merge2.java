package advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merge2 {
	
	static void mergeSort(int[] arr, int start, int end) {
		if(end-start == 1) {
			return; 
		}
		
		int mid = (start+end)/2;
		
		mergeSort(arr, start, mid);
		mergeSort(arr, mid, end);
		
		int arr1Start = start;
		int arr1End = mid;
		
		int arr2Start = mid;
		int arr2End = end;
		
		int[] newArray = new int[end-start];
		int newArrayIndex = 0;
		
		while(arr1Start < arr1End && arr2Start < arr2End) {
			if(arr[arr1Start] > arr[arr2Start]) {
				newArray[newArrayIndex] = arr[arr2Start];
				arr2Start++;
			} else {
				newArray[newArrayIndex] = arr[arr1Start];
				arr1Start++;
			}
			newArrayIndex++;
		}
		
		if(arr1Start==arr1End) {
			System.arraycopy(arr, arr2Start, newArray, newArrayIndex, arr2End-arr2Start); 
		} else {
			System.arraycopy(arr, arr1Start, newArray, newArrayIndex, arr1End-arr1Start);
		}
		
		System.arraycopy(newArray, 0, arr, start, end-start);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] list = new int[n];
		
		for(int i=0;i<n;i++)
			list[i] = Integer.parseInt(br.readLine());
		
		mergeSort(list, 0, list.length);
		
		for(int i:list) {
			System.out.println(i);
		}
	}

}
