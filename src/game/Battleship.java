package game;

import java.util.Arrays;

public class Battleship {

    public static void main(String[] args) {
        boolean programIsRunning = true;
        Display display = new Display();
        Input input = new Input();
        while (programIsRunning){
            Game game = new Game();
            display.printMenu();
            int inputForMenu = input.getInputforMenu();
            switch (inputForMenu) {
                case 1 -> game.play();
                case 2 -> System.out.println("Print Highscore");
                case 3 -> programIsRunning = false;
            }
        }
    }
}
