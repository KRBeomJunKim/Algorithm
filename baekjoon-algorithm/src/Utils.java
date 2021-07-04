
public class Utils { 
	
	public static <T> void swap(T[] map, int start, int end) {
		T temp = map[start];
		map[start] = map[end];
		map[end] = temp;
	}
}
