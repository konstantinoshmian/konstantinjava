///17.
/// Для каждого числа из заданной последовательности натуральных чисел найти
/// произведение цифр, находящихся на нечётных позициях (нумерация позиций идёт слева
/// направо).

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("input length");
        int length = scanner.nextInt();
        int[] numbers = new int[length];

        Random random = new Random();


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(10000) + 1;
        }

        System.out.println("source array:");
        System.out.println(Arrays.toString(numbers));

        System.out.println("results:");

        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];
            int product = getOddPositionsProduct(currentNum);

            System.out.println("number: " + currentNum + " -> product: " + product);
        }
    }


    public static int getOddPositionsProduct(int x) {

        int length = countDigits(x);
        int product = 1;


        for (int i = length; i >= 1; i--) {
            int digit = x % 10;


            if (i % 2 != 0) {
                product = product * digit;
            }

            x = x / 10;
        }

        return product;
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
