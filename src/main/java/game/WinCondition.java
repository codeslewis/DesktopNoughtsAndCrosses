package game;

import ui.Board;

import java.util.function.IntPredicate;

public class WinCondition {
    private final Board currentBoard;
    private final Coordinates currentCell;
    private final Player player;

    public WinCondition(String cellName, Player player, Board currentBoard) {
        this.player = player;
        this.currentCell = new Coordinates(cellName);
        this.currentBoard = currentBoard;
    }

    public boolean check() {
        final IntPredicate columnCondition = iterator -> !currentBoard.compareCell(currentCell.getX(), iterator, player);
        final IntPredicate rowCondition = iterator -> !currentBoard.compareCell(iterator, currentCell.getY(), player);
        final IntPredicate diagonalCondition = iterator -> !currentBoard.compareCell(iterator, iterator, player);
        final IntPredicate inverseDiagonalCondition = iterator -> !currentBoard.compareCell(iterator, 2 - iterator, player);
        return checkCells(columnCondition) ||
                checkCells(rowCondition) ||
                checkDiagonal(diagonalCondition)||
                checkInverseDiagonal(inverseDiagonalCondition);
    }

    private boolean checkCells(IntPredicate function) {
        for (int i = 0; i < currentBoard.getBoardSize(); i++) {
            if (function.test(i))
                break;
            if (threeInARow(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean threeInARow(int iterator) {
        return iterator == currentBoard.getBoardSize() - 1;
    }

    private boolean checkDiagonal(IntPredicate condition) {
        if (currentCell.mainDiagonal()) {
            return checkCells(condition);
        }
        return false;
    }

    private boolean checkInverseDiagonal(IntPredicate condition) {
        if (currentCell.inverseDiagonal()) {
            return checkCells(condition);
        }
        return false;
    }
}
