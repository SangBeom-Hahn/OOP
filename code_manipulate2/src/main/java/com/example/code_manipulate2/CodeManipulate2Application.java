package com.example.code_manipulate2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeManipulate2Application {
    
    public static void main(String[] args) throws ClassNotFoundException {
        Class<Book> bookClass = Book.class;
    
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();
    
        Class<?> aClass1 = Class.forName("com.example.code_manipulate2.Book");
    
        SpringApplication.run(CodeManipulate2Application.class, args);
    }
    
}
