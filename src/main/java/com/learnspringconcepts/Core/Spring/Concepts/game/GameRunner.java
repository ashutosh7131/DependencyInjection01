package com.learnspringconcepts.Core.Spring.Concepts.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {

    //MarioGame marioGame;
    GamingConsole gamingConsole;
    public GameRunner(GamingConsole gamingConsole) {
        this.gamingConsole = gamingConsole;
    }

    public void run() {
        System.out.println("Running game  --->>>  " +    gamingConsole);
        gamingConsole.up();
        gamingConsole.down();
        gamingConsole.left();
        gamingConsole.right();
    }
}
