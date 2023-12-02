package MyTesting;

import java.util.concurrent.CountDownLatch;

public class Example_01 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Count(20, 10));
        Thread thread2 = new Thread(new Count(10, 0));
        thread1.start();
        thread2.start();
    }
    public static class Count implements Runnable{
        private int count;
        private int countEnd;

        public Count(int count, int countEnd) {
            this.count = count;
            this.countEnd = countEnd;
        }

        @Override
        public void run() {
            changeCount(count, countEnd);
        }
        public static synchronized void changeCount(int count, int countEnd) {
            while (count > countEnd) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + ": " + count--);
            }
        }
    }
}
