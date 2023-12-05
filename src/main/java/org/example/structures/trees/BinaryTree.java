package org.example.structures.trees;

import java.util.List;
import java.util.function.Consumer;

public interface BinaryTree<E> {
    E getValue();

    BinaryTree<E> getLeft();
    BinaryTree<E> getRight();
    void setKey(E key);
    String asIndentedPreOrder(int indent);
    List<BinaryTree<E>> preOrder();
    List<BinaryTree<E>> inOrder();
    List<BinaryTree<E>> postOrder();
    void bfsTraversal();
    void dfsTraversal();
    void forEachInOrder(Consumer<E> consumer);
    void print();
}
