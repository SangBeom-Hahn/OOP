package org.example;

public class Book {
    public static String A = "A";

    public String title;

    public void setTitle(String title) {
        this.title = title;
    }

    private String B = "B";

    public Book() {
    }

    public Book(String b) {
        B = b;
    }

    private void c() {
        System.out.println("C");
    }

    public int sum(int left, int right) {
        return left + right;
    }
}
