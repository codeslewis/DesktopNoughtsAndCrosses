package game;

public class Coordinates {
    private final int x;
    private final int y;

    public Coordinates(String name) {
        String chessLabel = name.substring(name.length() - 2);
        this.x = 3 - (chessLabel.charAt(1) - '0');
        this.y = chessLabel.charAt(0) - 'A';
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
