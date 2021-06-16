package ui;

import game.Player;
import game.WinCondition;
import listeners.CellListener;
import listeners.ResetListener;
import state.CellState;
import state.GameState;
import ui.buttons.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Application extends JFrame implements CellListener, ResetListener {
    private static final int BOARD_SIZE = 3;
    private static final int TOTAL_SQUARES = BOARD_SIZE * BOARD_SIZE;
    private Board board;
    private Player currentPlayer;
    private int moveCount;
    private boolean winnerFound;

    public Application() {
        currentPlayer = Player.X;
        setTitle("Tic-Tac-Toe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        board = new Board(BOARD_SIZE);
        add(board, BorderLayout.CENTER);
        StatusBar statusBar = new StatusBar();
        statusBar.setResetListener(this);
        board.setCellListener(this, statusBar.getLabelStatus());
        add(statusBar, BorderLayout.SOUTH);
    }

    @Override
    public void onReset(LabelStatus LabelStatus) {
        LabelStatus.setText(GameState.GAME_NOT_STARTED.getState());
        board.resetBoard(CellState.CELL_EMPTY.getCellState());
        currentPlayer = Player.X;
        winnerFound = false;
        moveCount = 0;
    }

    @Override
    public void onCellClicked(ActionEvent actionEvent, LabelStatus labelStatus) {
        Cell cell = (Cell) actionEvent.getSource();

        if (isPlayable.test(cell)) {
            ++moveCount;
            cell.setText(currentPlayer.toString());

            winnerFound = new WinCondition(cell.getName(), currentPlayer, board).check();

            if (winnerFound) {
                setStateWon(labelStatus);
            } else if (isDraw.test(moveCount, TOTAL_SQUARES)) {
                setStateDraw(labelStatus);
            } else {
                nextTurn(labelStatus);
            }
        }
    }

    private final Predicate<Cell> isPlayable = cell -> {
        return Objects.equals(cell.getText(), CellState.CELL_EMPTY.getCellState()) && !winnerFound;
    };

    private final BiPredicate<Integer, Integer> isDraw = (count, total) -> moveCount == total;

    private void setStateWon(LabelStatus labelStatus) {
        if (Objects.equals(currentPlayer, Player.X)) {
            labelStatus.setText(GameState.X_WINS.getState());
        } else {
            labelStatus.setText(GameState.O_WINS.getState());
        }
    }

    private void setStateDraw(LabelStatus labelStatus) {
        labelStatus.setText(GameState.DRAW.getState());
    }

    private void nextTurn(LabelStatus labelStatus) {
        labelStatus.setText(GameState.GAME_IN_PROGRESS.getState());
        currentPlayer = currentPlayer == Player.X ? Player.O : Player.X;
    }
}
