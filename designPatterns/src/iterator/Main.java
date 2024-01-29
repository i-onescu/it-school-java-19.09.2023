package designPatterns.src.iterator;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer, String> students = new HashMap<>();

        students.put(1, "John");
        students.put(2, "Daniel");
        students.put(3, "Simon");

        students.forEach((k, v) -> System.out.println("Key: " + k + "; Value: " + v));

        Set<Map.Entry<Integer, String>> entries = students.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entries.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, String> elem = iterator.next();
            System.out.println("Key: " + elem.getKey() + "; Value: " + elem.getValue());
        }
    }
}
