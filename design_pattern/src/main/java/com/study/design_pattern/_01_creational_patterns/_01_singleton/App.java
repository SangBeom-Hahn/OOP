package com.study.design_pattern._01_creational_patterns._01_singleton;

import java.lang.reflect.InvocationTargetException;

public class App {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Settings settings1 = Settings.INSTANCE;
        Settings settings2 = Settings.INSTANCE;
        
        System.out.println(settings1 == settings2);
    }
}
