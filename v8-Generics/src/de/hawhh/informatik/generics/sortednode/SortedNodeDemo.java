package de.hawhh.informatik.generics.sortednode;

import static util.Printer.*;
public class SortedNodeDemo {
	
	public static void main(String[] args) {
		
	NodeI<String> node = new SortedNode<String>("hier");
	node.insert("steh");
	node.insert("ich");
	node.insert("nun");
	node.insert("ich");
	node.insert("armer");
	node.insert("tor");	
	node.insert("und");
	node.insert("bin");
	node.insert("so");
	node.insert("klug");
	node.insert("als");
	node.insert("jeh");
	node.insert("zuvor");
	p(node);
	
	node = new Node<String>("eins");
	node.insert("eins");
	node.insert("zwei");
	node.insert("drei");
	node.insert("fünf");
	node.insert("vier");
	p(node);
	
	Node<String> node1 = new SortedNode<String>("hier");
	
	// Typargumente müssen Comparable sein
	SortedNode<String> sns;
	SortedNode<Integer> sni;
	SortedNode<Double> snd; 
//	SortedNode<Object> sno;   // Fehler
	}
}
