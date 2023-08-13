package com.study.design_pattern._01_creational_patterns._02_factorymethod._02_after;


public class WhiteShipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        return new Whiteship();
    }
}
