package Seminar.SemTask_03;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable{
    private String name;
    private CountDownLatch readySignal;
    private CountDownLatch startSignal;
    private CountDownLatch finishSignal;
    public Runner(String name, CountDownLatch readySignal, CountDownLatch startSignal, CountDownLatch finishSignal) {
        this.name = name;
        this.startSignal = startSignal;
        this.finishSignal = finishSignal;
        this.readySignal = readySignal;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(new Random().nextInt(1000, 3000));
            System.out.println("Runner " + this.name + " to start!");
            readySignal.countDown();
            startSignal.await();
            System.out.println("Runner " + this.name + " is run!");
            Thread.sleep(new Random().nextInt(3000, 5000));
            System.out.println("Runner " + this.name + " is finish!");
            finishSignal.countDown();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
