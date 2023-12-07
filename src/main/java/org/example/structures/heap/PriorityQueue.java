package org.example.structures.heap;

import java.util.LinkedList;

public class PriorityQueue <E extends Comparable<E>> implements AbstractQueue<E>{
    private final LinkedList<E> list;

    public PriorityQueue() {
        list = new LinkedList<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void add(E element) {
        int index = 0;
        while (index < list.size() && element.compareTo(list.get(index)) < 0) {
            index++;
        }
        list.add(index, element);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PriorityQueue: ");
        for (E element : list) {
            builder.append("\n").append("   ").append(element);
        }
        return builder.toString();
    }
}
