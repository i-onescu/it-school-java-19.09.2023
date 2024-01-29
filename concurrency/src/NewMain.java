package concurrency.src;

import java.util.concurrent.atomic.AtomicInteger;

public class NewMain {

    public static void main(String[] args) {
        AtomicInteger i = new AtomicInteger(10);

        int i1 = i.addAndGet(10);
        int i2 = i.getAndAdd(10);

        while (i.get() < 100) {
            System.out.println("salut");
            i.incrementAndGet();
        }

        System.out.println(i1);
        System.out.println(i2);
    }
}
