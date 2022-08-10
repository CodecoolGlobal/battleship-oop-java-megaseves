package game;

public class Game {

    private Player round;

    Board board1 = new Board();

    Square[][] currentBoard = board1.getOcean();

    private void shoot(int[] coordinates) {
        currentBoard[coordinates[0]][coordinates[1]].setSquareStatus(SquareStatus.SHOOT);
    }

    private boolean checkWin() {return true;}

}
