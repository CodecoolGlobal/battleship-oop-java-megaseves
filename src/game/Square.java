package game;

public class Square {

    private int xCoordinate;

    private int yCoordinate;

    private String squareStatus;

    public Square() {
        this.squareStatus = SquareStatus.OCEAN.character;
    }

}
