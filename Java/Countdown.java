import java.util.Scanner;

public class Countdown {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // create a new scanner for input
        System.out.println("Input a number:"); // prompts the user
        
        try { // validated
            int number = scanner.nextInt(); // integers make it easier to scale later
            System.out.println(); // Format
            CountDown(number);
        } catch(Exception e) {
            System.out.println("That's not a number");
        }

        scanner.close();
    }

    static void CountDown(Integer number) {
        for (int i = 0; number > i; number--) { // have it so that in each iteration the user input get decremented by one (that's why it's an integer)
            System.out.println(number); // simply print the current value of the user input
        }
    } 
}
