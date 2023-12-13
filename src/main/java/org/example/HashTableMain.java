package org.example;

import org.example.structures.hashtable.HashTable;
import org.example.structures.hashtable.KeyValue;
import org.example.structures.hashtable.util.SHA256String;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class HashTableMain {
    private final static HashTable<String, String> example = new HashTable<>();
    private final static HashTable<SHA256String, String> sha256Example = new HashTable<>();
    private static final String CHARACTERS =
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!-=./";

    public static String generateRandomKey(int length) {
        StringBuilder randomKey = new StringBuilder(length);
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            randomKey.append(CHARACTERS.charAt(randomIndex));
        }

        return randomKey.toString();
    }

    public static void populateTable(int size) {
        for (int i = 0; i < size; i++) {
            SecureRandom random = new SecureRandom();
            example.add(generateRandomKey(5), "Value" + i);
        }
    }

    public static void populateTableSHA256(int size) {
        for (int i = 0; i < size; i++) {
            SecureRandom random = new SecureRandom();
            sha256Example.add(new SHA256String(generateRandomKey(random.nextInt(15,25)) + i), "Value" + i);
        }
    }

    public static void main(String[] args) {
        populateTable(30_000);
        for (KeyValue<String, String> entry : example) {
            System.out.println(entry);
        }
        System.out.println("Collision check with default hashcode");
        System.out.println("===========");
        System.out.println("Hash Table size:" + example.size());
        System.out.println("===========");
        System.out.println("Hash Table capacity:" + example.capacity());
        System.out.println("===========");
        System.out.println("Collision count: " + example.collisionCount());
        System.out.println("===========");
        System.out.println("Second collision count: " + example.getCollisions());
//        System.out.println("Collision check with sha256 hashcode");
//        populateTableSHA256();
//        System.out.println("SHA256 Key collision count: " + sha256Example.collisionCount());
//        for (int round = 0; round < 30_000; round += 1000) {
//            for (int i = 0; i < 5; i++) {
//                populateTable(round);
//                populateTableSHA256(round);
//            }
//            System.out.println(example.capacity());
//            System.out.println(sha256Example.capacity());
//            System.out.println("NUMBER: " + round);
//            System.out.println();
//            example.clear();
//            sha256Example.clear();
//        }
    }
}
