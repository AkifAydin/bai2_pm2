package de.hawhh.informatik.generics.motivation.node;

import static util.Printer.*;

public class NodeDemo {

	public static void main(String[] args) {
		Node n6 = new Node(6,null,null);
		Node n5 = new Node(5, null, n6);
		Node n4 = new Node(4,null,null);
		Node n3 = new Node(3,null,null);
		Node n2 = new Node(2, n4, n5);
		Node n1 = new Node(1, n2, n3);

		Integer sum = (Integer)n1.getInfo();
		n2.setInfo("No longer Integer");
		
		for (Node n: n1.children()) {
			sum += (Integer)n.getInfo();
		}
		p(sum);
	}
}
