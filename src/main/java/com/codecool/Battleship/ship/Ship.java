package com.codecool.Battleship.ship;

import com.codecool.Battleship.board.Square;
import com.codecool.Battleship.board.SquareStatus;

import java.util.ArrayList;

public class Ship {

    private final ArrayList<Square> shipSquares = new ArrayList<>();

    private final ShipType type;

    public Ship(ShipType type) {
        this.type = type;
    }

    public ShipType getType() {return type;}

    public void placeShip(Square[] squares) {
        for (Square square : squares) {
            square.setSquareStatus(SquareStatus.SHIP);
            shipSquares.add(square);
        }
    }

    public boolean hasSunk() {
        for (Square square : shipSquares) {
            if (square.getSquareStatus() == SquareStatus.SHIP) {
                return false;
            }
        }
        for (Square square : shipSquares) {
            square.setSquareStatus(SquareStatus.SUNK);
        }
        return true;
    }
}
