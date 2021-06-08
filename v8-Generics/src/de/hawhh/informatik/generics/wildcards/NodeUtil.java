package de.hawhh.informatik.generics.wildcards;

import de.hawhh.informatik.generics.sortednode.Node;

public class NodeUtil {
	
	public static int nodesCount(Node<?> n) {
		if (n == null)
			return 0;
		else
			return 1 + nodesCount(n.getLeft()) + nodesCount(n.getRight());
	}

	public static int depth(Node<?> n){
		int depth = 0;
		if (n.getLeft()!=null) {
			depth = 1+ depth(n.getLeft());
		}
		if (n.getRight()!= null) {
			int rightDepth = 1+ depth(n.getRight());
			depth = Math.max(depth,rightDepth);
		}
		return depth;
	}

	public static void printTree(Node<?> n,int depth){

		if (n.getLeft()!=null) printTree(n.getLeft(), depth+1);
		indent(depth);
		System.out.println(n.getInfo());
		if (n.getRight()!=null) printTree(n.getRight(), depth+1);
	}

	private static void indent(int depth) {
		for (int i =0; i <depth; i++){
			System.out.print("-");
		}
	}

}
