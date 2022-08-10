package game;

public class Battleship {

    public static void main(String[] args) {
        boolean programIsRunning = true;
        while (programIsRunning){
            Display display = new Display();
            Input input = new Input();
            Game game = new Game();

            int inputForMenu = input.getInputforMenu();
            switch (inputForMenu) {
                case 1 -> System.out.println("Start Game");
                case 2 -> System.out.println("Print Highscore");
                case 3 -> programIsRunning = false;
            }
        }
    }
}
