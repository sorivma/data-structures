package org.example;

import org.example.structures.trees.BinaryTreeImpl;
import org.example.structures.trees.SearchBinaryTree;
import org.example.structures.trees.SearchTree;

import java.util.List;

public class Main {
    public static BinaryTreeImpl<Integer> prepareTree() {
        return new BinaryTreeImpl<>(
                new BinaryTreeImpl<>(
                        new BinaryTreeImpl<>(
                                null,
                                null,
                                4
                        ),
                        new BinaryTreeImpl<>(
                                null,
                                null,
                                4),
                        13),
                new BinaryTreeImpl<>(
                        new BinaryTreeImpl<>(
                                null,
                                null,
                                16
                        ),
                        new BinaryTreeImpl<>(
                                null,
                                null,
                                17
                        ),
                        9),
                5);
    }

    public static void main(String[] args) {
        BinaryTreeImpl<Integer> binaryTree = prepareTree();
        System.out.println("Первое задание");
        System.out.println("Так выглядит дерево");
        binaryTree.print();
        System.out.println("asIndentedPreOrder до уровня 2");
        System.out.println(binaryTree.asIndentedPreOrder(2));
        System.out.println("asIndentedPreOrder до уровня 3");
        System.out.println(binaryTree.asIndentedPreOrder(3));
        System.out.println("Дерево в preOrder порядке");
        binaryTree.preOrder().forEach(tree -> {
            tree.print();
            System.out.println("===================");
        });
        System.out.println("Дерево в inOrder порядке");
        binaryTree.inOrder().forEach(tree -> {
            tree.print();
            System.out.println("===================");
        });
        System.out.println("Дерево в postOrder порядке");
        binaryTree.postOrder().forEach(tree -> {
            tree.print();
            System.out.println("===================");
        });
        System.out.println("Печать элементов с помощью consumer forEachInOrder");
        binaryTree.forEachInOrder(System.out::println);
        System.out.println("Второе задание, печать в ширину и глубину");
        System.out.println("Так выглядит дерево");
        binaryTree.print();
        System.out.println("===BFS===");
        binaryTree.bfsTraversal();
        System.out.println("===DFS===");
        binaryTree.dfsTraversal();

        System.out.println("Третье задание");
        System.out.println("Так выглядит дерево поиска");
        SearchTree<Integer> searchTree = new SearchTree<>();
        searchTree.insert(15);
        searchTree.insert(83);
        searchTree.insert(12);
        searchTree.insert(14);
        searchTree.insert(51);
        searchTree.insert(-4);
        searchTree.insert(6);
        searchTree.print();
//        int num = -5;
//        System.out.println("Результат проверки на присутствие " + num + " в дереве: " + searchTree.contains(num));
//        System.out.println("Так выгядит найденное поддерево для " + num);
//        searchTree.search(num).print();
//        System.out.println("Спец. задание - найти дубликаты в списке чисел с помощью дерева поиска");
        List<Integer> integers = List.of(1, 2, 4, 4, 6, 7, 9, 9, 7, 7, 5, 5, 4, 4, 3, 3, 1, 1, 2, 99, 25);
        System.out.println("Даны числа: " + integers);




        SearchBinaryTree<Integer> searchBinaryTree = new SearchTree<>();
        for (int number : integers) {
            if (searchBinaryTree.contains(number)) {
                System.out.println("Найден дубликат: " + number);
            }
            searchBinaryTree.insert(number);
        }
    }
}