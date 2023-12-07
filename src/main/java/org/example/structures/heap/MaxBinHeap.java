package org.example.structures.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxBinHeap <E extends Comparable<E>> implements Heap<E>{
    protected final ArrayList<E> elements;

    public MaxBinHeap() {
        this.elements = new ArrayList<>();
    }

    protected MaxBinHeap(ArrayList<E> elements) {
        this.elements = elements;
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public void add(E element) {
        elements.add(element);
        this.heapifyUp(elements.size() - 1);
    }

    protected void heapifyUp(int heapyfyIndex) {
        while (heapyfyIndex > 0 && elements.get(heapyfyIndex).compareTo(elements.get(parent(heapyfyIndex))) > 0) {
            swap(heapyfyIndex, parent(heapyfyIndex));
            heapyfyIndex = parent(heapyfyIndex);
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
        builder.append("MaxBinHeap: ");
        for (E element : elements) {
            builder.append("\n").append("   ").append(element);
        }

        return builder.toString().trim();
    }
}
