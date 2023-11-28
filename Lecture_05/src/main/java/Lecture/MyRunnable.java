package Lecture;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("2. Welcome to MyRunnable - " + Thread.currentThread().getName());
    }
}
