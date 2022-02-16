package list;

public class LinkedList<T> implements MyList<T>{
	
	static class Node<T> {
		T value;
		Node<T> next;
		
		public Node(T value, Node<T> next) {
			super();
			this.value = value;
			this.next = next;
		}
	}
	
	private Node<T> head;
	private int size;
	
	public LinkedList() {
		head = new Node<>(null, null);
		size = 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return head.next == null;
	}

	@Override
	public boolean add(T e) {
		Node<T> tail = head;
		
		while(tail.next!=null) {
			tail = tail.next;
		}
		
		tail.next = new Node<>(e, null);
		
		return true;
	}

	@Override
	public void clear() {
		head.next = null;
	}

	@Override
	public T get(int index) {
		
		Node<T> target = head.next; 
		for(int i=0;i<index;i++) {
			target = target.next;
		}
		
		return target.value;
	}

	@Override
	public void add(int index, T element) {
		Node<T> target = head; 
		for(int i=0;i<index;i++) {
			target = target.next;
		}
		
		Node<T> targetNext = new Node<>(element, target.next.next);
		
		target.next = targetNext;
	}

	@Override
	public T remove(int index) {
		Node<T> target = head.next; 
		for(int i=0;i<index-1;i++) {
			target = target.next;
		}
		
		T result = target.next.value;
		
		target.next = target.next.next;
		
		return result;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("[ ");
		
		Node<T> target = head.next; 
		while(target != null) {
			sb.append(target.value + " ");
			target = target.next;
		}
		
		sb.append("]");
		
		return sb.toString();
	}
	
	

	

}
