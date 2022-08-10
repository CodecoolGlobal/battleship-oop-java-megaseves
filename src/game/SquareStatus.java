package game;

public enum SquareStatus {
    OCEAN("U+1F30A"),
    SHIP("U+1F6A2"),
    MISS("U+1F4A6"),
    SHOOT("U+1F525"),
    SUNK("U+1F4A5");

    public final String character;

    SquareStatus(String character) {
        this.character = character;
    }

}
