package state;

public enum GameState {
    GAME_NOT_STARTED("Game is not started"),
    GAME_IN_PROGRESS("Game in progress"),
    X_WINS("X wins"),
    O_WINS("O wins"),
    DRAW("Draw");

    private final String state;

    GameState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}
