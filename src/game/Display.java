package game;

public class Display {

    public void printMenu() {
        System.out.println("""
                Welcome to Battleships!
                
                    1. New game
                    2. High scores
                    3. Exit""");
    }

    public void printBoard(Board board, boolean isPlacementPhase) {
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
                System.out.printf("%3s", cell.getCharacter(isPlacementPhase));
                //rowToDisplay.append(cell.toString()).append(" ");
            }
            System.out.println();
            //System.out.println(rowToDisplay);
        }
    }

    public void printGameplay() {}

    public void printResult() {}
}
