package org.example;

public class Target implements Runnable {

    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    @Override
    public void run() {
        increment();
        System.out.println("After increment" + Thread.currentThread().getName() + " " + count);
        decrement();
        System.out.println("After decrement" + Thread.currentThread().getName() + " " + count);
    }
}
