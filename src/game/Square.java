package game;

public class Square {

    private final int xCoordinate;

    private final int yCoordinate;

    private SquareStatus squareStatus;

    private String character;

    public Square(int xCoord, int yCoord) {
        this.character = SquareStatus.OCEAN.character;
        this.squareStatus = SquareStatus.OCEAN;
        xCoordinate = xCoord;
        yCoordinate = yCoord;
    }

    public SquareStatus getSquareStatus() {
        return squareStatus;
    }

    @Override
    public String toString() {
        return character;
    }

}
