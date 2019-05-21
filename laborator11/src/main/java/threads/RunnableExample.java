package threads;

public class RunnableExample implements Runnable{
    @Override
    public void run() {
        System.out.println("Inside runnable: " + Thread.currentThread().getName());
    }
}
