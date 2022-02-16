package queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Queue2Stack<T> {
	
	private Deque<T> offerDeque = new ArrayDeque<>();
	private Deque<T> pollDeque= new ArrayDeque<>();
	
	public void offer(T element) {
		offerDeque.push(element);
	}
	
	public T poll() {
		if(pollDeque.isEmpty()) {
			while(!offerDeque.isEmpty()) {
				pollDeque.offer(offerDeque.pop());
			}
		} 
		
		return pollDeque.pop();
	}
	
	public int size() {
		return offerDeque.size() + pollDeque.size();
	}
	
	

}
