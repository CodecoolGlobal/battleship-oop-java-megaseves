package game;

public class Board {

    private Square[][] ocean;

    public Board() {
        ocean = new Square[10][10];
        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {
                ocean[row][col] = new Square(row, col);
            }
        }
    }

    public Square[][] getOcean() {
        return ocean;
    }

    public boolean isPlacementOk(int[] coordinates) {return true;}
}
