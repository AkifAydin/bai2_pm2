package de.hawhh.informatik.generics.motivation.node;

import java.util.Arrays;

public class NodeGen<I> implements NodeI<I> {

    public static void main(String[] args) {
        NodeGen<Integer> ni0 = new NodeGen(22);
        NodeGen<Integer> ni = new NodeGen(34,
                new NodeGen<Integer>(12),
                new NodeGen<Integer>(55));

        NodeGen<Integer> n2 = ni.getLeft();

        Integer i = ni.getInfo();

        ni.setInfo(55);

    }
    private NodeGen<I> left, right;
    private I info;
    private static final int inc = 2;

    // ein innerer Knoten

    public NodeGen(I info, NodeGen<I> left, NodeGen<I> right) {
        this.info = info;
        this.left = left;
        this.right = right;
    }

    // ein Blatt
    public NodeGen(I content) {
        this(content, null, null);
    }

    public I getInfo() {
        return info;
    }

    public void setInfo(I info) {
        this.info = info;
    }

    public NodeGen<I> getLeft() {
        return left;
    }

    public NodeGen<I> getRight() {
        return right;
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
        String indent = NodeGen.indentString(depth);
        return "\n" + indent + "Node(" + info + (left == null ? "" : left.toString(depth + inc))
                + (right == null ? "" : right.toString(depth + inc)) + ")";
    }
}
