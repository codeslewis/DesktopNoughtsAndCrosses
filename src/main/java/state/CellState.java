package state;

public enum CellState {
    CELL_EMPTY(" ");

    private final String cellState;

    CellState(String cellState) {
        this.cellState = cellState;
    }

    public String getCellState() {
        return cellState;
    }
}
