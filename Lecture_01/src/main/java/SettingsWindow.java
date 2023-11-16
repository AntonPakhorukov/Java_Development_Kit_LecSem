import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Еще одно окно для выбора условий игры
 */
public class SettingsWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 236;
    private static final int WINDOW_WIDTH = 350;
    JButton btnStart = new JButton("Start new game");
    SettingsWindow(GameWindow gameWindow){ // Принимает основное игровое окно
        setLocationRelativeTo(gameWindow);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameWindow.startNewGame(0, 3, 3, 3);
                setVisible(false);
//                gameWindow.setVisible(true);
            }
        });
        add(btnStart);
    }
}
