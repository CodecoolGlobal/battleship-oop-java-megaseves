package game;

import java.util.Scanner;

public class Input {
    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final Display display = new Display();

    private final int asciiCodeForA = 65;
    private final int asciiCodeFor1 = 49;


    public void exitGame(String input){
        if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit"))
            System.exit(0);
    }


    public int getInputforMenu() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int input = scanner.nextInt();
                if (input > 0 && input < 5) {
                    return input;
                }else {
                    display.printInvalidInput();
                }
            } catch (Exception e){
                display.printInvalidInput();
            }
        }
    }

    public int[] getShipPlacement(){
        while(true){
            try{
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                exitGame(input);
                char firstPartInput = Character.toUpperCase(input.charAt(0));
                int secondPartInput = Integer.parseInt(input.substring(1));
                int firstConvertedCoord = alphabet.indexOf(firstPartInput);
                int secondConvertedCoord = secondPartInput - 1;
                if (firstConvertedCoord < 10 && firstConvertedCoord >= 0 && secondConvertedCoord < 10){ //Todo make it dynamic, add table size
                    return new int[]{firstConvertedCoord, secondConvertedCoord};
                }
                display.printInvalidCoord();
                display.printAskForStartingCoord();
            } catch (Exception ignored){
                display.printInvalidCoord();
                display.printAskForStartingCoord();
            }
        }
    }

    public int getShipPlacementWay(Square[][] possibleDirections) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try{
                int input = scanner.nextInt();
                if (possibleDirections[input - 1] != null) {
                    return input;
                }
                display.printInvalidInput();
            } catch (Exception e){
                display.printInvalidInput();
            }
        }
    }


    public int[] getShootCoord(int boardSize) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next().toUpperCase();
        exitGame(input);
        try {
            int inputFirstIndex = ((int) Character.toUpperCase(input.charAt(0))) - asciiCodeForA;
            int inputSecondIndex = Integer.parseInt(input.substring(1)) - 1;
            int[] shootCoords = new int[] {inputFirstIndex, inputSecondIndex};
            return validateInputCoord(shootCoords, boardSize) ?
                    new int[] {inputFirstIndex, inputSecondIndex} : new int[] {};
        } catch (Exception ignored) {
            return new int[] {};
        }
    }

    private boolean validateInputCoord(int[] coords, int boardSize) {
        if(coords[0] < 0 || coords[0] >= boardSize) {
            return false;
        }
        if(coords[1] >= boardSize) {
            return false;
        }
        return true;
    }

    public String getPlayerName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
