package com.example.code_manipulate2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void BookTest() {
        Class<Book> bookClass = Book.class;
    
        Book book = new Book();
        Arrays.stream(bookClass.getDeclaredFields()).forEach(field -> {
            try {
                field.setAccessible(true);
                System.out.printf("%s %s\n", field, field.get(book));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
    }
}