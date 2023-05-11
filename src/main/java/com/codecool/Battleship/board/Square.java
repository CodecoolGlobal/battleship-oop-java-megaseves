package com.codecool.Battleship.board;

public class Square {

    private SquareStatus squareStatus;

    public Square(int xCoord, int yCoord) {
        this.squareStatus = SquareStatus.OCEAN;
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
