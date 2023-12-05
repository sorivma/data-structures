package org.example.structures.trees;

public class SearchTree<T extends Comparable<T>> implements SearchBinaryTree<T> {
    private Node<T> rootNode;

    public SearchTree(Node<T> rootNode) {
        this.rootNode = rootNode;
    }

    public SearchTree() {
    }

    @Override
    public void insert(T element) {
        rootNode = recursiveInsert(rootNode, element);
    }

    private Node<T> recursiveInsert(Node<T> current, T value) {
        if (current == null) {
            return new Node<>(value);
        }

        if (value.compareTo(current.value) < 0) {
            current.leftChild = recursiveInsert(current.leftChild, value);
        }
        if (value.compareTo(current.value) > 0) {
            current.rightChild = recursiveInsert(current.rightChild, value);
        }

        return current;
    }

    @Override
    public boolean contains(T element) {
        return contains(rootNode, element);
    }

    private boolean contains(Node<T> root, T element) {
        if (root == null) {
            return false;
        }

        if (root.value.equals(element)) {
            return true;
        }

        return contains(root.leftChild, element) || contains(root.rightChild, element);
    }

    @Override
    public SearchBinaryTree<T> search(T element) {
        return search(rootNode, element);
    }

    private SearchBinaryTree<T> search(Node<T> root, T element) {
        if (root == null) {
            return null;
        }

        if (root.value.equals(element)) {
            return new SearchTree<>(root);
        }

        SearchBinaryTree<T> leftResult = search(root.leftChild, element);
        SearchBinaryTree<T> rightResult = search(root.rightChild, element);

        if (leftResult != null) {
            return leftResult;
        }

        return rightResult;
    }

    @Override
    public Node<T> getRoot() {
        return rootNode;
    }

    @Override
    public Node<T> getLeft() {
        return rootNode.leftChild;
    }

    @Override
    public Node<T> getRight() {
        return rootNode.rightChild;
    }

    @Override
    public T getValue() {
        return rootNode.value;
    }

    @Override
    public void print() {
        print("", rootNode, false);
    }

    private void print(String prefix, Node<T> node, boolean isRight) {
        if (node != null) {
            print(prefix + "   ", node.rightChild, true);
            if (prefix.equals("")) {
                System.out.println(prefix + node.value);
            }
            if (isRight) {
                System.out.println(prefix + node.value);
                System.out.println(prefix.substring(0, prefix.length()-1) + "/");
            }
            if (!isRight && !prefix.equals("")) {
                System.out.println(prefix.substring(0, prefix.length()-1) + "\\");
                System.out.println(prefix  + node.value);
            }
            print(prefix + "   ", node.leftChild, false);
        }
    }
}
