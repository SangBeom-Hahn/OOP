package com.study.design_pattern._02_structural_patterns._12_proxy._02_after;

public class GameServiceProxy implements GameService {
    private GameService gameService;
    
    @Override
    public void startGame() {
        long bef = System.currentTimeMillis();
        if (this.gameService == null) {
            this.gameService = new DefaultGameService();
        }
        
        gameService.startGame();
        System.out.println(System.currentTimeMillis() - bef);
    }
}
