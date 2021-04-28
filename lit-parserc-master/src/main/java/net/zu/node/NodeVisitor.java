package net.zu.node;


public interface NodeVisitor<T> {
    T visit(Node node);
}
