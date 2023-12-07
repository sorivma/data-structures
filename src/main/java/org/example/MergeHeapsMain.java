package org.example;

import org.example.structures.heap.MaxBinHeap;
import org.example.structures.heap.MergeMaxBinHeap;

public class MergeHeapsMain {
    private static final MaxBinHeap<Minion> minions = new MaxBinHeap<>();
    private static final MergeMaxBinHeap<Minion> mergeHeap = new MergeMaxBinHeap<>();

    public static void populateData() {
        minions.add(new Minion("Stuart", "Barber", 1));
        minions.add(new Minion("Dave", "Barber", 5));
        minions.add(new Minion("Jerry", "Barber", 4));
        minions.add(new Minion("Kevin", "Barber", 2));
        minions.add(new Minion("Bob", "Barber", 3));

        mergeHeap.add(new Minion("Stuart", "Barber", 25));
        mergeHeap.add(new Minion("Dave", "Barber", 15));

        mergeHeap.add(new Minion("Jerry", "Barber", 20));
        mergeHeap.add(new Minion("Kevin", "Barber", 100));
    }

    public static void main(String[] args) {
        populateData();
        System.out.println("==Minions==");
        System.out.println(minions);
        System.out.println("==Merge heap==");
        System.out.println(mergeHeap);
        System.out.println("==Merged heaps==");
        System.out.println(mergeHeap.merge(minions));
        System.out.println("==Merged sorted heaps==");
        System.out.println(mergeHeap.sortMerge(minions));
    }
}
