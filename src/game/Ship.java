package game;

import java.util.Arrays;
import java.util.List;

public class Ship {

    private List<Square> placeOfShip;

    private final ShipType type;

    public Ship(ShipType type) {
        this.type = type;
    }

    public ShipType getType() {return type;}

    public void placeShip(Square[] placeOfShip) {
        this.placeOfShip.addAll(Arrays.asList(placeOfShip));
    }

    public boolean hasSunk() {
        for (Square square : placeOfShip) {
            if (square.getSquareStatus() == SquareStatus.SHIP) {
                return false;
            }
        }
        for (Square square : placeOfShip) {
            square.setSquareStatus(SquareStatus.SUNK);
        }
        return true;
    }
}
