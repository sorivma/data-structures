package org.example.structures.arrays;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyStack<T> implements Iterable<T> {
    private T[] content;
    private int contentPointer;
    private int capacity;
    private final MyStackIterator myStackIterator = new MyStackIterator();

    private class MyStackIterator implements Iterator<T> {
        int cursor;

        @Override
        public boolean hasNext() {
            return cursor > 0;
        }

        @Override
        public T next() {
            return content[--cursor];
        }

        public void setCursor(int cursor) {
            this.cursor = cursor;
        }
    }

    public MyStack(int capacity) {
        //noinspection unchecked
        content = (T[]) new Object[capacity];
        contentPointer = -1;
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return contentPointer == -1;
    }

    public boolean isFull() {
        return contentPointer == capacity - 1;
    }

    public void push(T t) {
        if (isFull()) {
            this.capacity *= 2;
            @SuppressWarnings("unchecked")
            T[] extendedContent = (T[]) new Object[capacity];
            System.arraycopy(content, 0, extendedContent, 0, size());
            content = extendedContent;
        }

        content[++contentPointer] = t;
    }

    public void sort(Comparator<T> comparator) {
        for (int i = 0; i < size(); i++) {
            for (int j = i + 1; j < size(); j++) {
                if (comparator.compare(content[i], content[j]) >= 0) {
                    T temp = content[i];
                    content[i] = content[j];
                    content[j] = temp;
                }
            }
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return content[contentPointer--];
    }

    public T peek() {
        return content[contentPointer];
    }

    public Integer size() {
        return contentPointer + 1;
    }

    @Override
    public Iterator<T> iterator() {
        myStackIterator.setCursor(contentPointer + 1);
        return myStackIterator;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T t : this) {
            builder.append(t.toString()).append("\n");
        }
        return builder.toString();
    }
}
