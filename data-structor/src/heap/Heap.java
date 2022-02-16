package heap;

public class Heap {
	
	private int arr[];
	private int size;
	
	public Heap() {
		arr = new int[10+1];
		size = 0;
	}
	
	private int getParent(int index) {
		return index/2;
	}
	
	private int getLeftChild(int index) {
		return index*2;
	}
	
	private int getRightChild(int index) {
		return index*2+1;
	}
	
	private boolean isLeaf(int index) {
		return index > (size/2) && index<=size;
	}
	
	public void insert(int value) {
		size += 1;
		arr[size] = value;
	
		int currentPos = size;	
		int parentPos = getParent(currentPos);
		while(currentPos > 1 && 
				arr[currentPos] < arr[parentPos]) {
			int temp = arr[currentPos]; 
			arr[currentPos] = arr[parentPos];
			arr[parentPos] = temp;
			
			currentPos = parentPos;
			parentPos = getParent(currentPos);
		}
	}
	
	public int delete() {
		int returnValue = arr[1];
		
		arr[1] = arr[size];
		size--;
		
		int currentPos = 1;
		while(currentPos*2 <= size ) {			
			int left = getLeftChild(currentPos);
			int leftValue = arr[left];
			
			int min = leftValue;
			int minPos = left;
			
			int right = getRightChild(currentPos);
			if(right <= size) {
				int rightValue = arr[right];
				if(min > rightValue) {
					min = rightValue;
					minPos = right;
				}
			}
			
			if(min > arr[currentPos]) {
				break;
			}
			
			arr[minPos] = arr[currentPos];
			arr[currentPos] = min;
			currentPos = minPos;
		}
		
		return returnValue;
	}
}
