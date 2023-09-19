package org.example.structures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {


    @Test
    void addFirst() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        assertEquals(1, linkedList.size());
        System.out.println(linkedList.last());
        System.out.println(linkedList.firtst());
    }

    @Test
    void addLast() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        assertEquals(1, linkedList.size());
        System.out.println(linkedList.last());
        System.out.println(linkedList.firtst());
    }

    @Test
    void addBothSizes() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.addLast(4);
        linkedList.addLast(5);
        assertEquals(5, linkedList.size());
        assertEquals(5, linkedList.last());
        assertEquals(1, linkedList.firtst());
    }

    @Test
    void removeTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(2);
        linkedList.addFirst(1);
        linkedList.addLast(3);
        assertEquals(3, linkedList.last());
        assertEquals(1, linkedList.firtst());
        linkedList.removeLast();
        assertEquals(2, linkedList.last());
        assertEquals(1, linkedList.firtst());
        linkedList.removeFirst();
        assertEquals(2, linkedList.firtst());
        linkedList.removeFirst();
        assertNull(linkedList.firtst());
    }

    @Test
    void insertTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addFirst(599);
        linkedList.addLast(600);
        // [599, 1, 600]
        linkedList.insert(1, 999);
        // [599, 999, 1, 600]
        assertEquals(600, linkedList.last());
        assertEquals(599, linkedList.firtst());
        linkedList.removeFirst();
        // [999, 1, 600]
        assertEquals(999, linkedList.firtst());

        linkedList.insert(2, 1000);
        // [999, 1, 1000, 600]
        System.out.println(linkedList);
        assertEquals(600, linkedList.last());
    }

    @Test
    void validPosTest() {
        assertThrowsExactly(IndexOutOfBoundsException.class, this::createOutOfBoundsInsert);
        assertThrowsExactly(IndexOutOfBoundsException.class, this::createOutOfBoundsRemove);
    }

    void createOutOfBoundsInsert() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.insert(10, 10);
    }

    void createOutOfBoundsRemove() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.remove(10);
    }

    @Test
    void removeAtPosTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(3);
        linkedList.addLast(2);
        linkedList.addLast(5);
        linkedList.addFirst(5);
        // [5,3,1,2,5]
        System.out.println(linkedList);
        linkedList.remove(3);
        System.out.println(linkedList);
    }

    @Test
    void testStructure() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addLast(2);
        System.out.println(linkedList);
    }

    @Test
    void getTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addFirst(2);
        linkedList.addLast(3);
        linkedList.addFirst(4);
        linkedList.addFirst(1);
        linkedList.addFirst(4);
        System.out.println(linkedList);
        assertEquals(1, linkedList.get(1));
        assertEquals(4, linkedList.get(2));
        assertEquals(4, linkedList.get(0));
    }

    @Test
    void updateTest() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addLast(1);
        linkedList.addFirst(2);
        linkedList.addLast(3);
        linkedList.addFirst(4);
        linkedList.addFirst(1);
        linkedList.addFirst(4);
        System.out.println(linkedList);
        linkedList.update(1, 100000);
        linkedList.update(2, 100000);
        linkedList.update(0, 100000);
        System.out.println(linkedList);
        assertEquals(100000, linkedList.get(1));
        assertEquals(100000, linkedList.get(2));
        assertEquals(100000, linkedList.get(0));
    }

}