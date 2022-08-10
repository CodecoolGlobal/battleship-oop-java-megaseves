package game;

public enum SquareStatus {
    OCEAN("\uD83C\uDF0A"),
    SHIP("\uD83D\uDEA2"),
    MISS("\uD83D\uDCA6"),
    SHOOT("\uD83D\uDD25"),
    SUNK("\uD83D\uDCA5");

    public final String character;

    SquareStatus(String character) {
        this.character = character;
    }

}
