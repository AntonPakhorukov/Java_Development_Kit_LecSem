package MyTesting;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        myThread.start();

        Thread thread = new Thread(new Runner());
        thread.start();
        Thread.sleep(1000);
        myThread.shutdown();
    }
}
class MyThread extends Thread{
    private static boolean check = true;
    public void run(){
        while (check){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("MyTesting.MyThread: " + Thread.currentThread().getName());
        }
    }
    public void shutdown(){
        this.check = false;
        System.out.println("MyTesting.MyThread is shutdown");
    }
}
class Runner implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("MyTesting.Runner: "+ i + " " + Thread.currentThread().getName());
        }
    }
}
