import java.util.Scanner;

public class SumOfDigits {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter a number: ");

        int i = scanner.nextInt();
        int sum = 0;

        do {
            sum += i % 10;
            i /= 10;
        } while (i != 0);

        System.out.println("Sum of digits is: " + sum);
    }
}
