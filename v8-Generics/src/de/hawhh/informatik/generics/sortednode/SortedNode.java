package de.hawhh.informatik.generics.sortednode;

public class SortedNode<T extends Comparable<T>> extends Node<T>  implements NodeI<T>{

	public SortedNode(T info) {
		super(info);
	}
	
	public void insert(T info) {
		if (this.getInfo().compareTo(info) ==0) return;
		if (this.getInfo().compareTo(info) >0 ) {
			// this.getLeft() zeigt auf eine SortedNode<T>
			Node<T> left = this.getLeft();
			if (left==null) {
				// Node<T> und SortedNode<T> sind kompatibel
				this.setLeft(new SortedNode<T>(info));
			}
			else left.insert(info);
			return;
		}
		Node<T> right = this.getRight();
		if(right==null) 
			this.setRight(new SortedNode<T>(info));
		else right.insert(info);
	}
}
