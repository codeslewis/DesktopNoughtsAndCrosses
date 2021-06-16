package ui;

import javax.swing.*;
import java.awt.*;

public class LabelStatus extends JLabel {
    public LabelStatus(String status) {
        setText(status);
        setName("LabelStatus");
        setFont(new Font("Arial", Font.BOLD, 14));
    }
}
