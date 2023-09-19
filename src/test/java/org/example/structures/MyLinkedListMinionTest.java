package org.example.structures;

import org.example.Minion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

public class MyLinkedListMinionTest {
    private MyLinkedList<Minion> minions;
    private final int initialSize = 6;

    @BeforeEach
    void populateMinions() {
        minions = new MyLinkedList<>();
        minions.addLast(
                new Minion("Jeb", "Worker")
        );
        minions.addLast(
                new Minion("Bob", "Hooker")
        );
        minions.addLast(
                new Minion("Filter", "Grabber")
        );
        minions.addLast(
                new Minion("Deb", "Assistant")
        );
        minions.addLast(
                new Minion("Ben", "Helper")
        );
        minions.addLast(
                new Minion("Kirk", "Useless")
        );
    }

    @Test
    void testSize() {
        assertEquals(initialSize, minions.size());
        minions.addLast(new Minion(
                "Mad", "Wrench"
        ));
        assertEquals(initialSize + 1, minions.size());

        minions.remove(0);
        assertEquals(initialSize, minions.size());
    }

    @Test
    void testAddFirstAndLast() {
        Minion first = new Minion(
                "First", "Tester"
        );
        Minion second = new Minion(
                "Second", "Tester"
        );

        minions.addFirst(first);
        minions.addLast(second);
        System.out.println(minions);

        assertEquals(first, minions.firtst());
        assertEquals(second, minions.last());
    }

    @Test
    void testInsertAndGet() {
        Minion tester = new Minion(
                "Tester", "Tester"
        );
        System.out.println(minions);
        minions.insert(4, tester);
        System.out.println(minions);

        assertEquals(initialSize+1, minions.size());
        assertEquals(tester, minions.get(4));
    }

    @Test
    void testRemove() {
        System.out.println(minions);
        minions.remove(0);
        minions.remove(0);
        minions.remove(0);
        minions.remove(0);
        System.out.println(minions);

        assertEquals(initialSize-4, minions.size());
    }

    @Test
    void updateTest() {
        System.out.println(minions);
        Minion elon = new Minion("Elon Mask", "Tesla CEO");
        minions.update(0, elon);
        System.out.println(minions);
        assertEquals(elon, minions.firtst());
    }

    @Test
    void testExceptions() {
        assertThrowsExactly(IndexOutOfBoundsException.class, this::provokeUpdate);
        assertThrowsExactly(IndexOutOfBoundsException.class, this::provokeDelete);
        assertThrowsExactly(IndexOutOfBoundsException.class, this::provokeFind);
    }

    void provokeUpdate() {
        minions.update(1000000, new Minion("JEB", "Minecraft Lead Dev"));
    }

    void provokeDelete() {
        minions.remove(10000000);
    }

    void provokeFind () {
        minions.get(10000000);
    }


}
