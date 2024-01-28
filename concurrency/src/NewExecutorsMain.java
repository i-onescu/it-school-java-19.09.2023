package concurrency.src;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewExecutorsMain {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Runnable runnable = () -> System.out.println("hello");

        executor.execute(runnable);
        Thread.sleep(1);

        executor.shutdown();
        System.out.println("Hello");
    }
}
