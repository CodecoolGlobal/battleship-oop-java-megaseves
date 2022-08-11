package game;

public enum ShipType {

    CARRIER(6),
    BATTLESHIP(5),
    CRUISER(4),
    SUBMARINE(3),
    DESTROYER(2);

    public final int length;


    ShipType(int length) {
        this.length = length;
    }
}
