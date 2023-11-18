import java.util.Scanner;

public class SumOfPositiveNumbers {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please write the sequence length: ");

        int seqLength = scanner.nextInt();
        int[] arr = new int[seqLength];

        System.out.println("Please add the numbers");
        for (int i = 0; i < seqLength; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            arr[i] = scanner.nextInt();
        }

        int sum = 0;
        boolean isAnyPositiveNumber = false;

        System.out.println("Computing the number of positive numbers...");

        for (int i = 0; i < seqLength; i++) {
            if (arr[i] >= 0) {
                sum += arr[i];
                isAnyPositiveNumber = true;
            } else {
                break;
            }
        }

        if (isAnyPositiveNumber) {
            System.out.println("The sum of positive numbers is: " + sum);
        } else {
            System.out.println("There are no positive numbers in the array...");
        }
    }
}
