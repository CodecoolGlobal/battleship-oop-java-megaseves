package com.codecool.Battleship.game;

import com.codecool.Battleship.board.Board;
import com.codecool.Battleship.board.Square;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class Display {

    public void printMenu() {
        System.out.println("Welcome to Battleships!\n" +
                           "\n" +
                           "    1. Easy Mode\n" +
                           "    2. Normal Mode\n" +
                           "    3. Hard Mode\n" +
                           "    4. Exit\n"
        );
    }

    public void printBoard(Board board, boolean isPlacementPhase) {
        Square[][] ocean = board.getOcean();
        for (int i = 1; i <= ocean[0].length; i++) {
            System.out.printf("%3d", i);
        }
        System.out.println();
        for (int i = 0; i < ocean.length; i++) {
            System.out.print((char) (i+65));
            for (Square cell : ocean[i]) {
                System.out.printf("%3s", cell.getCharacter(isPlacementPhase));
            }
            System.out.println();
        }
    }

    public void printGameplay() {}

    public void printResult(Player player) {
        System.out.println("\n" + player.getName() + " has won!" + "\n" );
    }

    public void printInvalidInput(){
        System.out.println("Invalid Input!");
    }

    public void printPossibleWays(Square[][] possibleDirections, String[]directions){
        StringBuilder possibleWays = new StringBuilder("Choose a way:\n");
        for (int i = 0; i < possibleDirections.length; i++) {
            System.out.println(Arrays.toString(possibleDirections[i]));
            if ( possibleDirections[i] != null) {
                possibleWays.append(i+1).append(" - ").append(directions[i]);
            }
            possibleWays.append("\n");
        }
        System.out.println(possibleWays);
    }

    public void printAskForStartingCoord(){
        System.out.println("Give a starting coord");
    }

    public void askForShot() {
        System.out.println("Please choose a coordinate to shoot!");
    }

    public void printCurrentPlayer(Player player) {
        System.out.println("This is " + player.getName() + "'s turn. \n \n");
    }

    public void currentShipSize(int shipSize) {
        System.out.println("Next ship is " + shipSize + " long");
    }

    public void printCoordinateIsInvalid(){
        System.out.println("Invalid coordinate( Already taken or Out of board )");
    }


    public void askForName() {
        System.out.println("Please give your name!");
    }

    public void printInvalidCoord() {
        System.out.println("The given Coord is out of board or already taken!");
    }

    public void printShootingPhase() {
        System.out.println("SHOOTING PHASE ! ");
    }

    public void clearScreen(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }


    public void stopTime(int howManySecond){
        try {
            TimeUnit.SECONDS.sleep(howManySecond);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void printPlacementPhase() {
        System.out.println("PLACEMENT PHASE");
    }

    public void numberOfShipsLeft( int shipLeft, int mode) {
        System.out.println(shipLeft + "/" + mode + " ship(s) can be placed!");
    }
}
