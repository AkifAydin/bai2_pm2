package de.hawhh.informatik.generics.wildcards;

public class Node<T> implements NodeI<T> {
	private static final int inc = 2;
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
	public T getInfo() {
		return info;
	}
	public void setInfo(T  info) {
		this.info = info;
	}
	public Node<T> getLeft() {
		return left;
	}
	protected void setLeft(Node<T> left) {
		this.left = left;
	}
	public Node<T> getRight() {
		return right;
	}
	protected void setRight(Node<T> right) {
		this.right = right;
	}
	public void insert(T info){
		if (left== null) {
			left = new Node<T>(info);
			return;
		}
		if (right==null) {
			right = new Node<T>(info);
			return;
		}
		if (left.depth() <= right.depth()) {
			left.insert(info);
			return;
		}
		right.insert(info);
		return;
	}
	
	public int depth(){
		int depth = 1;
		int max = 1;
		if (left!= null) {
			max =  depth +left.depth();
		}
		if (right!=null){
			max = Math.max(max, depth+right.depth());
		}
		return max;
	}
	
	public void copyInfoFrom(Node<? extends T> other) {
		//Lesen erlaubt
		info = other.getInfo(); 
	}
	
	public void copyInfoTo(Node<? super T> other){
		// Schreiben erlaubt
		other.setInfo(info);
	}
	
	@Override
	public String toString() {
		return this.toString(0);
	}

	static protected String indentString(int depth) {
		StringBuffer indentBuffer = new StringBuffer(depth);
		for (int i = 0; i < depth; i++) {
			indentBuffer.append(' ');
		}
		return indentBuffer.toString();
	}

	protected String toString(int depth) {
		String indent = Node.indentString(depth);
		return  "\n" + indent + "Node(" + info + (left==null? "": left.toString(depth + inc))
				+ (right==null? "":right.toString(depth + inc)) + ")";
	}
}
