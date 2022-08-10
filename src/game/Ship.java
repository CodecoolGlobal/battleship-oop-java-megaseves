package game;

import java.util.Arrays;
import java.util.List;

public class Ship {

    private List<Square> placeOfShip;

    private final int length;

    public Ship(ShipType type) {
        this.length = type.length;
    }

    public int getLength() {return length;}

    public void placeShip(Square[] placeOfShip) {
        this.placeOfShip.addAll(Arrays.asList(placeOfShip));
    }

    public boolean hasSunk() {
        for (Square square : placeOfShip) {
            if (square.getSquareStatus() == SquareStatus.SHIP) {
                return false;
            }
        }
        return true;
    }
}
