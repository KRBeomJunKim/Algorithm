import queue.Queue;
import queue.Queue2Stack;

public class Practice {

	public static void main(String[] args) {
		Queue2Stack<Integer> list = new Queue2Stack<>();
		for(int i=0;i<11;i++) {
			list.offer(i);
		}
		
		for(int i=0;i<11;i++) {
			System.out.println(list.poll());
		}
		
	}

}
