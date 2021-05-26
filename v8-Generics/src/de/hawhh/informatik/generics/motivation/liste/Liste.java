package de.hawhh.informatik.generics.motivation.liste;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Liste<T> implements Iterable<T> {
	private T[] intern = (T[])new Object[1];
	private int n=0;

	public int size(){ return intern.length;	}
	public boolean isEmpty(){return size()==0;}
	public boolean contains(Object e){
		for(Object o : intern) {
			if (e==null && o==null || o.equals(e)) return true;
		}
		return false;
	}
	public void add(T elem){
		if (n== intern.length) {
			resize(2*n);
		}
		intern[n++] = elem;
	}
	public void set(int index,T elem){
		checkIndex(index);
		intern[index] = elem;
	}

	public T get(int index){
		checkIndex(index);
		return intern[index];
	}



	public T remove(int index) {
		checkIndex(index);
		if (n==intern.length/4) resize(n/2);
		T toRemove = intern[index];
		System.arraycopy(intern, index, intern, index+1, n-index-1);
		n--;
		return toRemove;
	}

	@Override
	public String toString() {
		return Arrays.deepToString(intern);
	}

	private void checkIndex(int index){
		 if (index <0 || index >= size()) throw new IndexOutOfBoundsException(index);
	 }
	private void resize(int newSize){
		intern = Arrays.copyOf(intern,newSize);
	}
	@Override
	public Iterator<T> iterator() {
		return new ListeIterator();
	}	
	
	private class ListeIterator implements Iterator<T> {
		private int readCursor=0;
		private boolean nextGiven=false;
		@Override
		public boolean hasNext() {
			return readCursor<n;
		}
		@Override
		public T next() {
			if (!hasNext()) throw new NoSuchElementException();
			nextGiven = true;
			return intern[readCursor++];
		}
		@Override
		public void remove() {
			if (nextGiven) {
				Liste.this.remove(readCursor-1);
				readCursor--;
			} else {
				throw new IllegalStateException();
			}
			nextGiven = !nextGiven;
		}
	}
}
