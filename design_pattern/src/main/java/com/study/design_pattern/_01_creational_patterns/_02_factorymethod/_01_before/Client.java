package com.study.design_pattern._01_creational_patterns._02_factorymethod._01_before;

public class Client {
    public static void main(String[] args) {
    
        Ship whiteship = ShipFactory.orderShip("Whiteship", "hsb@mail.com");
        System.out.println(whiteship);
    
        Ship blackship = ShipFactory.orderShip("Blackship", "hsb@mail.com");
        System.out.println(blackship);
    }
}
