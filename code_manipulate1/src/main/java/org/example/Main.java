package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, NoSuchFieldException {
        Class<Book> bookClass = Book.class;
        Constructor<Book> constructor = bookClass.getConstructor(String.class);
        Book book = constructor.newInstance("mybook");
        System.out.println(book);

        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book);
    }
}