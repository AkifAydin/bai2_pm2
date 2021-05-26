package de.hawhh.informatik.generics.typeboundtypevar;

public interface NodeI<T> {
	
	public NodeI<T> getLeft();
	public NodeI<T> getRight();
	public T getInfo();
	public void insert(T info);
	public int depth();
}
