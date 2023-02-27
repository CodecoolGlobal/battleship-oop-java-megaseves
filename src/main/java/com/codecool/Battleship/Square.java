package com.codecool.Battleship;

public class Square {

    private final int xCoordinate;

    private final int yCoordinate;

    private SquareStatus squareStatus;

    public Square(int xCoord, int yCoord) {
        this.squareStatus = SquareStatus.OCEAN;
        xCoordinate = xCoord;
        yCoordinate = yCoord;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    public void setSquareStatus(SquareStatus status) {
        squareStatus = status;
    }

    public String getCharacter(boolean isPlacementPhase) {
        if (isPlacementPhase) {return squareStatus.character;}
        return squareStatus == SquareStatus.SHIP ? SquareStatus.OCEAN.character : squareStatus.character;
    }

}
