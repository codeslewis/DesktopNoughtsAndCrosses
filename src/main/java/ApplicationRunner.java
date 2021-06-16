import ui.Application;

import javax.swing.*;

public class ApplicationRunner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Application::new);
    }
}
