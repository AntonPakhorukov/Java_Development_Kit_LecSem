package Seminar.SemTask_03;

import java.util.concurrent.CountDownLatch;

public class Race implements Runnable{
    private CountDownLatch startSignal;
    private CountDownLatch finishSignal;
    private CountDownLatch readySignal;

    public Race(CountDownLatch readySignal, CountDownLatch startSignal, CountDownLatch finishSignal) {
        this.readySignal = readySignal;
        this.startSignal = startSignal;
        this.finishSignal = finishSignal;
    }
    @Override
    public void run() {
        try {
            readySignal.await();
            System.out.println("To start!");
            Thread.sleep(200);
            System.out.println("Attention!");
            Thread.sleep(200);
            System.out.println("Start!");
            startSignal.countDown();
            finishSignal.await();
            System.out.println("Run is end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
