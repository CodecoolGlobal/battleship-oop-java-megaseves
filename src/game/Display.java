package game;

import java.util.concurrent.TimeUnit;

public class Display {

    public void printMenu() {
        System.out.println("Welcome to Battleships!\n" +
                           "\n" +
                           "    1. Easy Mode\n" +
                           "    2. Normal Mode\n" +
                           "    3. Hard Mode\n" +
                           "    4. Exit\n"
        );
    }

    public void printBoard(Board board) {
        Square[][] ocean = board.getOcean();
        //StringBuilder header = new StringBuilder();
        for (int i = 1; i <= ocean[0].length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 0; i < ocean.length; i++) {
            //StringBuilder rowToDisplay = new StringBuilder();
            System.out.print((char) (i+65));
            //rowToDisplay.append((char) (i + 65)).append(" ");
            for (Square cell : ocean[i]) {
                System.out.printf("%3s", cell.toString());
                //rowToDisplay.append(cell.toString()).append(" ");
            }
            System.out.println();
            //System.out.println(rowToDisplay);
        }
    }

    public void printShootingBoard(Board board) {
        Square[][] ocean = board.getOcean();
        //StringBuilder header = new StringBuilder();
        for (int i = 1; i <= ocean[0].length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 0; i < ocean.length; i++) {
            //StringBuilder rowToDisplay = new StringBuilder();
            System.out.print((char) (i+65));
            //rowToDisplay.append((char) (i + 65)).append(" ");
            for (Square cell : ocean[i]) {
                if(cell.getSquareStatus() == SquareStatus.SHIP){
                    System.out.printf("%3s",  SquareStatus.OCEAN.character.toString());
                }else{
                    System.out.printf("%3s", cell.toString());
                    //rowToDisplay.append(cell.toString()).append(" ");
                }
            }
            System.out.println();
            //System.out.println(rowToDisplay);
        }
    }

    public void printGameplay() {}

    public void printResult(Player player) {
        System.out.println("\n" + player.getName() + " has won!" + "\n" );
    }

    public void printInvalidInput(){
        System.out.println("Invalid Input!");
    }

    public void printPossibleWays(){
        System.out.println("Choose a way:\n" +
                           "1 - Up\n" +
                           "2 - Right\n" +
                           "3 - Down\n" +
                           "4 - Left\n");
    }

    public void printAskForStartingCoord(){
        System.out.println("Give a starting coord");
    }

    public void askForShot() {
        System.out.println("Please choose a coordinate to shoot!");
    }

    public void printCurrentPlayer(Player player) {
        System.out.println("This is " + player.getName() + "'s turn. \n \n");
    }

    public void currentShipSize(int shipSize) {
        System.out.println("Next ship is " + shipSize + " long");
    }

    public void askForName(String player) {
        System.out.println("Please give your name: " + player + "!");
    }

    public void printInvalidCoord() {
        System.out.println("The given Coord is out of board or already taken!");
    }

    public void printShootingPhase() {
        System.out.println("SHOOTING PHASE ! ");
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public void stopTime(int howManySecond){
        try {
            TimeUnit.SECONDS.sleep(howManySecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printPlacementPhase() {
        System.out.println("PLACEMENT PHASE");
    }

    public void numberOfShipsLeft( int shipLeft, int mode) {
        System.out.println(shipLeft + "/" + mode + " ship(s) can be placed!");
    }
}
