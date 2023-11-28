package Task1;
import Task1.MyThread;
public class Main {
    public static void main(String[] args) {
        Friend friend1 = new Friend("Alex");
        Friend friend2 = new Friend("Egor");

        MyThread thread1 = new MyThread(friend1, friend2);
        MyThread thread2 = new MyThread(friend2, friend1);

        thread1.start();
        thread2.start();

        System.out.println("Work is finish");
    }
}
