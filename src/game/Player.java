package game;

import java.util.List;

public class Player {

    private List<Ship> listOfShips;

    public Player() {
        for (ShipType type : ShipType.values()) {
            listOfShips.add(new Ship(type));
        }
    }

    public List<Ship> getPlayerShips() {return listOfShips;}

    public boolean isAlive() {
        for (Ship ship : listOfShips) {
            if (!ship.hasSunk()) {
                return true;
            }
        }
        return false;
    }
}
