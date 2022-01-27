package pl.rafal_kolodziej;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static JLabel score;

    public MainFrame() throws HeadlessException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Train"); //nazwa gry na pasku
        score = new JLabel( "WAGON:", SwingConstants.CENTER);
        score.setFont(new Font(score.getFont().getName(), Font.BOLD,25));

        add(new MainPanel());
        add(score, BorderLayout.NORTH);

        pack();
        setLocationRelativeTo(null);
        setResizable(false);

    }
}
