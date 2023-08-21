package com.study.design_pattern._02_structural_patterns._11_flyweight._02_after;

public class Character {
    String color;
    private char value;
    Font font;
    
    public Character(char value, String color, Font font) {
        this.color = color;
        this.value = value;
        this.font = font;
    }
}
