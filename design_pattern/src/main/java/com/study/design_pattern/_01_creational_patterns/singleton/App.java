package com.study.design_pattern._01_creational_patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Settings settings1 = Settings.getInstance();
        Settings settings2 = Settings.getInstance();
        
        System.out.println(settings1 == settings2);
    }
}
