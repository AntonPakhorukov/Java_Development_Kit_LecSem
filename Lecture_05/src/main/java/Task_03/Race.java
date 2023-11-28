package Task_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race extends Thread{
    private List<Runner> runners;
    private CountDownLatch cdl;
    public Race() {
        this.cdl = new CountDownLatch(3);
        this.runners = new ArrayList<>(3);
        runners.add(new Runner("Alex", cdl));
        runners.add(new Runner("Egor", cdl));
        runners.add(new Runner("Tom", cdl));
    }

    @Override
    public void run() {
        try {
            goOnStart();
            cdl.await();
            goAll();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void goAll() throws InterruptedException{
        sleep(1000);
        System.out.println("To start!");
        sleep(1000);
        System.out.println("Attention!");
        sleep(1000);
        System.out.println("Run!");
        for (Runner runners : runners) {
            runners.go();
        }
    }
    private void goOnStart() {
        for (Runner runners : runners) {
            runners.start();
        }
    }
}
