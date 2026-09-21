///27.
/// Найти и вывести из заданной последовательности натуральных чисел, все
/// p-значные числа, в записи которых встречаются цифры 0, 2, 3, 7 по одному разу.


import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("input p");
        int p = scanner.nextInt();

        System.out.println("input length");
        int length = scanner.nextInt();
        int[] numbers = new int[length];

        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100000) + 100;
        }

        System.out.println("source array:");
        System.out.println(Arrays.toString(numbers));

        System.out.println("results:");
        int totalFound = 0;

        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];

            if (countDigits(currentNum) == p) {

                if (hasRequiredDigitsOnce(currentNum)) {
                    System.out.println(currentNum);
                    totalFound++;
                }
            }
        }

        System.out.println("total count: " + totalFound);
    }

    public static boolean hasRequiredDigitsOnce(int x) {
        int count0 = 0;
        int count2 = 0;
        int count3 = 0;
        int count7 = 0;

        while (x > 0) {
            int digit = x % 10;

            if (digit == 0) {
                count0++;
            } else if (digit == 2) {
                count2++;
            } else if (digit == 3) {
                count3++;
            } else if (digit == 7) {
                count7++;
            }

            x = x / 10;
        }

        if (count0 == 1 && count2 == 1 && count3 == 1 && count7 == 1) {
            return true;
        }

        return false;
    }

    public static int countDigits(int x) {
        if (x == 0) {
            return 1;
        }
        int count = 0;
        while (x > 0) {
            x = x / 10;
            count++;
        }
        return count;
    }
}
