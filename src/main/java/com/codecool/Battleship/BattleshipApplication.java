package com.codecool.Battleship;

import com.codecool.Battleship.game.Display;
import com.codecool.Battleship.game.Game;
import com.codecool.Battleship.game.Input;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BattleshipApplication {

    public static void main(String[] args) {
        SpringApplication.run(BattleshipApplication.class, args);
        boolean programIsRunning = true;
        Display display = new Display();
        Input input = new Input();
        while (programIsRunning){
            Game game = new Game();
            display.printMenu();
            int inputForMenu = input.getInputforMenu();
            switch (inputForMenu) {
                case 1: game.play(5);
                        break;
                case 2: game.play(3);
                    break;
                case 3 : game.play(1);
                    break;
                case 4 : programIsRunning = false;
                    break;
            }
        }
    }
}
