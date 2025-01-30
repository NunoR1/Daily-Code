import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number:");
        long number = scanner.nextLong();
        long fact = Fact(number);
        System.out.println("The factorial of " + number + " is " + fact);
        scanner.close();
    }

    static long Fact(long num) {
        if (num < 0) {
            return 0;
        } else if (num == 0) {
            return 1;
        } else {
            long limit = num;
            for (long i = 1; i != limit; i++) {
                num *= i;
            }
        }

        return num;
    }
}
