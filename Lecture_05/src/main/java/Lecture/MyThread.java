package Lecture;

public class MyThread extends Thread{
    @Override
    public void run(){
        System.out.println("1. Welcome to MyThread - " + Thread.currentThread().toString());
    }

}
