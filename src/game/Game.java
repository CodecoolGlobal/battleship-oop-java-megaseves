package game;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {

    private int round;


    private Board player1board = new Board();
    private Board player2board = new Board();
    Display display = new Display();
    Input input = new Input();

    private void shoot(int[] coordinates) {}

    private boolean checkWin() {return true;}


    public void initializeGame(){


        display.printAskForStartingCoord();
        int [] starterCoord = input.getShipPlacementStartingCoord();
        display.printPossibleWays();
        int way = input.getShipPlacementWay();
        System.out.println(Arrays.deepToString(generateShipCoordinates(starterCoord, way, 3)));
        System.out.println(validateCoords(generateShipCoordinates(starterCoord, way, 3)));




    }

    public void placementPhase(){

    }

    public int [] []generateShipCoordinates (int [] starterCoord, int way, int shipSize){
        switch(way){
            case 1: return generateShipCoordinatesUp(starterCoord, shipSize);
            case 2: return generateShipCoordinatesRight(starterCoord, shipSize);
            case 3: return generateShipCoordinatesDown(starterCoord, shipSize);
            case 4: return generateShipCoordinatesLeft(starterCoord, shipSize);
            default:
                System.out.println("hatalmas hiba");                       // TODO  valamit kéne ezzel kezdeni
                return generateShipCoordinatesUp(starterCoord, shipSize);
        }
    }

    public int [] []generateShipCoordinatesRight(int [] starterCoord, int shipSize){
        int [] []   shipCoordinates = new int[shipSize][2];
        for (int i=0; i<shipSize; i++){
            shipCoordinates[i][0] = starterCoord[0];
            shipCoordinates[i][1] = starterCoord[1] + i;
        }
        return shipCoordinates;
    }

    public int [] [] generateShipCoordinatesUp(int [] starterCoord, int shipSize){
        int [] []   shipCoordinates = new int[shipSize][2];
        for (int i=0; i<shipSize; i++){
            shipCoordinates[i][0] = starterCoord[0] - i;
            shipCoordinates[i][1] = starterCoord[1];
        }
        return shipCoordinates;
    }

    public int [] [] generateShipCoordinatesLeft(int [] starterCoord, int shipSize){
        int [] []   shipCoordinates = new int[shipSize][2];
        for (int i=0; i<shipSize; i++){
            shipCoordinates[i][0] = starterCoord[0];
            shipCoordinates[i][1] = starterCoord[1] - i;
        }
        return shipCoordinates;
    }

    public int [] [] generateShipCoordinatesDown(int [] starterCoord, int shipSize){
        int [] []   shipCoordinates = new int[shipSize][2];
        for (int i=0; i<shipSize; i++){
            shipCoordinates[i][0] = starterCoord[0] + i;
            shipCoordinates[i][1] = starterCoord[1];
        }
        return shipCoordinates;
    }

    public boolean validateCoords(int [][] allCoords){    // TODO give player1 as arg
        for(int [] coordPair:allCoords){
            try {
                if (player1board.checkIfValid(coordPair[0], coordPair[1])){
                    return false;
                }
            }catch (Exception e){
                return false;
            }
        }
        return true;
    }

}
