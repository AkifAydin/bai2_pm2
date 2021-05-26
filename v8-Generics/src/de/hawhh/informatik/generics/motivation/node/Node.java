package de.hawhh.informatik.generics.motivation.node;

import java.util.Arrays;

public class Node {
	private Node left, right;
	private Object info;
	private static final int inc = 2;

	// ein innerer Knoten

	public Node(Object info, Node left, Node right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}

	Object getInfo() {
		return info;
	}

	void setInfo(Object info) {
		this.info = info;
	}

	Node getLeft() {
		return left;
	}

	Node getRight() {
		return right;
	}

	// ein Blatt
	public Node(Object content) {
		this(content, null, null);
	}

	/**
	 * 
	 * @return Liste der direkten Nachfolger ohne die leeren Knoten
	 */
	private Node[] immediateChildren() {
		if (left==null && right==null) return new Node[0];
		if (left==null) return new Node[]{right};
		if (right==null) return new Node[]{left};	
		return new Node[] { left, right };
	}
	/**
	 * 
	 * @return Liste aller Nachfolgerknoten im Baum
	 */
	public Node[] children(){
		Node[] childs = immediateChildren();
		int childslength = childs.length;
		for (Node n:immediateChildren()) {
			Node[] nchilds = n.children();
			childs =Arrays.copyOf(childs, childs.length+nchilds.length);
			System.arraycopy(nchilds, 0, childs, childslength, nchilds.length);
		}
		return childs;
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
