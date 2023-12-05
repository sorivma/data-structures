package org.example;

import org.example.structures.heap.MaxBinHeap;

public class HeapMain {
    private static final MaxBinHeap<Minion> minions = new MaxBinHeap<>();

    public static void fillHeap() {
        minions.add(new Minion("Stuart", "Barber", 1));
        minions.add(new Minion("Dave", "Barber", 5));
        minions.add(new Minion("Jerry", "Barber", 4));
        minions.add(new Minion("Kevin", "Barber", 2));
        minions.add(new Minion("Bob", "Barber", 3));
    }

    public static void main(String[] args) {
        fillHeap();
        System.out.println(minions);
    }
}
