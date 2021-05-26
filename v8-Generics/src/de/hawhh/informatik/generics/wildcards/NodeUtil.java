package de.hawhh.informatik.generics.wildcards;

import de.hawhh.informatik.generics.sortednode.Node;

public class NodeUtil {
	
	public int nodesCount(Node<?> n) {
		if (n == null)
			return 0;
		else
			return 1 + nodesCount(n.getLeft()) + nodesCount(n.getRight());
	}

}
