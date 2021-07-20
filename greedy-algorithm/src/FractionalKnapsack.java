import java.util.Arrays;

public class FractionalKnapsack {

	public static void main(String[] args) {
		
		int[][] weightWorth = {{10, 10}, {15, 12}, {20, 10}, {25, 8}, {30, 5}};
		int maxWeight = 30;
		double result=0;
		
		Arrays.sort(weightWorth, (ww1, ww2) -> (ww2[1]/ww2[0]) - (ww1[1]/ww1[0]));
		
		for(int i=0;i<weightWorth.length;i++) {
			int currentWeight = weightWorth[i][0];
			int currentWorth = weightWorth[i][1];
			
			if(maxWeight >= currentWeight) {
				result += currentWorth;
				maxWeight -= currentWeight;
			} else {
				result += ((double)currentWorth/currentWeight)*maxWeight;
				break;
			}
		}
		
		System.out.println(result);
	}

}
