// Import necessary classes
import java.util.Scanner;

public class JavaQuickMaths {
    // word word word word(Word[] word)    {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);
        // 1. Loop from 1.0 to 5.0, incrementing by 0.5
        System.out.println("Looping from 1.0 to 5.0 with rounding methods:");
        for (double i = 1.0; i <= 5.0; i += .5) {
            //    - Print the number
            System.out.print("Number: " + i + " ");
            //    - Apply and print results of:
            //      - Math.ceil()
            System.out.print("Ceil: " + Math.ceil(i) + " ");
            //      - Math.floor()
            System.out.print("Floor: " + Math.floor(i) + " ");
            //      - Math.rint()
            System.out.print("Rint: " + Math.rint(i) + " ");
            //      - Math.round()
            System.out.println("Round: " + Math.round(i) + " ");
        }

        System.out.println();
        
        // 2. Prompt the user to enter a decimal number
        System.out.print("Enter a decimal number: ");
        //    - Store the number
        double dec = scanner.nextDouble();
        //    - Print the rounding results (ceil, floor, rint, round)
        System.out.printf("Ceil: %.1f Floor: %.1f Rint: %.1f Round: %d", Math.ceil(dec), Math.floor(dec), Math.rint(dec), Math.round(dec));
        System.out.println("\n");

        // 3. Prompt the user to enter an integer
        System.out.print("Enter an integer: ");
        //    - Store the integer
        int num = scanner.nextInt();
        //    - Prompt the user to enter a string
        System.out.print("Enter a word: ");
        scanner.nextLine(); // buffer
        //    - Store the string
        String word = scanner.nextLine();
        //    - Print the entered integer and string
        System.out.println("You entered integer: " + num);
        System.out.println("You entered string: " + word);
        System.out.println("\n");
        
        // 4. Demonstrate type casting
        //    - Convert the integer to double (implicit cast) and print
        double intToDouble = num;
        System.out.println("Implicit cast (int → double): " + intToDouble);
        //    - Convert the decimal number to int (explicit cast) and print
        int decToInt = (int)(dec);
        System.out.println("Explicit cast (double → int): " + decToInt);
        //    - Convert the integer to a char (ASCII representation) and print
        char intToChar = (char)(num);
        System.out.println("Casting int to char (ASCII): " + intToChar);
        System.out.println("\n");

        // 5. Prompt the user to enter a character
        System.out.print("Enter a character: ");
        //    - Store the character
        char chara = scanner.next().charAt(0);
        //    - Convert the character to its ASCII value (int) and print
        int charToInt = (int)(chara);
        System.out.println("ASCII value of '" + chara + "' is: " + charToInt);
        System.out.println("\n");
        
        // 6. Demonstrate String vs. new String()
        //    - Create a String literal and assign it to two variables
        String str1 = "  ";
        String str2 = "  ";
        //    - Create another String using new String()
        String str3 = new String("  ");
        //    - Compare the first two strings using == (reference check)
        boolean comp1 = str1 == str2;
        //    - Compare one literal with the new String() object using ==
        boolean comp2 = str1 == str3;
        //    - Compare the content of both strings using .equals()
        boolean comp3 = str1.equals(str3);
        //    - Print the results
        System.out.println("str1 == str2: " + comp1);
        System.out.println("str1 == str3: " + comp2);
        System.out.println("str1.equals(str3): " + comp3);
        
        // Close the Scanner object
        scanner.close();
    //}
    }
}
