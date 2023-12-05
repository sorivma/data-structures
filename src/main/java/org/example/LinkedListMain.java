package org.example;

import org.example.structures.arrays.MyLinkedList;

import java.util.Random;

public class LinkedListMain {
    private static String[] jobs = {"Astroneer", "Tesla SEO", "Billionair"};
    private static String[] names = {"Bob", "Jeb", "Linus", "Ben", "Archer"};
    public static MyLinkedList<Minion> getMinions(int size) {
        MyLinkedList<Minion> minions = new MyLinkedList<>();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            minions.addFirst(new Minion(names[random.nextInt(names.length)],
                    jobs[random.nextInt(jobs.length)],
                    10+i));
        }
        return minions;
    }

    public static void main(String[] args) {
        MyLinkedList<Minion> minions = getMinions(10);
        System.out.println("==My minions==");
        System.out.println(minions);
        System.out.println("==Delete first==");
        minions.removeFirst();
        System.out.println(minions);
        System.out.println("==Delete last");
        minions.removeLast();
        System.out.println(minions);
        System.out.println("==Get middle==");
        System.out.println(minions.get(minions.size() / 2));
    }
}
