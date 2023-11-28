package Lecture;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationException {
    public static void main(String[] args) {
        /**
         * При такой схеме будет ошибка, так как при считывании вторым потоком списка, первый поток
         * зальет туда новые данные и список будет изменен, Java это обрабатывает выбрасывая исключения
         */
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 500; i++) {
//            list.add(i);
//        }
//        Runnable r1 = () -> {
//            for (int i = 0; i < 500; i++) {
//                list.add(i);
//            }
//        };
//        Runnable r2 = () -> {
//            for (Integer value : list) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        };
//        new Thread(r1).start();
//        new Thread(r2).start();
        /**
         * Избегаем ситуации синхронизацией, но долго
         */
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < 200; i++) {
//            list.add(i);
//        }
//        Runnable r1 = () -> {
//            for (int i = 0; i < 200; i++) {
//                synchronized (list){
//                    list.add(i);
//                }
//            }
//        };
//        Runnable r2 = () -> {
//            synchronized (list){
//                for (Integer value : list) {
//                    System.out.print(value + " ");
//                }
//            }
//            System.out.println();
//        };
//        new Thread(r1).start();
//        new Thread(r2).start();
        /**
         * Берем другую коллекцию:
         */
//        List<Integer> list = new CopyOnWriteArrayList();
//        for (int i = 0; i < 200; i++) {
//            list.add(i);
//        }
//        Runnable r1 = () -> {
//            for (int i = 0; i < 200; i++) {
//                list.add(i);
//            }
//        };
//        Runnable r2 = () -> {
//            for (Integer value : list) {
//                System.out.print(value + " ");
//            }
//            System.out.println();
//        };
//        new Thread(r1).start();
//        new Thread(r2).start();
        /**
         * Лучший вариант - честная история))
         */
        Queue<Integer> list = new ConcurrentLinkedDeque<>();
        for (int i = 0; i < 200; i++) {
            list.add(i);
        }
        Runnable r1 = () -> {
            for (int i = 0; i < 200; i++) {
                list.add(i);
            }
        };
        Runnable r2 = () -> {
            for (Integer value : list) {
                System.out.print(value + " ");
            }
            System.out.println();
        };
        new Thread(r1).start();
        new Thread(r2).start();

    }
}
