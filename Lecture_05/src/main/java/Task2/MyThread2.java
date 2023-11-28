package Task2;

/**
 * Создайте два потока A и B.
 * Поток A меняет значение Boolean переменной switcher с задержкой 1000 миллисекунд
 * (true в состояние false и наоборот).
 * Поток B ожидает состояния true переменной switcher и выводит на консоль обратный отсчет от 100
 * с задержкой 100 миллисекунд и приостанавливает свое действие, как только поток
 * A переключит switcher в состояние false.
 * Условием завершения работы потоков является достижение отсчета нулевой отметки.
 * Можно воспользоваться синхронизацией для управления значения переменной или volatile
 */
public class MyThread2 extends Thread{
    private MyProgramState state;

    public MyThread2(MyProgramState state) {
        this.state = state;
    }

    @Override
    public void run() {
        int i = 100;
        while (!state.isFinish() && i > 0){
            if (state.isSwitcher()) {
                System.out.println(i--);
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        state.setFinish(true);
    }
}
