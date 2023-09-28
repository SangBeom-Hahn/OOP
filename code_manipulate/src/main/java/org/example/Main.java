package org.example;

public class Main {
    Book book = new Book();
    public static void main(String[] args) {
        ClassLoader classLoader = Main.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());
    }
}