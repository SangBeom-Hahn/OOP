package com.study.design_pattern._01_creational_patterns._03_abstract_factory._02_after;

import com.study.design_pattern._01_creational_patterns._02_factorymethod._02_after.Ship;
import com.study.design_pattern._01_creational_patterns._02_factorymethod._02_after.ShipFactory;

public class ShipInventory {
    public static void main(String[] args) {
        ShipFactory shipFactory = new WhiteShipFactory(new WhitePartsProFactory());
        Ship ship = shipFactory.createShip();
        System.out.println(ship.getAnchor().getClass());
    }
}
