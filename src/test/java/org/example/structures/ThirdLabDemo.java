package org.example.structures;

import org.example.Minion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ThirdLabDemo {
    private MyStack<Minion> minionStack;
    private MyLinkedList<Minion> minionLinkedList;

    @BeforeEach
    public void populateCollections() {
        minionStack = new MyStack<>(5);
        minionLinkedList = new MyLinkedList<>();


        Minion[] minions = new Minion[]{
                new Minion("Jeb", "Worker", 1000000),
                new Minion("Pablo", "Dealer", 12000),
                new Minion("Stierlitz", "Soivet spy", 10),
                new Minion("Gringo", "American", 14),
                new Minion("Bob", "Wrench Master", 15),
                new Minion("Gabe", "Steam dada", 15),
                new Minion("Sus", "Traitor", 17),
                new Minion("Bob", "Tech", 100),
                new Minion("Gleb", "Student", 120),
                new Minion("Todler", "Baby", 0),
        };

        for (Minion minion : minions) {
            minionStack.push(minion);
            minionLinkedList.addLast(minion);
        }
    }

    @Test
    void stackDemo() {
        System.out.println("==Изначальное состояние стэка==");
        System.out.println(minionStack);
        System.out.println("Размер: " + minionStack.size());
        Minion test = new Minion("Тест", "Тест", 10000);
        System.out.println("Добавим миньона: " + test);
        minionStack.push(test);
        System.out.println("==Стэк после добавления миньона==");
        System.out.println(minionStack);
        System.out.println("Размер: " + minionStack.size());
        System.out.println("==Заберем верхний элемент из стэка==");
        System.out.println("==Полученный элемент==" + minionStack.pop());
        System.out.println("==Состояние стэка==");
        System.out.println(minionStack);
        System.out.println("Размер: " + minionStack.size());
        System.out.println();
        System.out.println("==Проверка итераторов Связанного списка и стэка==");
        System.out.println("Проверка для стэка");
        for (Minion minion : minionStack) {
            System.out.println("Значение метода hasNext(): " + "true");
            System.out.println("Значение метода next(): " + minion);
        }
        System.out.println("Значение метода hasNext(): " + "false");
        System.out.println("Проверка для связанного списка");
        for (Minion minion: minionLinkedList) {
            System.out.println("Значение метода hasNext(): " + "true");
            System.out.println("Значение метода next(): " + minion);
        }
        System.out.println("Значение метода next(): " + "false");
        System.out.println();
        System.out.println("Проверка сортировки связанного списка и стека");
        System.out.println("==Изначальное состояние связанного списка");
        System.out.println(minionLinkedList);
        System.out.println("==Отсортированный связанный список по именам миньонов");
        minionLinkedList.sort(new Minion.NameComparator());
        System.out.println(minionLinkedList);
        System.out.println("==Изначальное состояние стэка==");
        System.out.println(minionStack);
        minionStack.sort(new Minion.NameComparator());
        System.out.println("==Отсортированный стэк по имени миньонов");
        System.out.println(minionStack);
        System.out.println("==Отсортированный LinkedList по гласным в наименовании работы, возрасту, длине имени");
        minionLinkedList.sort(new Minion.AgeComparator());
        System.out.println(minionLinkedList);
    }
}