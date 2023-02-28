package com.codecool.Battleship.game;

import com.codecool.Battleship.board.Board;
import com.codecool.Battleship.board.Square;
import com.codecool.Battleship.board.SquareStatus;
import com.codecool.Battleship.ship.Ship;
import com.codecool.Battleship.ship.ShipType;

import java.util.ArrayList;

public class Player {

    private String name;

    private Board board;
    private final ArrayList<Ship> listOfShips = new ArrayList<>();

    public Player(int gameMode) {
        if( gameMode == 5){
            for (ShipType type : ShipType.values()) {
                this.listOfShips.add(new Ship(type));
            }
        } else if (gameMode == 3) {
            for (int i=0; i< gameMode; i++){
                this.listOfShips.add(new Ship(ShipType.values()[i]));
            }
        } else if (gameMode == 1) {
                this.listOfShips.add(new Ship(ShipType.values()[4]));
        }
        this.board = new Board();
        this.name = "";
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {return this.board;}
    public String getName() {return name;}

    public ArrayList<Ship> getPlayerShips() {return listOfShips;}


    public void shoot(Square shootSquare) {
        if (shootSquare.getSquareStatus() == SquareStatus.SHIP) {
            shootSquare.setSquareStatus(SquareStatus.SHOOT);
        } else {
            shootSquare.setSquareStatus(SquareStatus.MISS);
        }
    }

    public boolean isAlive() {
        boolean playerAlive = false;
        for (Ship ship : listOfShips) {
            if (!ship.hasSunk()) {
                playerAlive = true;
            }
        }
        return playerAlive;
    }

}
