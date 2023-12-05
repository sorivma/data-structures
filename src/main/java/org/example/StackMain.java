package org.example;

import org.example.structures.arrays.MyStack;

import java.util.Iterator;
import java.util.Random;

public class StackMain {
    private static final String[] jobs = {"Astroneer", "Tesla SEO", "Billionair"};
    private static final String[] names = {"Bob", "Jeb", "Linus", "Ben", "Archer"};
    public static MyStack<Minion> getMinions(int size) {
        MyStack<Minion> minions = new MyStack<>(5);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            minions.push(new Minion(names[random.nextInt(names.length)],
                    jobs[random.nextInt(jobs.length)],
                    10+i));
        }
        return minions;
    }

    public static void main(String[] args) {
        MyStack<Minion> minions = getMinions(10);
        System.out.println("==My minions==");
        System.out.println(minions);
        System.out.println("Size: " + minions.size());
        System.out.println("==Peek==");
        System.out.println("Peeked: " + minions.peek());
        System.out.println("==Pop==");
        System.out.println(minions.pop());
        System.out.println("==Poped stack: " + minions);

        System.out.println("==Let`s iterate==");
        Iterator<Minion> iterator = minions.iterator();
        while (iterator.hasNext()) {
            System.out.println("do i have next?: " + true);
            System.out.println("next element: " + iterator.next());
        }
        System.out.println("do i have next?: " + false);

        MyStack<Minion> unsortedStack = getMinions(10);
        System.out.println("==Unsorted stack==");
        System.out.println(minions);
        System.out.println("==Sorted Stack==");
        minions.sort(new Minion.NameComparator());
        System.out.println(minions);
    }
}
