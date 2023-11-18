import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();

        int k = 2;
        boolean isPrime = true;
        while (k <= i / 2) {
            if (i % k++ == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println("is prime");
        } else {
            System.out.println("is not prime;");
        }
    }
}
