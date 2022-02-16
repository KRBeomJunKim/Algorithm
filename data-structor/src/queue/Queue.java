package queue;

import java.util.Collection;
import java.util.Iterator;

import list.ArrayList;

public class Queue<T>{
	
	ArrayList<T> list;

	public Queue() {
		this.list = new ArrayList<>();
	}

	public int size() {
		return list.size();
	}

	public boolean isEmpty() {
		return list.size() == 0;
	}

	public void clear() {
		list = new ArrayList<>();
	}


	public boolean offer(T e) {
		list.add(e);
		return true;
	}

	public T poll() {
		return list.remove(0);
	}


	public T peek() {
		return list.get(0);
	}
}
