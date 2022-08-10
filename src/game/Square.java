package game;

public class Square {

    private final int xCoordinate;

    private final int yCoordinate;

    private String squareStatus;

    public Square(int xCoord, int yCoord) {
        this.squareStatus = SquareStatus.OCEAN.character;
        xCoordinate = xCoord;
        yCoordinate = yCoord;
    }

}
