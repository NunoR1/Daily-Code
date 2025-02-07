import java.util.Scanner;

public class DOIT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number;

        do {
            System.out.print("Input a positive integer: ");
            number = scanner.nextInt();
            
            if (number > 0) {
                System.out.println("You entered: " + number);
            }
        } while (number <= 0);

        scanner.close();
    }
}
