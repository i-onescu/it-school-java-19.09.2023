import java.util.*;

public class Main {


    public static void main(String[] args) {

        // primitive variable
        int primitive = 42;

        // wrapped primitive in an object instance,
        // we can initialize the Integer instance by simply assign the primitive value to it.
        // This process is called autoboxing, because Java is wrapping the primitive into an Integer object behind the scenes.
        Integer wrappedPrimitive = primitive;

        // Since Integer is an object, it inherits the Object class, so we can still use the polymorphism principle
        Object myObj = wrappedPrimitive;

        // The below line of code won't work because there are two automatic procedures that should take place,
        // one being the casting and the other one to be the autoboxing.
        // Float testFloat = primitive;

        // here is an example of casting first and leaving the autoboxing on Java.
        Float myFloat = (float) primitive;
        Float myFloatSecond = 56f;

        System.out.println(wrappedPrimitive);

        int[] myArr = new int[]{1, 2, 3};
        for (int i = 0; i < myArr.length; i++) {
            System.out.println(myArr[i]);
        }

        // for-each loop or enhanced loop syntax
        for (int i : myArr) {
            System.out.println(i);
        }

        // This is the syntax of defining a List, in our case, the concretization is ArrayList
        // if we use the polymorphism generalization, we won't have access to the methods provided by ArrayList,
        // but only on the overridden methods.
        // the ArrayList implementation is backed by an actual array, but it is enhanced with dynamic size.
        List<Integer> myList = new ArrayList<>();

        // List keeps the order by default, the same does the ArrayList.
        // if we add an element, it is automatically added at the end of the list.
        myList.add(5); // list becomes [5]

        // we can add elements on a specific position, meaning that
        // the rest of elements starting with that position will be moved to right.
        myList.add(0, 10); // list becomes [10, 5]

        // we have a default implementation for the toString() method
        // and the displayed elements will be [10, 5]
        System.out.println(myList);

        // the Lists allow duplicates
        List<Integer> bigList = new ArrayList<>();
        bigList.add(5);
        bigList.add(100);
        bigList.add(10);
        bigList.add(150);
        bigList.add(10);
        //bigList.addAll(myList);
        System.out.println(bigList);

        // There are two implementations of remove() method.
        // one is removing on a given index, and the other one is removing the first element found equal to the passed object.
        // by passing a primitive it will count it as being the position in the list
        // be careful, because this might end up in throwing IndexOutOfBoundsException
        // ----bigList.remove(10);

        // in order to avoid this issue, we can remove the first occurrence in the list of integers this way
        // because now we passed an object, not an int primitive value.
        bigList.remove(Integer.valueOf(10));

        // we can also remove all occurrences of a given list of numbers.
        bigList.removeAll(myList);
        System.out.println(bigList);

        // indexOf() method will return the position for a given element.
        // if the element does not exist in the list, then the returned value is -1.
        int i = bigList.indexOf(150);
        System.out.println("i = " + i);

        if (bigList.contains(150)) {
            System.out.println("it contains the value");
        } else {
            System.out.println("nope");
        }

        // LinkedList is backed by a doubly linked list
        // meaning that we always have access to the head of the list and the tail.
        // each element keeps the reference to the previous and the next element.
        // it is useful when we want to make changes in the middle of the list,
        // because the elements are not required to be shifted.
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(0, 5);
        System.out.println(linkedList);

        // Vector is also backed by an array.
        // it is the synchronized version of ArrayList
        // synchronized means that it acquires a lock in the resource and only a single thread can access it at a time.
        List<Integer> myVector = new Vector<>();
        myVector.add(1);

        // Sets are a different subinterface of Collection interface;
        // they provide assurance that there are no duplicates, so only unique values
        // we must implement the equals() and hashCode() methods in our classes.
        // The implementation now is HashSet, and it's backed on a hash table.
        // A hash is a 'unique' value returned based on a hashing algorithm.
        // it works as an index position, but provides better possibilities for editing the set.
        Set<Integer> myHashSet = new HashSet<>();
        int x = 10;
        float y = 10;

        // autoboxing performed, the Collections can't store primitives.
        myHashSet.add(x);
        // the same scenario, we must first cast to the required type, and the autoboxing is performed behind the scenes.
        myHashSet.add((int) y);
        myHashSet.add(10);
        myHashSet.add(10);
        myHashSet.add(15);

        System.out.println(myHashSet);

        // here we have a set of a custom class called 'Book'
        // as already stated, this book class must add custom implementation (override) for equals and hashCode methods
        // these methods are inherited from the Object class.
        Set<Book> setOfBooks = new HashSet<>();

        Book bookTest = new Book("book0");
        // here we have a shallow copy.
        // meaning that both variables refer to the same memory address.
        Book bookCopy = bookTest;

        // if we add both, we are lucky enough that only one element is added to the list,
        // as the default implementation of equals is checking only for the memory address.
        setOfBooks.add(bookCopy);
        setOfBooks.add(bookTest);

        boolean equals1 = bookTest.equals(Integer.valueOf(14));
        boolean equals = bookTest.equals(bookCopy);

        // if we don't provide any implementation for the equals and hashcode methods,
        // we can have our set full of the book
        // we will continue the add the same book on each line,
        // but because we always allocate new memory for each object, the default implementation of
        // equals and hashcode don't cover us and will fail the so-called 'business validation'.
        // by business validation, I mean the validation I want to take place.
        // in this case, I consider that two books are 'equal' if they have the same name.
        // thus, I would like to have in the end only two elements a book with the name 'book0' and one with 'book1'
        setOfBooks.add(new Book("book1"));
        setOfBooks.add(new Book("book1"));
        setOfBooks.add(new Book("book1"));
        setOfBooks.add(new Book("book1"));
        setOfBooks.add(new Book("book1"));

        System.out.println(setOfBooks);
    }
}
