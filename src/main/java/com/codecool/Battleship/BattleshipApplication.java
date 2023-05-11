package com.codecool.Battleship;

import com.codecool.Battleship.game.Display;
import com.codecool.Battleship.game.Game;
import com.codecool.Battleship.game.Input;


public class BattleshipApplication {

    public static void main(String[] args) {
        boolean programIsRunning = true;
        Display display = new Display();
        Input input = new Input();
        while (programIsRunning){
            Game game = new Game();
            display.printMenu();
            int inputForMenu = input.getInputforMenu();
            switch (inputForMenu) {
                case 1 -> game.play(5);
                case 2 -> game.play(3);
                case 3 -> game.play(1);
                case 4 -> programIsRunning = false;
            }
        }
    }
}
