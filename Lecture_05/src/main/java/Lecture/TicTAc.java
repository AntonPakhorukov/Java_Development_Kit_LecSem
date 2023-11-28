package Lecture;

public class TicTAc implements Runnable{
    private final String BRACKET;
    private final Object monitor;

    public TicTAc(String bracket) {
        BRACKET = bracket;
        this.monitor = TicTAc.class;
    }

    @Override
    public void run() {
        while (true){
            synchronized (monitor){ // Благодаря этому будут печать скобки по очереди
                System.out.print(BRACKET);
                try {
                    Thread.sleep(300);
                    monitor.notify(); // говорим монитору разбуди второй поток
                    monitor.wait(); // а сам усни
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
