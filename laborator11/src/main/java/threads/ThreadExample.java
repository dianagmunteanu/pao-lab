package threads;

public class ThreadExample extends Thread {

    @Override
    public void run() {
        System.out.println("Inside thread example: " + Thread.currentThread().getName());
    }
}
