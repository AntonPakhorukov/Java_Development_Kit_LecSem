import javax.print.DocFlavor;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Collections;
import java.util.Random;

/**
 * Класс с основной игровой панелью
 */
public class Map extends JPanel { // Карта поля сражения))
    private static final Random RANDOM = new Random();
    private static final int DOT_PADDING = 5;
    private int gameOverType;
    private static final int STATE_DRAW = 0;
    private static final int STATE_WIN_HUMAN = 1;
    private static final int STATE_WIN_AI = 2;
    private static final String MSG_WIN_HUMAN = "Победил игрок";
    private static final String MSG_WIN_AI = "Победил компьютер";
    private static final String MSG_DRAW = "Ничья";
    private final int HUMAN_DOT = 1;
    private final int AI_DOT = 2;
    private final int EMPTY_DOT = 0;
    private int fieldSizeY = 3;
    private int fieldSizeX = 3;
    private char[][] field;
    private int panelWidth; // Ширина поля в пикселях
    private int panelHeight; // Высота поля в пикселях
    private int cellWidth; // Ширина ячейки в пикселях
    private int cellHeight; // Высота ячейки в пикселях

    Map() {
        // Установка цвета фона, чтобы увидеть в окне на белом фоне
        setBackground(Color.BLACK); // Убираем, учимся рисовать
        addMouseListener(new MouseAdapter() {// Добавляем слушателя мышки
            @Override
            public void mouseReleased(MouseEvent e) { // Сработает, когда кнопка мышки будет отжата
                update(e); // Выполнит новое рисование поля
            }
        });
    }
    private void update(MouseEvent e){
        // Вытаскиваем координаты клика:
        int cellX = e.getX() / cellWidth; // берем координату клика, делим на размер ячейки и получаем номер ячейки
        int cellY = e.getY() / cellHeight;
        System.out.printf("x=%d, y=%d\n", cellX, cellY); // распечатать ход, выбор ячейки
        if (!isValidCell(cellX, cellY) || !isEmptyCell(cellX, cellY)) return; // Если что-то пошло не так, игнорим клик, т.е. когда не верный ход
        field[cellY][cellX] = HUMAN_DOT;

        repaint(); // При нажатии мышки рисунок пере рисуется
        // по сути - клик + отрисовка, клик + отрисовка и т.д.
    }
//    private void update(MouseEvent e){
//        if ()
//    }
//    private boolean checkEndGame(int dot, int gameOverType){
//        if (checkWin(dot)) {
//
//        }
//    }

    void startNewGame(int mode, int fSzX, int fSzY, int wLen){
        System.out.printf("Mode: %d;\nSize: x=%d, y=%d;;\nWin Length: %d", mode, fSzX, fSzY, wLen);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }
    private void render(Graphics g){
        /**
         * Пример линии
         * g.setColor(Color.BLACK); // Устанавливаем цвет элемента
         * g.drawLine(0, 0, 100 ,100); // Устанавливаем точку начала и точку конца линии
         */
        panelWidth = getWidth(); // Установка размера панели
        panelHeight = getHeight();
        cellHeight = panelHeight / 3; // Установили размер ячейки относительно игрового поля
        cellWidth = panelWidth / 3;

        g.setColor(Color.BLACK); // Установили цвет линии
        for (int h = 0; h < 3; h++){ // Рисуем линии в высоту
            int y = h * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }
        for (int w = 0; w < 3; w++){ // Рисуем линии в ширину
            int x = w * cellWidth;
            g.drawLine(x, 0, x,  panelHeight);
        }
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if(field[y][x] == EMPTY_DOT) continue;
                if (field[y][x] == HUMAN_DOT) {
                    g.setColor(Color.BLUE);
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING, cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else if (field[y][x] == AI_DOT){
                    g.setColor(new Color(0xff0000));
                    g.fillOval(x * cellWidth + DOT_PADDING, y * cellHeight + DOT_PADDING, cellWidth - DOT_PADDING * 2, cellHeight - DOT_PADDING * 2);
                } else {
                    throw new RuntimeException("Unexpected value " + field[y][x] + " in cell: x=" + x + " y=" + y);
                }
            }
        }
    }

    /**
     * Метод инициализации поля
     */
    private void initMap() {
        fieldSizeY = 3;
        fieldSizeX = 3;
        field = new char[fieldSizeY][fieldSizeX];
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                field[i][j] = EMPTY_DOT;
            }
        }
    }

    /**
     * Метод проверяет, что пользователь попал в ячейку и пустота ли там
     * @param x
     * @param y
     * @return
     */
    private boolean isValidCell(int x, int y){
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }
    /**
     * Метод проверяет, можно ли делать ход в эту ячейку
     */
    private boolean isEmptyCell(int x, int y){
        return field[x][y] == EMPTY_DOT;
    }
    /**
     * Метод хода компьютера
     */
    private void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[x][y] = AI_DOT;
    }
    /**
     * Проверка выигрыша
     */
    private boolean checkWin(char c){
        if (field[0][0] == c && field[0][1] == c && field[0][2] == c) return true;
        if (field[1][0] == c && field[1][1] == c && field[1][2] == c) return true;
        if (field[2][0] == c && field[2][1] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][0] == c && field[2][0] == c) return true;
        if (field[0][1] == c && field[1][1] == c && field[2][1] == c) return true;
        if (field[0][2] == c && field[1][2] == c && field[2][2] == c) return true;

        if (field[0][0] == c && field[1][1] == c && field[2][2] == c) return true;
        if (field[0][2] == c && field[1][1] == c && field[2][0] == c) return true;
        return false;
    }
    /**
     * Метод проверки ничьей
     */
    private boolean isMapFull() {
        for (int i = 0; i < fieldSizeY; i++) {
            for (int j = 0; j < fieldSizeX; j++) {
                if (field[i][j] == EMPTY_DOT) return false;
            }
        }
        return true;
    }
}
