package advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Merge {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] nums = new int[N];
		
		for(int i=0;i<N;i++)
			nums[i] = Integer.parseInt(br.readLine());
		
		mergeSort(nums, 0, N);

		for(int i:nums)
			System.out.println(i);
	}
	
	static void mergeSort(int[] nums, int start, int end) {
		if(end-start <= 1)
			return;
		
		int mid = (end+start)/2;
		
		mergeSort(nums, start, mid);
		mergeSort(nums, mid, end);
		
		int[] newNums = new int[end-start];
		int nIndex = 0;
		int fIndex = start;
		int rIndex = mid;

		while(fIndex < mid && rIndex < end) {
			if(nums[fIndex] < nums[rIndex]) {
				newNums[nIndex] = nums[fIndex];
				fIndex++; nIndex++;
			} else {
				newNums[nIndex] = nums[rIndex];
				rIndex++; nIndex++;
			}
		}
		
		if(fIndex == mid) {
			System.arraycopy(nums, rIndex, newNums, nIndex, end-rIndex);
		} else if(rIndex == end) {
			System.arraycopy(nums, fIndex, newNums, nIndex, mid-fIndex);
		}
		
		System.arraycopy(newNums, 0, nums, start, newNums.length);
	}

}
