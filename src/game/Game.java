package game;

public class Game {

    private Player[] players;
    Display display = new Display();
    Input input = new Input();

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
        /*display.clearScreen();
        display.askForName("player1");
        player1.setName(input.getPlayerName());
        display.clearScreen();
        display.askForName("player2");
        player2.setName(input.getPlayerName());
        display.clearScreen();
        display.printPlacementPhase();
        display.stopTime(1);
        placementPhase(player1, player1board, mode);
        placementPhase(player2, player2board, mode);*/
    }

    private void placementPhase(Player player, Board playerBoard, int mode){
        int shipLeft = mode;
        for (Ship ship : player.getPlayerShips()){
            int shipSize = ship.getType().length;
            display.clearScreen();
            display.printCurrentPlayer(player);
            display.printBoard(playerBoard, true);
            display.numberOfShipsLeft(shipLeft, mode);
            display.currentShipSize(shipSize);
            int[][] allShipCoordinates = new int[shipSize][2];
            boolean placementIsValid = false;
            while (!placementIsValid) {
                boolean firstCoordValid = false;
                int[] starterCoord = new int[0];
                while (!firstCoordValid) {
                    display.printAskForStartingCoord();
                    starterCoord = input.getShipPlacement();
                    if (validateSingleCoord(starterCoord, playerBoard)) {
                        firstCoordValid = true;
                    }else{
                        display.printInvalidCoord();
                    }
                }
                display.printPossibleWays();
                int way = input.getShipPlacementWay();
                allShipCoordinates = generateShipCoordinates(starterCoord, way, shipSize);
                placementIsValid = validateCoords(allShipCoordinates, playerBoard);
                if (!placementIsValid) {
                    display.printInvalidCoord();
                }
            }
            for(int[] coordinate : allShipCoordinates){
                Square currentSquare = playerBoard.getOcean()[coordinate[0]][coordinate[1]];
                currentSquare.setSquareStatus(SquareStatus.SHIP);
                ship.linkSquare(currentSquare);
            }
            playerBoard.placeShip(allShipCoordinates);
            display.clearScreen();
            display.printBoard(playerBoard, true);
            shipLeft --;
        }
    }

    private int [] []generateShipCoordinates(int [] starterCoord, int direction, int shipSize){
        int rowChange = 0;
        int colChange = 0;
        switch (direction) {
            case 1 -> rowChange = -1;
            case 2 -> colChange = 1;
            case 3 -> rowChange = 1;
            case 4 -> colChange = -1;
        }
        int [] []   shipCoordinates = new int[shipSize][2];
        for (int i=0; i<shipSize; i++){
            shipCoordinates[i][0] = starterCoord[0] + (i * rowChange);
            shipCoordinates[i][1] = starterCoord[1] + (i * colChange);
        }
        return shipCoordinates;
    }

    private boolean validateCoords(int [][] allCoords, Board playerBoard){
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

    private boolean validateSingleCoord(int []coordPair, Board playerBoard){
        boolean isValid = true;
        try {
            if (!playerBoard.checkIfValid(coordPair[0], coordPair[1])){
                isValid = false;
            }
        }catch (Exception e){
            return false;
        }
        return isValid;
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


    /*private int [] []generateShipCoordinates (int [] starterCoord, int way, int shipSize){
        switch(way){
            case 1: return generateShipCoordinates(starterCoord, shipSize, way);
            case 2: return generateShipCoordinates(starterCoord, shipSize, way);
            case 3: return generateShipCoordinates(starterCoord, shipSize, way);
            case 4: return generateShipCoordinates(starterCoord, shipSize, way);
            default:
                System.out.println("hatalmas hiba");                       // TODO  valamit kéne ezzel kezdeni
                return generateShipCoordinatesUp(starterCoord, shipSize);
        }
    }

    private int [] []generateShipCoordinatesRight(int [] starterCoord, int shipSize){
        int [] []   shipCoordinates = new int[shipSize][2];
        for (int i=0; i<shipSize; i++){
            shipCoordinates[i][0] = starterCoord[0];
            shipCoordinates[i][1] = starterCoord[1] + i;
        }
        return shipCoordinates;
    }

    private int [] [] generateShipCoordinatesUp(int [] starterCoord, int shipSize){
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

    private int [] [] generateShipCoordinatesDown(int [] starterCoord, int shipSize){
        int [] []   shipCoordinates = new int[shipSize][2];
        for (int i=0; i<shipSize; i++){
            shipCoordinates[i][0] = starterCoord[0] + i;
            shipCoordinates[i][1] = starterCoord[1];
        }
        return shipCoordinates;
    }*/

}
