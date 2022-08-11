package game;

import java.util.ArrayList;

public class Player {

    private String name;
    private final ArrayList<Ship> listOfShips = new ArrayList<>();

    public Player(String name) {
        for (ShipType type : ShipType.values()) {
            this.listOfShips.add(new Ship(type));
        }
        this.name = name;
    }

    public ArrayList<Ship> getPlayerShips() {return listOfShips;}


    public void shoot(Square shootSquare) {
        if (shootSquare.getSquareStatus() == SquareStatus.SHIP) {
            shootSquare.setSquareStatus(SquareStatus.SHOOT);
        } else {
            shootSquare.setSquareStatus(SquareStatus.MISS);
        }
    }

    public boolean isAlive() {
        for (Ship ship : listOfShips) {
            if (!ship.hasSunk()) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}
