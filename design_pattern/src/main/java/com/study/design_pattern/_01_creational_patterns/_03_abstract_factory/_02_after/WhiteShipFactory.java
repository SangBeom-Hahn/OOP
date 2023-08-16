package com.study.design_pattern._01_creational_patterns._03_abstract_factory._02_after;

import com.study.design_pattern._01_creational_patterns._02_factorymethod._02_after.Ship;
import com.study.design_pattern._01_creational_patterns._02_factorymethod._02_after.ShipFactory;
import com.study.design_pattern._01_creational_patterns._02_factorymethod._02_after.Whiteship;

public class WhiteShipFactory implements ShipFactory {
    
    private ShipPartsFactory shipPartsFactory;
    
    public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }
    
    @Override
    public Ship createShip() {
        Ship ship = new Whiteship();
        ship.setAnchor(shipPartsFactory.createAnchor());
        ship.setWheel(shipPartsFactory.createWheel());
        return ship;
    }
}
