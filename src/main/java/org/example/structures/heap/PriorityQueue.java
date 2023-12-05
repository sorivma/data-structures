package org.example.structures.heap;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue <E extends Comparable<E>> implements AbstractQueue<E>{
    private final List<E> heapList;

    public PriorityQueue() {
        heapList = new ArrayList<>();
    }

    @Override
    public int size() {
        return heapList.size();
    }

    @Override
    public void add(E element) {
        heapList.add(element);
        heapifyUp(heapList.size() - 1);
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return heapList.get(0);
    }

    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }

        E min = heapList.get(0);
        heapList.set(0, heapList.get(heapList.size() - 1));
        heapList.remove(heapList.size() - 1);
        heapifyDown(0);

        return min;
    }

    public boolean isEmpty() {
        return heapList.isEmpty();
    }

    private void heapifyUp(int index) {
        while (hasParent(index) && getParent(index).compareTo(heapList.get(index)) < 0) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void heapifyDown(int index) {
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index).compareTo(getLeftChild(index)) > 0) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (heapList.get(index).compareTo(heapList.get(smallerChildIndex)) > 0) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < heapList.size();
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < heapList.size();
    }

    private E getParent(int index) {
        return heapList.get(getParentIndex(index));
    }

    private E getLeftChild(int index) {
        return heapList.get(getLeftChildIndex(index));
    }

    private E getRightChild(int index) {
        return heapList.get(getRightChildIndex(index));
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private void swap(int index1, int index2) {
        E temp = heapList.get(index1);
        heapList.set(index1, heapList.get(index2));
        heapList.set(index2, temp);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("PriorityQueue");
        for (E element : heapList) {
            builder.append("\n").append("   ").append(element);
        }

        return builder.toString().trim();
    }
}
