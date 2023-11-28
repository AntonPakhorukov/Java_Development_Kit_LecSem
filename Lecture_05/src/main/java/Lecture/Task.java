package Lecture;

import java.util.concurrent.CountDownLatch;

public class Task implements Runnable{
    private /*final*/ int value;
    private CountDownLatch cdl;
    public Task(int value) {
        this.value = value;
    }

    public void setCdl(CountDownLatch cdl) {
        this.cdl = cdl; // передаем cdl
    }

    public synchronized void inc() { // synchronized - синхронизирует работу потоков -> расчет верный
        value++;
        /**
         * Аналогичная запись вне названия метода:
         * synchronized (Task.class){
         *     value++;
         * }
         * Синхронизация на уровне классов
         */
    }

    public int getValue() {
        return value;
    }

    @Override
    public void run() {
        /*System.out.println(value);*/
        for (int i = 0; i < 100000; i++) {
            inc();
        }
        cdl.countDown(); // сообщить о завершении
    }

    @Override
    public String toString() {
        return String.format("(%s)", value);
    }
}
