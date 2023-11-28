package Lecture;

import java.util.concurrent.CountDownLatch;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /**
         * Создание потоков
         */
//        MyThread myThread = new MyThread();
//        myThread.start();
//        MyRunnable runnable = new MyRunnable();
//        Thread thread2 = new Thread(runnable);
//        thread2.start();
//        for (int i = 0; i < 3; i++) {
//            new MyThread().start();
//
//        }
//
//        for (int i = 0; i < 3; i++) {
//            new Thread(() -> {
//                System.out.println("3. Lambda " + Thread.currentThread());
//            }).start();
//        }
        /**
         * Сервисный поток
         */
        Thread tic = new Thread(new TicTAc("["));
        Thread tac = new Thread(new TicTAc("]"));
//        tic.setDaemon(true ); // Deamon thread - это сервисный поток, то есть если поток main завершился,
        // то и все остальные тоже
//        tac.setDaemon(true);
        tic.start();
        tac.start();
        /**
         * JOIN
         */
//        for (int i = 0; i < 5; i++) {
//            Thread thr4 = new MyThread();
//            thr4.start();
//            thr4.join(); // потоки будут открываться только после завершения предыдущего потока, тем самым
//            // мы убили многопоточность)) но поддержали порядок вызова
//        }
//
//        for (int i = 0; i < 5; i++) {
//            Thread thr5 = new Thread(() -> {
//                System.out.println("3. Lambda " + Thread.currentThread());
//            });
//            thr5.start();
////            thr5.join();
//        }
        /**
         * Ожидание завершения потоков
         */
//        long start = System.currentTimeMillis();
//        Task task = new Task(0);
//        CountDownLatch cdl = new CountDownLatch(3); // примитив синхронизации, который позволяет
//        // нам ждать на какой-то строчке до тех пор, пока не выполнятся потоки
//        task.setCdl(cdl); // передали в Task cdl
//        for (int i = 0; i < 3; i++) {
//            Thread thread = new Thread(task);
//            thread.start();
////            thread.join();
////            System.out.println(task.getValue());
//        }
//        cdl.await(); // программа будет ждать, пока все потоки не выполнят у себя countDown
//        System.out.println(task.getValue());
//        long finish = System.currentTimeMillis();
//        System.out.println(finish - start);
        /**
         * Синхронизировать потоки можно добавив synchronized в inc
         */

    }

}
