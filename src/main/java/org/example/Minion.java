package org.example;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class Minion implements Comparable<Minion> {
    private final String name;
    private final String job;
    private final Integer age;

    public Minion(String name, String job, Integer age) {
        this.name = name;
        this.job = job;
        this.age = age;
    }

    @Override
    public int compareTo(@NotNull Minion o) {
        return this.age - o.age;
    }

    public static class NameComparator implements Comparator<Minion> {
        @Override
        public int compare(Minion o1, Minion o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    public static class JobComparator implements Comparator<Minion> {

        @Override
        public int compare(Minion o1, Minion o2) {
            return o1.job.compareTo(o2.job);
        }
    }

    //Отсортировать по количеству гласных, по количеству букв в имени, возраст по убыванию
    public static class AgeComparator implements Comparator<Minion> {

        @Override
        public int compare(Minion o1, Minion o2) {
            int sum1 = 0;
            int sum2 = 0;

            sum1 += o1.name.length();
            sum2 += o2.name.length();

            sum1 += o1.age;
            sum2 += o2.age;

            sum1 += countVowels(o1.job + o1.name);
            sum2 += countVowels(o2.job + o2.name);

            return sum1 - sum2;
        }

        private int countVowels(String name) {
            int count = 0;
            String vowels = "aeiouAEIOU";

            for (int i = 0; i < name.length(); i++) {
                if (vowels.contains(String.valueOf(name.charAt(i)))) {
                    count++;
                }
            }
            return count;
        }
    }

    @Override
    public String toString() {
        return "Minion{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", age=" + age +
                '}';
    }
}
