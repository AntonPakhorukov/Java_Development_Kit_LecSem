package Lecture;

import java.util.Scanner;

import static java.lang.System.in;

public class StatsHelper {
    private static int cnt = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread threadRead = new Thread(() -> {
            Scanner scan = new Scanner(in);
            while (scan.hasNextLine()){
                scan.nextLine();
                cnt++;
            }
        });
        threadRead.setDaemon(true);
        threadRead.start();
        while (true){
            System.out.println(cnt + " messages inputted by user ");
            Thread.sleep(1000);
        }
    }
}
