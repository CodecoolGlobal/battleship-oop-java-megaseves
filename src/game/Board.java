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

    public void placeShip(int[][] shipCoordinates) {
        for(int[] coordinate : shipCoordinates){
            ocean[coordinate[0]][coordinate[1]].setSquareStatus(SquareStatus.SHIP);
        }
    }

    public boolean checkIfValid(int x, int y){
        return ocean[x][y].getSquareStatus() != SquareStatus.SHIP;

    }


    public boolean isPlacementOk(int[] coordinates) {return true;}
}

