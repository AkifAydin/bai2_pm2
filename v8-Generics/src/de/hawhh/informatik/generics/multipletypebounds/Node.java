package de.hawhh.informatik.generics.multipletypebounds;

public class Node<T extends Printable & TimeStamped> {
	private T info;
	private Node<T> left;
	private Node<T> right;
	
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
