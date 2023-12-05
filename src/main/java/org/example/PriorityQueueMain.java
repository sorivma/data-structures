package org.example;

import org.example.structures.heap.PriorityQueue;

public class PriorityQueueMain {
    private final static PriorityQueue<Minion> priorityQueue = new PriorityQueue<>();

    public static void initQueue() {
        priorityQueue.add(new Minion("Bob", "Builder", 20));
        priorityQueue.add(new Minion("Stuart", "Builder", 18));
        priorityQueue.add(new Minion("Kevin", "Builder", 19));
        priorityQueue.add(new Minion("Dave", "Builder", 21));
        priorityQueue.add(new Minion("Jerry", "Builder", 22));
        priorityQueue.add(new Minion("Tim", "Builder", 23));
        priorityQueue.add(new Minion("Mark", "Builder", 24));
        priorityQueue.add(new Minion("Phil", "Builder", 25));
        priorityQueue.add(new Minion("Carl", "Builder", 26));
        priorityQueue.add(new Minion("Tom", "Builder", 27));
        priorityQueue.add(new Minion("John", "Builder", 120));
        priorityQueue.add(new Minion("Jeb", "Builder", 10));
    }

    public static void main(String[] args) {
        initQueue();
        System.out.println("==My priority queue==");
        System.out.println(priorityQueue);
        System.out.println("==Peek==");
        System.out.println(priorityQueue.peek());
        System.out.println("==Poll==");
        System.out.println(priorityQueue.poll());
        System.out.println("==Queue after poll==");
        System.out.println(priorityQueue);
        System.out.println("==Poll all==");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }
}
