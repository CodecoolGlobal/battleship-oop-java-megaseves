package com.codecool.Battleship.game;

import com.codecool.Battleship.board.Board;
import com.codecool.Battleship.board.Square;
import com.codecool.Battleship.board.SquareStatus;
import com.codecool.Battleship.ship.Ship;

public class Game {

    private Player[] players;
    private Display display = new Display();
    private Input input = new Input();

    private boolean checkWin(Player round) {return round.isAlive();}

    private void initializeGame(int mode){
        players = new Player[]{new Player(mode), new Player(mode)};
        for (Player player : players) {
            display.clearScreen();
            display.askForName();
            player.setName(input.getPlayerName());
            display.clearScreen();
            placementPhase(player, player.getBoard(), mode);
            display.stopTime(1);
        }
    }

    private void placementPhase(Player player, Board playerBoard, int mode){
        int shipLeft = mode;
        String[] directions = {"Up", "Right", "Down", "Left"};
        for (Ship ship : player.getPlayerShips()){
            int shipSize = ship.getType().length;
            display.clearScreen();
            display.printCurrentPlayer(player);
            display.printBoard(playerBoard, true);
            display.numberOfShipsLeft(shipLeft, mode);
            display.currentShipSize(shipSize);
            Square[][] possibleDirections = new Square[4][];
            boolean firstCoordValid = false;
            while (!firstCoordValid) {
                display.printAskForStartingCoord();
                int[] starterCoord = input.getShipPlacement();
                possibleDirections = playerBoard.generatePossibleDirections(starterCoord, shipSize, directions);
                for (int i = 0; i < 4; i++) {
                    if (possibleDirections[i] != null) {
                        firstCoordValid = true;
                        break;
                    }
                }
                if (!firstCoordValid) {display.printInvalidInput();}
            }
            display.printPossibleWays(possibleDirections, directions);
            int inputDirection = input.getShipPlacementWay(possibleDirections);
            ship.placeShip(possibleDirections[inputDirection - 1]);
            shipLeft--;
        }
    }


    public void play(int mode) {
        initializeGame(mode);
        display.clearScreen();
        display.printShootingPhase();
        Player currentPlayer = players[0];
        Board currentBoard = players[1].getBoard();
        boolean isRunning = true;
        while (isRunning) {
            Square[][] ocean = currentBoard.getOcean();
            display.stopTime(1);
            display.clearScreen();
            display.printCurrentPlayer(currentPlayer);
            display.printBoard(currentBoard, false);
            boolean validShot = false;
            while (!validShot) {
                int[] shootCoord;
                display.askForShot();
                shootCoord = input.getShootCoord(ocean.length);
                if (shootCoord.length == 2) {
                    Square shootSquare = ocean[shootCoord[0]][shootCoord[1]];
                    if (shootSquare.getSquareStatus() == SquareStatus.SHIP ||
                            shootSquare.getSquareStatus() == SquareStatus.OCEAN) {
                        validShot = true;
                        currentPlayer.shoot(shootSquare);
                    }
                }
                if (!validShot) {display.printInvalidInput();}
            }
            display.clearScreen();
            display.printBoard(currentBoard, false);
            currentPlayer = rotateRound(currentPlayer);
            currentBoard = rotateBoards(currentBoard);
            isRunning = checkWin(currentPlayer);
        }
        currentPlayer = rotateRound(currentPlayer);
        currentBoard = rotateBoards(currentBoard);
        display.clearScreen();
        display.printBoard(currentBoard, false);
        display.printResult(currentPlayer);
        display.stopTime(4);
        display.clearScreen();
    }

    private Player rotateRound(Player currentPlayer) {
        return currentPlayer == players[0] ? players[1] : players[0];
    }

    private Board rotateBoards(Board currentBoard) {
        return currentBoard == players[0].getBoard() ? players[1].getBoard() : players[0].getBoard();
    }

}
