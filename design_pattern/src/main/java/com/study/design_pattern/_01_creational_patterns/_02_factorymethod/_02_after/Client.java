package com.study.design_pattern._01_creational_patterns._02_factorymethod._02_after;

public class Client {
    public static void main(String[] args) {
        Client client = new Client();
        client.print(new WhiteShipFactory(), "whiteship", "hsb@mail.com");
        client.print(new BlackShipFactory(), "blackship", "hsb@mail.com");
    }
    
    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
