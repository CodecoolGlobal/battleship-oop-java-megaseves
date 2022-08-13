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

    public Square[][] generatePossibleDirections(int[] starterCoord, int shipSize, String[] directions) {
        Square[][] possibleDirections = new Square[4][];
        for (int i = 0; i < directions.length; i++) {
            int rowChangeMultiplier = 0;
            int colChangeMultiplier = 0;
            switch (directions[i]) {
                case "Up" -> rowChangeMultiplier = -1;
                case "Right" -> colChangeMultiplier = 1;
                case "Down" -> rowChangeMultiplier = 1;
                case "Left" -> colChangeMultiplier = -1;
            }
            boolean invalidDirection = false;
            Square[] possibleSquares = new Square[shipSize];
            for (int j = 0; j < shipSize; j++) {
                int possibleSquareCoordinateX = starterCoord[0] + (j * rowChangeMultiplier);
                int possibleSquareCoordinateY = starterCoord[1] + (j * colChangeMultiplier);
                if (isPlacementOk(possibleSquareCoordinateX, possibleSquareCoordinateY)) {
                    possibleSquares[j] = ocean[possibleSquareCoordinateX][possibleSquareCoordinateY];
                } else {
                    invalidDirection = true;
                }
            }
            if (!invalidDirection) {
                possibleDirections[i] = possibleSquares;
            }
        }
        return possibleDirections;
    }

    public boolean isPlacementOk(int coordX, int coordY) {
        if (coordX < 0 || coordX >= ocean.length || coordY < 0 || coordY >= ocean.length) {
            return false;
        }
        return ocean[coordX][coordY].getSquareStatus() == SquareStatus.OCEAN;
    }
}

