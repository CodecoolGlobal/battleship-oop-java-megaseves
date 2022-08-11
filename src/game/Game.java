package game;

public class Game {

    private int round;


    private final Board player1board = new Board();
    private final Board player2board = new Board();

    Display display = new Display();
    Input input = new Input();

    private void shoot(int[] coordinates) {}

    private boolean checkWin() {return true;}


    public void initializeGame(){
        display.askForName();
        String player1name = input.getPlayerName();
        display.askForName();
        String player2name = input.getPlayerName();
        final Player player1 = new Player(player1name);
        final Player player2 = new Player(player2name);
        placementPhase(player1, player1board);
        placementPhase(player2, player2board);
    }

    public void placementPhase(Player player, Board playerBoard){
        display.printCurrentPlayer(player);
        for (Ship ship : player.getPlayerShips()){
            int shipSize = ship.getType().length;
            display.currentShipSize(shipSize);
            int[][] allShipCoordinates = new int[shipSize][2];
            boolean placementIsValid = false;
            while (!placementIsValid){
                display.printAskForStartingCoord();
                int[] starterCoord = input.getShipPlacement();
                display.printPossibleWays();
                int way = input.getShipPlacementWay();
                allShipCoordinates = generateShipCoordinates(starterCoord, way, shipSize);
                placementIsValid = validateCoords(allShipCoordinates, playerBoard);
                if (!placementIsValid) display.printCoordinateIsInvalid();
            }
            for(int[] coordinate : allShipCoordinates){
                Square currentSquare = playerBoard.getOcean()[coordinate[0]][coordinate[1]];
                currentSquare.setSquareStatus(SquareStatus.SHIP);
                ship.linkSquare(currentSquare);
            }
            playerBoard.placeShip(allShipCoordinates);
            display.printBoard(playerBoard);
        }
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

    public boolean validateCoords(int [][] allCoords, Board playerBoard){    // TODO give player1 as arg
        boolean isValid = true;
        for(int [] coordPair:allCoords){
            try {
                if (!playerBoard.checkIfValid(coordPair[0], coordPair[1])){
                    isValid = false;
                }
            }catch (Exception e){
                return false;
            }
        }
        return isValid;
    }

}
