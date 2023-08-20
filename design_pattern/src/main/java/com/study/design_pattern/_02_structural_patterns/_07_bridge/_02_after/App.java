package com.study.design_pattern._02_structural_patterns._07_bridge._02_after;

import com.study.design_pattern._02_structural_patterns._07_bridge._01_before.Champion;

public class App {
    public static void main(String[] args) {
        Champion kda아리 = new 아리(new PoolParty());
        kda아리.move();
        kda아리.skillE();
    }
}
