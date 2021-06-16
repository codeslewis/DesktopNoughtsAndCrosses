package ui.buttons;

import javax.swing.*;
import java.awt.*;

public class Cell extends JButton {
    public Cell(String name, String initVal) {
        setName(name);
        setText(initVal);
        setFocusPainted(false);
        setFont(new Font("Arial", Font.BOLD, 48));
    }
}
