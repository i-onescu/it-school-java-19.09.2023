// import statements to bring the required classes.
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String... args) {

        // There are various ways to initialize an array
        // As the array is interpreted as being an object,
        // the default values for the allocated values are 0 for numeric values,
        // null for object types and
        // false for boolean.
        int[] defaultArr = new int[10]; // defaultArr[0] = 0; defaultArr[1] = 0 .... defaultArr[9] = 0;
        int[] arr = new int[] {1, 2, 3};
        int[] array = {1, 2, 3};

        // In order to access an element within the array, you must use the [] operator together with the required position.
        // The indexes in the array start with 0 and end with array length - 1.

        // This code will print all elements within the array.
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // If we try to access an element which is out of array bounds,
        // Java will throw and exception called ArrayIndexOutOfBounds
        // letting you know that the index is either negative or greater than array length.
        // arr[0] = 0;
        // arr[1] = 0;
        // arr[2] = 0;
        // arr[3] exceptie

        // The 'defaultArr' variable was the array initialized with 0 values.
        // We can overwrite any element within the array as follows:
        for (int i = 0; i < defaultArr.length; i++) {
            // Considering that the defaultArr's length is 10, the array will contain elements from 1 to 10.
            defaultArr[i] = i + 1;
            System.out.println(defaultArr[i]);
        }

        // As the array is considered an object in Java, by using the '.' operator will expose either methods or fields available.
        int length = arr.length;

        // this will create an arr clone in a separate memory space in heap.
        // thus, by changing any value in 'clone' array will not affect the 'arr' array.
        int[] clone = arr.clone();
        clone[0] = 2; // this will lead in clone[0] = 2; and arr[0] = 1; not changing the value in 'arr' array.

        // multidimensional arrays allow the user to create arrays of arrays.
        int[] ints = {1, 2, 3};
        int[][] matrix = new int[][] {
                ints,
                new int[] {4, 5, 6},
                {7, 8, 9},
                new int[3]
        };

        // this is how we iterate a matrix
        // the first for will iterate over each row (or array).
        // we call the 'i' index the one that iterates the rows.
        for (int i = 0; i < matrix.length; i++) {
            // the second for will use another index which will iterate through the row (or array).
            // we call the 'j' index the one that iterates the columns.
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("matrix[%d][%d] = %d;\n", i, j, matrix[i][j]);
            }
        }

        // 3. Write a Java program to test if an array contains a specific value.
        // Initialize an array.
        int[] exercise3Arr = new int[100];

        // Initialize the values within the array with even numbers.
        for (int i = 0; i < exercise3Arr.length; i++) {
            exercise3Arr[i] = i * 2;
        }

        // We iterate the entire array, and if we find 98, we will print in the console that we found it.
        // We can also use a boolean variable to let us know if we found the value or not.
        boolean isFound = false;

        for (int i = 0; i < exercise3Arr.length; i++) {
            if (exercise3Arr[i] == 98) {
                isFound = true;
                System.out.println("We found 98");
                break;
            }
        }

        // If we found the value above, then we set it to true.
        // In case isFound is still false,
        // then the !isFound operation will be evaluated as true
        // and print that we didn't find the number within the array.
        if (!isFound) {
            System.out.println("We didn't find it.");
        }

        // The above solution might look simple, but in a very big array altogether with other operations might be too slow.
        // The easiest way would be to perform a binary search within the array.
        // As prerequisites the array must be sorted before that, but in the manner we initialized it, we already have it sorted.
        // In order to sort it (just to be sure) we can do:
        Arrays.sort(exercise3Arr);
        // The following line of code will help us to find out the position in the array where our number is placed.
        int index = Arrays.binarySearch(exercise3Arr, 98);
        // As we have the first 100 even numbers, the printed value would be 49.
        System.out.println(index);

        // 4. Write a Java program to remove a specific element from an array.
        Scanner scanner = new Scanner(System.in);

        // This 'Random' class helps us to generate random values.
        // Learn it as it is.
        Random random = new Random();
        System.out.print("Type in the array's length: ");

        int n = scanner.nextInt();
        int[] exercise4Arr = new int[n];

        // We will initialize the exercise4Arr with random values.
        for (int i = 0; i < exercise4Arr.length; i++) {
            // Here we will generate random numbers within '0' inclusive and '100' exclusive.
            exercise4Arr[i] = random.nextInt(100);
            System.out.print(exercise4Arr[i] + ", ");
        }

        System.out.println();
        System.out.print("Type in the number to be deleted: ");

        int noToBeDeleted = scanner.nextInt();
        // There are two alternatives (or more) in solving this exercise.
        // Both alternatives involve the creation of a new array,
        // because, as we know, we can't change the length of an array.
        // So the common practice would be to create a new array with the new desired length, in our case 1 less than the initial one.
        int[] newArr = new int[exercise4Arr.length - 1];

        // Also, we will need a new index to keep track on the current length of newArr array.
        // There can be some cases when the number of actual non-zero elements is not equal to the array size.
        // And in such scenario 'k' will be like the number of non-zero elements.
        int k = 0;

        // we will iterate the initial array
        for (int i = 0; i < exercise4Arr.length; i++) {
            // if the current number is not equal with the number to be deleted, we will add it in the new array.
            if (exercise4Arr[i] != noToBeDeleted) {
                newArr[k] = exercise4Arr[i];
                // don't forget to increment 'k'.
                // the increment would also work in this form:
                // newArr[k++] = exercise4Arr[i]; this will first assign to newArr[k] the exercise4Arr[i] value, and the increment 'k'.
                k++;
                // here we will print the newly added element, so as the k stands for length then we need to access it using 'k - 1'.
                System.out.print(newArr[k - 1] + ", ");
            }
        }

        // Another alternative would be to firstly search the array (which must be sorted),
        // and then if the element is present within the array to perform the same operation as the above one.
        // This solution might be faster in some scenarios.
        int pos = Arrays.binarySearch(exercise4Arr, noToBeDeleted);

        // if the element is not found, it returns a negative number, or the array is not sorted will return an undefined result.
        if (pos > 0) {
            System.out.println("deleting...");
            int[] secondNewArray = new int[n - 1];
            int c = 0;

            for (int i = 0; i < exercise4Arr.length; i++) {
                // now we compare with the position, not with the actual value in the array.
                if (i != pos) {
                    secondNewArray[c++] = exercise4Arr[i];
                    System.out.print(secondNewArray[c - 1] + ", ");
                }
            }
            System.out.println();
        }

        // This line of code will allocate memory in the String Pool
        String s = "test"; // String Pool

        // This line of code will treat the s2 as being a regular Java object and will allocate memory within the Heap Space.
        String s2 = new String("test");

        // As Strings are objects and all the information we have within a method are retrieved from Stack,
        // we know that in Stack we have only memory addresses which point to actual data in the Heap Space.
        // So the evaluation of '==' operator is checking if the addresses in equal, not the character representation.
        if (s == s2) {
            System.out.println("s and s2 are equal.");
        } else {
            // This will be printed as 's' points to a "test" value stored in the String Pool.
            // While 's2' points to a "test" value stored somewhere in the Heap Space.
            System.out.println("s and s2 are not equal.");
        }

        // In this case, the variable 's3' will point to the already existing one.
        // Thus, the address memory for 's' and 's3' are the same.
        String s3 = "test";
        if (s == s3) {
            // this will be printed.
            System.out.println("s and s3 are equal");
        } else {
            System.out.println("s and s3 are not equal.");
        }

        // Even though 's' was initially stored in String Pool,
        // the '+=' or 's = s + 'hello'operator will result in a new memory allocation but in the Heap Space.
        s += "hello"; // equivalent to s = new String("testhello");

        // The above operation will lead the below equality test with 's4' to become false:
        String s4 = "testhello";
        if (s == s4) {
            System.out.println("s and s4 are equal");
        } else {
            // this will be printed as 's' points now to the Heap Space.
            System.out.println("s and s4 are not equal.");
        }

        // We can manually send a String from the Heap Space to String Pool.
        // This can be achieved by using the '.intern()' method.
        // Note that it won't change the reference for 's',
        // will just create the corresponding string in the String Pool.
        String s5 = s.intern();

        if (s5 == s4) {
            // this will be printed.
            System.out.println("s5 and s4 are equal");
        } else {
            System.out.println("s5 and s4 are not equal.");
        }

        if (s == s4) {
            System.out.println("s and s4 are equal");
        } else {
            // this will be printed as 's' still points to the Heap Space.
            System.out.println("s and s4 are not equal.");
        }
        System.out.println();
    }
}
