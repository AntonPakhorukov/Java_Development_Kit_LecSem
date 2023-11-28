/**
 * Создать два класса ObjectA, ObjectB
 * Реализовать класс в котором два потока при запуске провоцируют DeadLock
 * для объектов ObjectA, ObjectB
 */
package Seminar;
public class Task_01 {
    static Object objectA = new Object();
    static Object objectB = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                workThread1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                workThread2();
            }
        });
        thread1.start();
        thread2.start();
    }
    public static void workThread1(){
        synchronized (objectA){
            try {
                System.out.println("Поток 1 захватил объект А");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (objectB) {
                System.out.println("Поток 1 захватил объект В");
            }
        }
    }
    public static void workThread2(){
        synchronized (objectB){
            System.out.println("Поток 2 захватил объект В");
            synchronized (objectA){
                System.out.println("Поток 2 захватил объект А");
            }
        }
    }
}
