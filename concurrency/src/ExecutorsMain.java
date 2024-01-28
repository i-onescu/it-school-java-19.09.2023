package concurrency.src;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsMain {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Runnable myRunnable1 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello, from Runnable implementation 1.");
        };
        Runnable myRunnable2 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello, from Runnable implementation 2.");
        };
        Runnable myRunnable3 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello, from Runnable implementation 3.");
        };
        Runnable myRunnable4 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello, from Runnable implementation 4.");
        };
        Runnable myRunnable5 = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Hello, from Runnable implementation 5.");
        };

        executor.execute(myRunnable1);
        executor.execute(myRunnable2);
        executor.execute(myRunnable3);
        executor.execute(myRunnable4);
        executor.execute(myRunnable5);
        executor.shutdown();
        System.out.println("Main thread...");
    }
}


