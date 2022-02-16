package list;

public class ArrayList<T> {

	private Object[] arr;
	private int size;
	
	private static final int DEFAULT_INITAL_SIZE = 10;

	public ArrayList() {
		this.arr = new Object[DEFAULT_INITAL_SIZE];
		this.size = 0;
	}
	
	public ArrayList(int capacity) {
		this.arr = new Object[capacity];
		this.size = 0;
	}
	
	public int size() {
		return size;
	}
	
	
	public void add(T t) {
		if (this.arr.length == this.size) {
			expandArray();
		}
		arr[size] = t;
		size++;
	}
	
	public void add(T t, int index) {
		if (this.arr.length == this.size) {
			expandArray();
		}
		System.arraycopy(arr, index, arr, index+1, arr.length - index - 1);
		arr[index] = t;
		size++;
	}
	
	private void expandArray() {
		Object[] newArr = new Object[arr.length*2];
		System.arraycopy(arr, 0, newArr, 0, arr.length);
		arr = newArr;
	}
	
	public T get(int index) {
		return (T) arr[index];
	}
	
	public T remove(int index) {
		T result = (T) arr[index];
		System.arraycopy(arr, index+1, arr, index, arr.length - index - 1);
		size--;
		return result;
	}
	
	
}
