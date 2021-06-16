package ui;

import game.Player;
import listeners.CellListener;
import state.CellState;
import ui.buttons.Cell;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class Board extends JPanel {
    private CellListener cellListener;
    private final int boardSize;
    private LabelStatus labelStatus;
    private final Cell[][] board;

    public Board(int size) {
        this.boardSize = size;
        board = new Cell[size][size];
        setLayout(new GridLayout(size, size));
        initCells();
    }

    private void initCells() {
        for (int row = boardSize; row > 0; --row) {
            for (int col = 0; col < boardSize; ++col) {
                String coordinates = (char) ('A' + col) + "" + row;
                String name = "Button" + coordinates;
                Cell cell = new Cell(name, CellState.CELL_EMPTY.getCellState());
                board[boardSize - row][col] = cell;
                cell.addActionListener(actionEvent -> {
                    if (cellListener != null && labelStatus != null) {
                        cellListener.onCellClicked(actionEvent, labelStatus);
                    }
                });
                add(cell);
            }
        }
    }

    public void setCellListener(CellListener cellListener, LabelStatus labelStatus) {
        this.cellListener = cellListener;
        this.labelStatus = labelStatus;
    }

    public void resetBoard(String resetVal) {
        Arrays.stream(getComponents()).forEach(component -> {
            ((Cell) component).setText(resetVal);
        });
    }

    public boolean compareCell(int row, int col, Player comparison) {
        return Objects.equals(this.board[row][col].getText(), comparison.toString());
    }

    public int getBoardSize() {
        return boardSize;
    }
}
