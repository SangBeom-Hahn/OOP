package com.study.design_pattern._01_creational_patterns._03_abstract_factory._02_after;

public class WhiteshipPartsFactory implements ShipPartsFactory{
    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }
    
    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }
}
