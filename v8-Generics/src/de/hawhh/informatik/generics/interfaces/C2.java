package de.hawhh.informatik.generics.interfaces;

public class C2<T> implements Taggable<T> {

	private T tag;
	public C2(T tag) {
		this.tag = tag;
	}
	public T getTag() {
		return tag;
	}
	public void setTag(T tag) {
		this.tag = tag;
	}
}
