package concurrency.src;

public class RunnableMain {

    public static void main(String[] args) throws InterruptedException {
        CustomRunnable customRunnable = new CustomRunnable();
//        Thread thread = new Thread(customRunnable);

        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("Iteration thread 1 no: " + (i + 1));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
            }
        });
        Thread thread2 = new Thread(customRunnable);

        thread.start();
        thread2.start();

        thread2.yield();

        thread2.join();

//        Thread.sleep(500);
        System.out.println("Hello, from main thread.");
    }
}

class CustomRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration thread 2 no: " + (i + 1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}
