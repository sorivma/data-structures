package org.example.structures.heap;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeMaxBinHeap<E extends Comparable<E>> implements Heap<E> {
    private final MaxBinHeap<E> heap;

    public MergeMaxBinHeap() {
        this.heap = new MaxBinHeap<>();
    }

    @Override
    public int size() {
        return heap.size();
    }

    @Override
    public void add(E element) {
        heap.add(element);
    }

    @Override
    public E peek() {
        return heap.peek();
    }

    private void heapifyDown(ArrayList<E> mergedHeap, int heapifyIndex) {
        int leftChildIndex = 2 * heapifyIndex + 1;
        int rightChildIndex = 2 * heapifyIndex + 2;

        int largestElementIndex = heapifyIndex;

        if (leftChildIndex < mergedHeap.size() &&
                mergedHeap.get(leftChildIndex)
                        .compareTo(mergedHeap
                                .get(largestElementIndex)) > 0) {
            largestElementIndex = leftChildIndex;
        }

        if (rightChildIndex < mergedHeap.size() && mergedHeap
                .get(rightChildIndex)
                .compareTo(mergedHeap
                        .get(largestElementIndex)) > 0) {
            largestElementIndex = rightChildIndex;
        }

        if (largestElementIndex != heapifyIndex) {
            Collections.swap(mergedHeap, heapifyIndex, largestElementIndex);
            heapifyDown(mergedHeap, largestElementIndex);
        }
    }

    public Heap<E> sortMerge(MaxBinHeap<E> otherHeap) {
        Long startTime = System.nanoTime();
        ArrayList<E> resultElements = otherHeap.elements;
        resultElements.addAll(heap.elements);
        resultElements.sort(Comparator.naturalOrder());
        Long endTime = System.nanoTime();
        System.out.println("Merge sort time: " + (endTime - startTime));
        return new MaxBinHeap<>(resultElements);
    }
    public Heap<E> merge(MaxBinHeap<E> otherHeap) {
        Long startTime = System.nanoTime();
        ArrayList<E> resultElements = otherHeap.elements;
        resultElements.addAll(heap.elements);
        Long endTime = System.nanoTime();

        int lastNonLeafIndex = (resultElements.size() - 2) / 2;

        System.out.println(resultElements);
        for (int i = lastNonLeafIndex; i >= 0; i--) {
            heapifyDown(resultElements, i);
            System.out.println(resultElements);
        }

        System.out.println("Merge time: " + (endTime - startTime));

        return new MaxBinHeap<>(resultElements);
    }



    @Override
    public String toString() {
        return heap.toString();
    }
}
