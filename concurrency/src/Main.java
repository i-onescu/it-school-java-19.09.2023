package concurrency.src;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Thread thread = new Thread(new CustomRunnable());
//        thread.start();
//
//        //thread.join();

        CustomThread customThread = new CustomThread();
        customThread.start();
        customThread.setDaemon(true);

        // 1 s -> 1000 ms
        Thread.sleep(500);
        System.out.println("Hello, from main thread.");
    }
}

class CustomThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration no: " + (i + 1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException exception) {
                exception.printStackTrace();
            }
        }
    }
}




