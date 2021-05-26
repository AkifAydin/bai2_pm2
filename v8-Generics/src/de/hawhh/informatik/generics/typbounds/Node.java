package de.hawhh.informatik.generics.typbounds;

// Upper Typebound
public class Node<T extends Number> {
	private Node<T> left, right;
	private T info;
	
	public Node(T info,Node<T> left, Node<T> right){
		this.info = info;
		this.left = left;
		this.right = right;
	}
	public Node(T info){
		this(info,null,null);
	}
	T getInfo() {
		return info;
	}
	void setInfo(T info) {
		this.info = info;
	}
	Node<T> getLeft() {
		return left;
	}
	void setLeft(Node<T> left) {
		this.left = left;
	}
	Node<T> getRight() {
		return right;
	}
}
