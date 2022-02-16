package list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface MyList<T> extends List<T>  {

	@Override
	default int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	default boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default boolean add(T e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default boolean addAll(Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default boolean addAll(int index, Collection<? extends T> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	default void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	default T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default T set(int index, T element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default void add(int index, T element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default T remove(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	default int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	default ListIterator<T> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default ListIterator<T> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default List<T> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
}
