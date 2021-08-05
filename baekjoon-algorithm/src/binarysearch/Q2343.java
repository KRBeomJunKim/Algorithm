package binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2343 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] lessons = new int[N];
		st = new StringTokenizer(br.readLine());
		int maxLesson = 0;
		int sumLesson=0;
		for(int i=0;i<N;i++) {
			lessons[i] = Integer.parseInt(st.nextToken());
			maxLesson = Math.max(maxLesson, lessons[i]);
			sumLesson += lessons[i];
		}
		
		int start = maxLesson;
		int end = sumLesson;
		
		while(start<=end) {
			int mid = (start+end)/2;
			
			int groupNum=0;
			int groupSum=0;
			for(int i=0;i<N;i++) {
				if(groupSum + lessons[i] > mid) {
					groupSum=lessons[i];
					groupNum++;
				} else {
					groupSum += lessons[i];
				}
			}
			
			if(groupNum >= M) {
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		
		System.out.println(start);
	}

}
