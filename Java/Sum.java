import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int num1 = (int)(Math.random() * 10);
        int num2 = (int)(Math.random() * 10);
        
        System.out.print("What is " + num1 + " + " + num2 + "? ");
        int answer = scanner.nextInt();
        
        while (answer != (num1 + num2)) { 
            System.out.print("WRONG. TRY AGAIN: ");
            answer = scanner.nextInt();
        }

        System.out.println("HOORAY!!!");
        scanner.close();
    }
}
