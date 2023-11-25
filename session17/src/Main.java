import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);

        // using the 'stream()' method, we can use the 'numbers' list as a data source
        // we convert the list into a stream
        Stream<Integer> integerStream = numbers.stream()
                // the peek method will execute a consumer on each element from the data source
                .peek(Main::doSomethingWithValue)
                // this method will filter out from the datasource the elements not matching the predicate
                .filter(x -> x % 2 == 1)
                // we can use peek as many times we want as it returns a Stream
                // leading to chain method callings
                .peek(System.out::println)
                .filter(x -> x < 3)
                .peek(System.out::println);

        // terminal operations make the stream unusable anymore
        // an example of such a terminal operations is the collecting one
        // we can collect the resulting datasource into a list using either .toList method
        // or the .collect(Collectors.toList());
        List<Integer> oddNumbers = integerStream.toList();

        System.out.println(oddNumbers);


        List<String> strings = List.of("John", "Joe", "Jay", "Bogdan");
        strings.stream()
                // you can sort the elements in an array using chaining comparators
                // you can specify the sorting condition, in our case the strings by length
                .sorted(Comparator.comparing(String::length)
                        // if two elements have the same length
                        // then rely on the natural ordering of strings (ascii codes)
                        .thenComparing(x -> x))
                // another terminal operation is .forEach() which is similar to a for loop
                .forEach(System.out::println);

        List<Book> books = List.of(new Book("book1"),
                new Book("boook1"),
                new Book("booook1"));
        books.stream()
                // sorted will rely on the natural ordering of the datasource type.
                // in order to use .sorted() you need to implement Comparable in that type.
                .sorted()
                .forEach(System.out::println);

        strings.stream()
                // map can transform the elements from the datasource in any other data type
                .map(String::length)
                // now in the forEach, the mapped elements will be printed.
                .forEach(System.out::println);

        Integer sum = numbers.stream()
                // Performs a reduction on the elements of this stream,
                // using the provided identity value and an associative accumulation function,
                // and returns the reduced value.
                // the first parameter is the initial value and each iteration will increase the identity.
                .reduce(0, Integer::sum);

        System.out.println(sum);

        doSomething(5);
        String stringulMeu = doSomething();


        List<String> stringList = List.of("John", "Joe", "Jay", "Bogdan");
        Optional<String> first = stringList.stream()
                .filter(s -> s.length() == 2)
                .findFirst();

        if (first.isPresent()) {
            System.out.println(first.get());
        } else {
            System.out.println("There is no name with length of 3");
        }
    }

    private static boolean compareMe() {
        return (1 > 2) || (2 < 3) && (5 == 5)
                ? true
                : false;
    }

    private static void doSomething(Integer x) {
        System.out.println("do something" + x);
    }

    private static String doSomething() {
        return "doSomething";
    }

    static class Book implements Comparable<Book> {
        private String name;

        public Book(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Book book) {
            System.out.println("salut");
            if (this.name.length() > book.name.length()) {
                return 1;
            } else if(this.name.length() == book.name.length()) {
                return 0;
            }
            return -1;
        }

        @Override
        public String toString() {
            System.out.println("pa");
            return "Book{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    private static void doSomethingWithValue(Integer someValue) {
        if (someValue > 0) {
            System.out.println("greater than 0");
        } else {
            System.out.println("less than 0");
        }
    }
}
