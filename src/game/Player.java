package game;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

public class Player {

    private final ArrayList<Ship> listOfShips = new ArrayList<>();

    public Player() {
        for (ShipType type : ShipType.values()) {
            this.listOfShips.add(new Ship(type));
        }
    }

    public ArrayList<Ship> getPlayerShips() {return listOfShips;}

    public void shoot(int[] coordinates, Square[][] ocean) {
        ocean[coordinates[0]][coordinates[1]].setSquareStatus(SquareStatus.SHOOT);
    }

    public boolean isAlive() {
        for (Ship ship : listOfShips) {
            if (!ship.hasSunk()) {
                return true;
            }
        }
        return false;
    }
}
