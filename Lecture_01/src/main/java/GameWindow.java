import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWindow extends JFrame {
    private static final int WINDOW_HEIGHT = 555;
    private static final int WINDOW_WIDTH = 507;
    private static final int WINDOW_POSX = 800;
    private static final int WINDOW_POSY = 300;
    JButton btnStart = new JButton("New Game"); // За кнопки отвечает JButton
    JButton btnExit = new JButton("Exit");
    Map map;
    SettingsWindow settings;

    public GameWindow() {
        /**
         * Размещение окна
         */
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Чтобы при нажатии на крестик окна - программа закрывалась,
        // в обратном случае закроется окно, а программа продолжит работать
        setLocation(WINDOW_POSX, WINDOW_POSY); // В каком месте расположится окно
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT); // Какой размер окна будет
        setTitle("TicTacToe"); // Заголовок окна
        setResizable(false); // Изменяемость размера окна
        /**
         * Игровое поле
         */
        map = new Map();
        settings = new SettingsWindow(this); // this = передает ссылку на себя
        btnExit.addActionListener(new ActionListener() { // Обрабатываем нажатие кнопки Exit
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        btnStart.addActionListener(new ActionListener() { // Обрабатываем нажатие кнопки Start
            @Override
            public void actionPerformed(ActionEvent e) {
                settings.setVisible(true);
            }
        });
        settings.setVisible(true);
        /**
         * Размещение кнопок
         */
//        add(btnStart); // Добавить кнопку в окно, по умолчанию встанет в центр
//        add(btnExit); // Встанет поверх первой кнопки - косяк, используем планер:
        JPanel panBottom = new JPanel(new GridLayout(1, 2)); // По сути невидимый прямоугольник,
        // который может иметь собственный компоновщик GridLayout, и указываем размещение кнопок 1 (строк), 2 (столбцов)
        panBottom.add(btnStart); // Добавляем в него две кнопки
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH); // Теперь в основное окно добавляем наш компонент
        // (на компонент добавлены ранее кнопки) и указываем его положение
        add(map); // Добавляем поле в окно
        setVisible(true); // Окно по умолчанию не видимо, чтобы это изменить нужно изменить параметр "setVisible" на true

    }
    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        map.startNewGame(mode, fSzX, fSzY, wLen);

    }
}
