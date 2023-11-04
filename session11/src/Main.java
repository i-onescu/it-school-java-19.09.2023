import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Wrapper class, holds primitive values and translates them in objects.
        Integer x = 1;

        // other ways of initializing Integers, using the valueOf() overloadings.
        Integer y = Integer.valueOf(1);
        Integer z = Integer.valueOf("1");

        Character character = 'c';
        char c = 'v';

        int[] ints = new int[10];

        // initializing an instance of ArrayList using abstraction as the data type is of type List
        List<Integer> integers = new ArrayList<>();

        // this is how you add elements in the list
        integers.add(1);
        integers.add(5);

        // lists provide default impl of .toString(), so we will have by default
        // an user friendly text representation
        System.out.println(integers);

        // this is how you remove an element from a list.
        // we need to wrap it in an Integer instance, because it will be confused by
        // another implementation calling the remove on a specific index,
        // and this might lead to an index out-of-bounds exception.
        integers.remove(Integer.valueOf(5));
        System.out.println(integers);

        //integers.size() == 0;
        //integers.isEmpty();

        integers.add(5);
        integers.add(6);
        integers.add(7);

        // this is how you iterate through a list
        // 1. fori
        for (int i = 0; i < integers.size(); i++) {
            Integer integer = integers.get(i);
            System.out.println(integer);
        }
        System.out.println("========");

        // 2. for-each loop
        for (Integer integer : integers) {
            System.out.println(integer);
        }
        System.out.println("========");

        // 3. .forEach() method
        integers.forEach(System.out::println);
        System.out.println("========");

        // 4. Iterator
        Iterator<Integer> iterator = integers.iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }

        // avoid, it will throw an exception
        // because we try to remove the object we are iterating through
//        for (Integer integer : integers) {
//            integers.remove(integer);
//        }

        System.out.println("========");

        // This implementation is faster on random addition and removal of elements.
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(1);
        linkedList.add(4);
        linkedList.add(2);
        linkedList.add(5);

        System.out.println(linkedList.getFirst());

        // Sets keep only unique elements
        // hash set is a used in the majority of real-life cases
        // it provides quick access to elements by using the hash table data structure
        Set<Integer> setOfIntegers = new HashSet<>();

        setOfIntegers.add(1);
        setOfIntegers.add(1);
        setOfIntegers.add(1);
        setOfIntegers.add(1);
        setOfIntegers.add(1);

        System.out.println(setOfIntegers);

        // linkedhashset keeps the order of addition/insertion
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // We can use any object between the diamond operator
        // if we want to use sets, we can rely on default .equals() implementation,
        // but it checks only for memory address reference
        Set<Book> setOfBooks = new HashSet<>();

        // in case of default impl of equals() we will have a set full of
        // basically the same book, but we would like to keep only one book based on the book's name
        setOfBooks.add(new Book("book1"));
        setOfBooks.add(new Book("book1"));
        setOfBooks.add(new Book("book1"));
        setOfBooks.add(new Book("book1"));

        System.out.println(setOfBooks);

        // TreeSet is a special kind of set, as it keeps the elements sorted.
        // It's important to understand that the type passed to the diamond operator,
        // must implement the interface called Comparable.
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(5);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(6);
        treeSet.add(1);

        System.out.println(treeSet);

        System.out.println("====== treeset");

        // note that the equals and hashcode methods are not involved in
        // treeSet addition, it will rely only on compareTo.
        // So if there is at least another element in the set
        // that will return 0 when the compareTo method is called, it won't be added.
        TreeSet<Book> bookTreeSet = new TreeSet<>();

        // based on the compareTo impl from Book class,
        // we will have 3 books with the name 'book5'
        bookTreeSet.add(new Book("book5", 10));
        bookTreeSet.add(new Book("book2", 5));
        bookTreeSet.add(new Book("book6", 7));
        bookTreeSet.add(new Book("book5", 15));
        bookTreeSet.add(new Book("book5", 15));
        bookTreeSet.add(new Book("book5", 3));

        System.out.println(bookTreeSet);

        // this is a set of Enums.
        // the enums are a list of constant values.
        EnumSet<BookType> enumSet = EnumSet.of(BookType.ACTIUNE, BookType.PSHIHOLOGIE);
        enumSet.forEach(System.out::println);

        System.out.println("====== hashMap");

        // The maps are a data structure which stores key-value pairs.
        // we might have any combination of key-value in terms of passed classes.
        // you need to add an implementation for equals and hashcode for the class passed as key.
        Map<Integer, String> map = new HashMap<>();

        // if the key is not present in the map, the pair will be added.
        map.put(1, "Bogdan");
        map.put(2, "Nicoleta");

        System.out.println(map);

        // if the key exists, the old value will be overwritten.
        map.put(1, "John");

        System.out.println(map);

        Map<String, Book> myMapOfBooks = new HashMap<>();

        myMapOfBooks.put("Author 1", new Book("book1"));
        myMapOfBooks.put("Author 2", new Book("book2"));
        myMapOfBooks.put("Author 3", new Book("book1"));

        System.out.println(myMapOfBooks);

        // it calls the equals method.
        System.out.println(myMapOfBooks.containsValue(new Book("book1")));

        System.out.println("====== for-each");

        // ways of iterating through a map.
        // because the map is not extending Iterable, it is not supported
        // as being passed to for each statement.

        // 1. keySet and for-each
        Set<String> authors = myMapOfBooks.keySet();
        for (String author : authors) {
            Book book = myMapOfBooks.get(author);
            System.out.println(book);
        }

        System.out.println("====== entryset");

        // 2. entry set
        Set<Map.Entry<String, Book>> entries = myMapOfBooks.entrySet();
        for (Map.Entry<String, Book> entry : entries) {
            System.out.println(entry.getValue());
        }

        System.out.println("====== forEach method");

        // 3. forEach method
        myMapOfBooks.forEach((key, value) -> System.out.println(value));

        System.out.println("====== linkedhashmap");

        // LinkedHashMap will keep the order of insertion of elements.
        LinkedHashMap<String, Book> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("Author 1", new Book("book1"));
        linkedHashMap.put("Author 2", new Book("book2"));
        linkedHashMap.put("Author 3", new Book("book1"));
        System.out.println(linkedHashMap);

        System.out.println("====== treemap");

        // TreeMap will sort the keys in the natural order,
        // the same principle used in TreeSet.
        // the compareTo method is used.
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(5, "John");
        treeMap.put(2, "Bogdan");
        treeMap.put(1, "Jane");
        System.out.println(treeMap);

        ArrayList<Object> objects = new ArrayList<>();

    }
}