import java.util.Scanner;

public class GuessNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = (int)(Math.random() * 100);
        System.out.print("Guess my magic number from 0 to 100: ");
        int guess = scanner.nextInt();
        System.out.println("\n");

        while (guess != number) {
            if (guess > number) {
                System.out.print("Too High\nAgain: ");
            } else {
                System.out.print("Too Low\nAgain: ");
            }
            guess = scanner.nextInt();
            System.out.println("\n");
        }
        System.out.print("Thank you for breaking the curse!!!");

        scanner.close();
    }
}
