package stack;

import list.ArrayList;

public class Stack<T> {
	
	ArrayList<T> list = new ArrayList<>();
	
	public void push(T element) {
		list.add(element);
	}
	
	public T pop() {
		return list.remove(list.size()-1);
	}
}
