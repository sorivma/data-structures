package org.example.structures.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class BinaryTreeImpl<T> implements BinaryTree<T>{
    private BinaryTreeImpl<T> left;
    private BinaryTreeImpl<T> right;
    private T value;

    public BinaryTreeImpl(BinaryTreeImpl<T> left, BinaryTreeImpl<T> right, T value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }

    @Override
    public T getValue() {
        return this.value;
    }

    @Override
    public BinaryTree<T> getLeft() {
        return this.left;
    }

    @Override
    public BinaryTree<T> getRight() {
        return this.right;
    }

    @Override
    public void setKey(T key) {
        this.value = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder builder = new StringBuilder();
        recursivePreOrder(0, this, builder, "", indent);
        return builder.toString();
    }

    private void recursivePreOrder(int level, BinaryTreeImpl<T> rootNode, StringBuilder builder, String prefix,
                                   int indent) {
        if (rootNode == null || level >= indent) {
            return;
        }

        builder.append(new String(new char[level]).replace("\0", " "))
                .append(rootNode.value)
                .append(prefix)
                .append("\n");

        recursivePreOrder(level + 1, rootNode.left, builder, " left", indent);
        recursivePreOrder(level + 1, rootNode.right, builder, " right", indent);
    }

    @Override
    public List<BinaryTree<T>> preOrder() {
        List<BinaryTree<T>> trees = new ArrayList<>();

        recursivePreOrder(trees, this);

        return trees;
    }

    private void recursivePreOrder(List<BinaryTree<T>> result, BinaryTreeImpl<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        result.add(rootNode);

        recursivePreOrder(result, rootNode.left);
        recursivePreOrder(result, rootNode.right);
    }

    @Override
    public List<BinaryTree<T>> inOrder() {
        List<BinaryTree<T>> result = new ArrayList<>();

        recursiveInOrder(result, this);

        return result;
    }

    private void recursiveInOrder(List<BinaryTree<T>> result, BinaryTreeImpl<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        recursiveInOrder(result, rootNode.left);
        result.add(rootNode);
        recursiveInOrder(result, rootNode.right);
    }

    @Override
    public List<BinaryTree<T>> postOrder() {
        List<BinaryTree<T>> result = new ArrayList<>();

        recursivePostOrder(result, this);

        return result;
    }

    private void recursivePostOrder(List<BinaryTree<T>> result, BinaryTree<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        recursivePostOrder(result, rootNode.getLeft());
        recursivePostOrder(result, rootNode.getRight());
        result.add(rootNode);
    }


    @Override
    public void bfsTraversal() {
        Queue<BinaryTree<T>> queue = new LinkedList<>();
        queue.add(this);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                BinaryTree<T> node = queue.poll();
                System.out.println(node.getValue() + " ");

                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            }
        }
    }

    @Override
    public void dfsTraversal() {
        dfsTraversal(this);
    }

    private void dfsTraversal(BinaryTree<T> rootNode) {
        if (rootNode == null) {
            return;
        }

        System.out.println(rootNode.getValue() + " ");

        dfsTraversal(rootNode.getLeft());
        dfsTraversal(rootNode.getRight());
    }

    @Override
    public void forEachInOrder(Consumer<T> consumer) {
        applyInOrder(consumer, this);
    }

    private void applyInOrder(Consumer<T> consumer, BinaryTree<T> rootNode) {
        if (rootNode == null) {
            return;
        }
        applyInOrder(consumer, rootNode.getLeft());
        consumer.accept(rootNode.getValue());
        applyInOrder(consumer, rootNode.getRight());
    }

    @Override
    public void print() {
        print("", this, false, 0);
    }

    private void print(String prefix, BinaryTree<T> node, boolean isRight, int level) {
        if (node != null) {
            print(prefix + "    ", node.getRight(), true, level + 1);
            System.out.println(prefix + node.getValue());
            print(prefix + "    ", node.getLeft(), false, level);
        }
    }
}
