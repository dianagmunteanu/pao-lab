package threads;

public class MainThreads {

    public static void main(String[] args){
        System.out.println("Main : " + Thread.currentThread().getName());
        Runnable runnable = new RunnableExample();
        runnable.run();

        Thread thread = new Thread(runnable);

        System.out.println("Starting Thread...");
        thread.start();

        new ThreadExample().start();
        System.out.println("Main : " + Thread.currentThread().getName());
    }
}
