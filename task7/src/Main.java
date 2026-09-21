///Найти все p-значные числа из заданной последовательности натуральных чисел
///в записи которых встречаются не более k (k<p) различных цифр, и найти их количество
///

import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("input p");
        int p = scanner.nextInt();

        System.out.println("input k");
        int k = scanner.nextInt();

        while (k >=p)
        {System.out.println("k have to be less than p, input k");
        k = scanner.nextInt();
        }

        System.out.println("input length");
        int length = scanner.nextInt();
        int[] numbers = new int[length];

        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1000000);
        }

        ///int a = 123;
       /// int digits = countDigits(a);
       /// System.out.println(digits);

        System.out.println(Arrays.toString(numbers));

        ///int[] filterArray = Arrays.stream(numbers)
        ///        .filter(x -> countDigits(x) == p)
         ///       .toArray();

        ///System.out.println(Arrays.toString(filterArray));

        int countMatchingNumbers = 0;


        for (int i = 0; i < numbers.length; i++) {
            int currentNum = numbers[i];

            if (countDigits(currentNum) == p) {

                if (countUniqueDigits(currentNum) <= k) {
                    System.out.println(currentNum);
                    countMatchingNumbers++;
                }
            }
        }

        System.out.println(countMatchingNumbers);

    }

    public static int countDigits(int x)
    {
        if (x == 0)
        {
            return 1;
        }

        int count = 0;

        while (x > 0)
        {
            x = x / 10;
            count++;
        }
        return count;
    }

    public static int countUniqueDigits(int x) {
        if (x == 0) return 1;


        boolean[] digitFound = new boolean[10];

        while (x > 0) {
            int lastDigit = x % 10;
            digitFound[lastDigit] = true;
            x = x / 10;
        }
        int uniqueCount = 0;
        for (int i = 0; i < digitFound.length; i++) {
            if (digitFound[i]) {
                uniqueCount++;
            }
        }
        return uniqueCount;
    }

}