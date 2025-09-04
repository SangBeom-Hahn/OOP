package org.example;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        Target target = new Target();
        for (int i = 0; i < 3; i++) {
            executorService.execute(target);
        }
    }
}