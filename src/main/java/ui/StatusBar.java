package ui;

import listeners.ResetListener;
import state.GameState;
import ui.buttons.ButtonReset;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class StatusBar extends JPanel {
    private LabelStatus labelStatus;
    private ResetListener resetListener;

    public StatusBar() {
        setLayout(new BorderLayout());
        setSize(400, 200);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        initComponents();
    }

    private void initComponents() {
        labelStatus = new LabelStatus(GameState.GAME_NOT_STARTED.getState());
        add(labelStatus, BorderLayout.WEST);
        JButton buttonReset = new ButtonReset();
        buttonReset.addActionListener(actionEvent -> {
            if (resetListener != null) {
                resetListener.onReset(labelStatus);
            }
        });
        add(buttonReset, BorderLayout.EAST);
    }

    public LabelStatus getLabelStatus() {
        return labelStatus;
    }

    public void setResetListener(ResetListener resetListener) {
        this.resetListener = resetListener;
    }
}
