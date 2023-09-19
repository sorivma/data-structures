package org.example;

public class Minion {
    private final String name;
    private final String job;

    public Minion(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Minion{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
