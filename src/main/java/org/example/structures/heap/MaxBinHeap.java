package org.example.structures.heap;

import java.util.ArrayList;

public class MaxBinHeap <E extends Comparable<E>> implements Heap<E>{
    private final ArrayList<E> elements;

    public MaxBinHeap() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(E element) {
        elements.add(element);
        this.heapifyUp();
    }

    private void heapifyUp() {
        int index = elements.size() - 1;
        while (index > 0 && elements.get(index).compareTo(elements.get(parent(index))) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    private void swap(int index1, int index2) {
        E temp = elements.get(index1);
        elements.set(index1, elements.get(index2));
        elements.set(index2, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    @Override
    public E peek() {
        return elements.get(0);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (E element : elements) {
            builder.append(element).append(" ");
        }

        return builder.toString().trim();
    }
}
