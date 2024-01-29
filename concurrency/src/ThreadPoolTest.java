package concurrency.src;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolTest {

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(2,
                        3,
                        1,
                        TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<>(1));

        Runnable myRunnable1 = () -> {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
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

        threadPoolExecutor.execute(myRunnable1);
        threadPoolExecutor.execute(myRunnable2);
        threadPoolExecutor.execute(myRunnable3);
        threadPoolExecutor.execute(myRunnable4);
        threadPoolExecutor.execute(myRunnable5);

        threadPoolExecutor.shutdown();

        ReentrantLock reentrantLock = new ReentrantLock();
    }
}



