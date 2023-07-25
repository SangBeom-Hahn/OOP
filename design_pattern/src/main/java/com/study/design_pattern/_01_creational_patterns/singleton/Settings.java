package com.study.design_pattern._01_creational_patterns.singleton;

public class Settings {
    
    private static Settings instance;
    private Settings() {
    }
    
    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }
    
    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
