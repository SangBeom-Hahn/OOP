package com.study.design_pattern._01_creational_patterns._03_abstract_factory._01_before;

import com.study.design_pattern._01_creational_patterns._02_factorymethod._02_after.Ship;
import com.study.design_pattern._01_creational_patterns._02_factorymethod._02_after.ShipFactory;
import com.study.design_pattern._01_creational_patterns._02_factorymethod._02_after.Whiteship;
import com.study.design_pattern._01_creational_patterns._03_abstract_factory._02_after.WhiteAnchor;
import com.study.design_pattern._01_creational_patterns._03_abstract_factory._02_after.WhiteWheel;

public class WhiteShipFactory implements ShipFactory {
    @Override
    public Ship createShip() {
        Ship ship = new Whiteship();
        ship.setAnchor(new WhiteAnchor());
        ship.setWheel(new WhiteWheel());
        return ship;
    }
}
