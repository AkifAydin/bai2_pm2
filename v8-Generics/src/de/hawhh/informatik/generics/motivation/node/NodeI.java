package de.hawhh.informatik.generics.motivation.node;

public interface NodeI<I> {

    I getInfo();
    void setInfo(I info);

    NodeGen<I> getLeft();

    NodeGen<I> getRight();
}
