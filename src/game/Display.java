package game;

public class Display {

    public void printMenu() {
        System.out.println("""
                Welcome to Battleships!
                
                    1. New game
                    2. High scores
                    3. Exit
                    """
        );
    }

    public void printBoard() {}

    public void printGameplay() {}

    public void printResult() {}

    public void printInvalidInput(){
        System.out.println("Invalid Input!");
    }

    public void printPossibleWays(){
        System.out.println("""
                            Choose a way: 
                            1 - Up 
                            2 - Down
                            3 - Right
                            4 - Left
                               """);
    }
}
