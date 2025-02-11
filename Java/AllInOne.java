import java.util.Scanner;

public class AllInOne {
    public static void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        try {
        System.out.print("Input number 1: ");
        int input1 = scanner.nextInt();
        
        System.out.print("Input number 2: ");
        int input2 = scanner.nextInt();
        
        System.out.print("Input number 3: ");
        int input3 = scanner.nextInt();

        processNumbers(input1, input2, input3);
        scanner.close();
        } catch (Exception e) {
            System.out.println("Please input only integers");
            getUserInput();
        }
    }

    public static void processNumbers(int num1, int num2, int num3) {
        int sum = sum(num1, num2, num3);

        int max = max(num1, num2, num3);

        int min = min(num1, num2, num3);

        double average = average(num1, num2, num3);
 
        boolean allPositive = allPositive(num1, num2, num3);
 
        printResults(num1, num2, num3, sum, max, min, average, allPositive);
    }

    public static int sum(int num1, int num2, int num3) {
        // Calculate sum
        int sum = num1 + num2 + num3;
        return sum;
    }

    public static int max(int num1, int num2, int num3) {
        // Find max
        int max = num1;
        if (num2 > max) {
            max = num2;
        }
        if (num3 > max) {
            max = num3;
        }

        return max;
    }

    public static int min(int num1, int num2, int num3) {
        // Find min
        int min = num1;
        if (num2 < min) {
            min = num2;
        }
        if (num3 < min) {
            min = num3;
        }

        return min;
    }

    public static double average(int num1, int num2, int num3) {
        // Calculate average
        double average = sum(num1, num2, num3) / 3.0;
        return average;
    }

    public static boolean allPositive(int num1, int num2, int num3) {
        // Check if all numbers are positive
        boolean allPositive = (num1 > 0 && num2 > 0 && num3 > 0);
        return allPositive;
    }

    public static void printResults(int num1, int num2, int num3, int sum, int max, int min, double average, boolean allPositive) {
        // Print results
        System.out.println("Sum: " + sum);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Average: " + average);
        System.out.println("All numbers are positive: " + allPositive);
        System.out.println("Formatted Output: The sum of " + num1 + ", " + num2 + ", and " + num3 + " is " + sum + ".");
    }
 
    public static void main(String[] args) {
        getUserInput();
    }
}
