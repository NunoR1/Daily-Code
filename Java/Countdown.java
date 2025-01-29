
import java.util.Scanner;

public class Countdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a number:");
        int number = scanner.nextInt();
        System.out.println(); // Format

        for (int i = 0; number > i; number--) {
            System.out.println(number);
        }
        scanner.close();
    }
}
