package de.hawhh.informatik.generics.wildcards;

public interface NodeI<T> {
	
	public NodeI<T> getLeft();
	public NodeI<T> getRight();
	public T getInfo();
	public void insert(T info);
	public int depth();
}
