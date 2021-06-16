package game;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(String name) {
        String chessLabel = name.substring(name.length() - 2);
        int xCoord = 3 - (chessLabel.charAt(1) - '0');
        int yCoord = chessLabel.charAt(0) - 'A';
        if (xCoord < 0 || xCoord > 2 || yCoord < 0 || yCoord > 2) {
            throw new IllegalArgumentException("Coordinate must be in range A0 to C3");
        }
        this.x = xCoord;
        this.y = yCoord;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean mainDiagonal() {
        return this.x == this.y;
    }

    public boolean inverseDiagonal() {
        return this.x + this.y == 2;
    }
}
