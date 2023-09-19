package org.example.structures;

import org.jetbrains.annotations.Nullable;

public class MyLinkedList<T> {
    private int size = 0;
    private Node<T> first;
    private Node<T> last;

    public MyLinkedList() {
    }

    public void addFirst(T t) {
        Node<T> newNode = new Node<>(t);
        // Указатель на предыдущую
        newNode.previous = null;
        // Инкрементируем размер
        size++;
        // Если первой ноды нет то инициализируем её
        if (first == null) {
            first = newNode;
            last = first;
            return;
        }

        // Если первая нода есть то новая нода становится ей
        first.previous = newNode;
        newNode.next = first;
        first = newNode;
    }

    public void addLast(T t) {
        Node<T> newNode = new Node<>(t);
        // Указатель на следующую ноду у последней всегда null
        newNode.next = null;
        size++;
        // Если первой ноды нет то новая последняя становится ей
        if (first == null) {
            last = newNode;
            first = newNode;
            return;
        }

        // Если последней ноды нет то она просто становится ей
        if (last == null) {
            newNode.previous = first;
            last = newNode;
            return;
        }

        // Если она есть то она заменяет ее
        newNode.previous = last;
        last.next = newNode;
        last = newNode;
    }

    public void insert(int pos, T t) {

        checkValidPos(pos);

        // Если пользователь использует метод не по назначению
        if (pos == 0) {
            addFirst(t);
            return;
        }

        Node<T> newNode = new Node<>(t);
        if (pos == size - 1) {
            newNode.previous = last.previous;
            last.previous.next = newNode;
            newNode.next = last;
            return;
        }

        // Ищем ноду с нужным индексом
        Node<T> node = findNode(pos);

        // Вставляем со смещением направо
        Node<T> next = node.next;
        newNode.next = next;
        newNode.previous = node;
        node.next = newNode;
        next.previous = newNode;

        size++;
    }

    private boolean isValidPos(int pos) {
        return pos >= 0 && pos < size;
    }

    private void checkValidPos(int pos) {
        if (!isValidPos(pos)) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void removeFirst() {
        if (size == 1) {
            first = null;
            last = null;
            size = 0;
            return;
        }

        first = first.next;
        first.previous = null;
        size--;
    }

    public void removeLast() {
        if (last != null) {
            last = last.previous;
            last.next = null;
            size--;
            return;
        }

        size = 0;
    }

    public void remove(int pos) {
        checkValidPos(pos);

        if (pos == 0) {
            removeFirst();
            return;
        }

        if (pos == size - 1) {
            removeLast();
            return;
        }

        Node<T> node = findNode(pos + 1);
        Node<T> prev = node.previous;
        Node<T> next = node.next;
        next.previous = prev;
        prev.next = next;

        size--;
    }

    public T get(int pos) {
        checkValidPos(pos);

        if (pos == 0) {
            return first.item;
        }

        if (pos == size - 1) {
            return last.item;
        }

        return findNode(pos+1).item;
    }

    public void update(int pos, T t) {
        checkValidPos(pos);

        if (pos == 0) {
            first.item = t;
            return;
        }

        if (pos == size - 1) {
            last.item = t;
            return;
        }

        findNode(pos+1).item = t;
    }

    public int size() {
        return size;
    }

    @Nullable
    public T firtst() {
        if (first != null) {
            return first.item;
        }
        return null;
    }

    @Nullable
    public T last() {
        if (last != null) {
            return last.item;
        }
        return null;
    }

    @Override
    public String toString() {
        Node<T> node = first;
        StringBuilder builder = new StringBuilder();
        builder.append("Linked List = {\n");
        while (node != null) {
            builder.append("    ").append(node.item).append("\n");
            node = node.next;
        }
        builder.append("};");
        return builder.toString();
    }

    private Node<T> findNode(int index) {
        int posCount = 1;
        Node<T> nodeAtPosition = first;

        while (posCount != index && nodeAtPosition != null) {
            posCount++;
            nodeAtPosition = nodeAtPosition.next;
        }
        return nodeAtPosition;
    }


    private static class Node<T> {
        public Node(T item) {
            this.item = item;
        }

        Node<T> next;
        Node<T> previous;
        T item;
    }
}
