package Seminar.SemTask_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 *
 */
public class Main {
    private static final int COUNT_RUNNERS = 3;
    public static void main(String[] args) {
        CountDownLatch readySignal = new CountDownLatch(COUNT_RUNNERS);
        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch finishSignal = new CountDownLatch(COUNT_RUNNERS);

        List<Runner> runners = new ArrayList<>(Arrays.asList(
                new Runner("Alex", readySignal, startSignal, finishSignal),
                new Runner("Egor", readySignal, startSignal, finishSignal),
                new Runner("Tom", readySignal, startSignal, finishSignal)
        ));
        new Thread(new Race(readySignal, startSignal, finishSignal)).start();
        for (Runner runner : runners) {
            new Thread(runner).start();
        }
    }
}
