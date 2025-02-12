import java.util.Scanner;

public class ArrayWeGo {
    public static void main(String[] args) {
        declareArray();
        multiLineFillArray();
        oneLineFillArray();
        forLoopFillArray();
        forLoopFillArrayCharVer();
        userDefinedArray();
    }

    
    public static void declareArray() { // Task 1: Declare an Array
        // Declare an integer array named numbers with a size of 5.
        // Print all elements of the array to show their default values.
        System.out.println("Declare an Array");
        int[] numbers;
        numbers = new int[5];
        
        System.out.println("[" + numbers[0] + ", " + numbers[1] + ", " + numbers[2] + ", " + numbers[3] + ", " + numbers[4] + "]");
        System.out.println("");
    }

    
    public static void multiLineFillArray() { //Task 2: Declare an Array and fill the values in multiple lines
        // Declare an integer array named numbers with a size of 5.
        // Assign the values 21, 12, 22, 11, 2 to the array using separate assignment statements.
        // Print the complete array.
        System.out.println("Declare an Array and fill the values in multiple lines");
        
        int[] numbers = new int[5];
        numbers[0] = 21;
        numbers[1] = 12;
        numbers[2] = 22;
        numbers[3] = 11;
        numbers[4] = 2;
        
        System.out.println("[" + numbers[0] + ", " + numbers[1] + ", " + numbers[2] + ", " + numbers[3] + ", " + numbers[4] + "]");
        System.out.println("");
    }
    

    public static void oneLineFillArray() { // Task 3: Declare an Array and fill the values in one line
        // Declare and initialize an integer array named numbers with a size of 5 in one line.
        // Assign the values 21, 12, 22, 11, 2 directly.
        // Print the complete array.
        System.out.println("Declare an Array and fill the values in one line");
        
        int[] numbers = {21, 12, 22, 11, 2};
        
        System.out.println("[" + numbers[0] + ", " + numbers[1] + ", " + numbers[2] + ", " + numbers[3] + ", " + numbers[4] + "]");
        System.out.println("");
    }


    public static void forLoopFillArray() { // Task 4: Declare an Array and fill the values using a for loop
        // Declare an integer array named numbers with a size of 5.
        // Use a for loop to populate the array starting with 3, then fill it with increasing multiples of 3.
        // Print the complete array.
        System.out.println("Declare an Array and fill the values using a for loop");
        
        int[] numbers = new int[5];
        numbers[0] = 3;
        
        for (int i = 1; i < 5; i++) {
            numbers[i] = numbers[i-1] + 3;
        }

        System.out.println("[" + numbers[0] + ", " + numbers[1] + ", " + numbers[2] + ", " + numbers[3] + ", " + numbers[4] + "]");
        System.out.println("");
    }
    
    public static void forLoopFillArrayCharVer() { // Task 5: Declare an Array and fill the values using a for loop, char edition
        // Declare a char array named charArray with a size of 5.
        // Set the first element to 'A'.
        // Use a for loop to fill the array with the next respective letters, increasing by 2 each time. You must use math, you cannot hard code.
        // Print the complete array.
        System.out.println("Declare an Array and fill the values using a for loop, char edition");
        
        char[] charArray = new char[5];
        charArray[0] = 'A';
        
        for (int i = 1; i < 5; i++) {
            charArray[i] = (char)((charArray[i-1]) + 2);
        }
        
        System.out.println("[" + charArray[0] + ", " + charArray[1] + ", " + charArray[2] + ", " + charArray[3] + ", " + charArray[4] + "]");
        System.out.println("");
    }


    public static void userDefinedArray() { // Task 6: User-Defined Array with Random Values
        // Prompt the user to enter the size of the array.
        // Create an array of that size.
        // Fill it with random numbers between 1 and 100 using a for loop.
        // Print the array values.
        System.out.println("User-Defined Array with Random Values");
        
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input a number NOW: ");
        int length = scanner.nextInt();
        int[] userArray = new int[length];


        for (int i = 0; i < length; i++) {
            userArray[i] = (int)(Math.random() * 100);
        }

        printArray(userArray, length);
        
        scanner.close();
    }


    // funny
    public static void printArray(int[] list, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) { 
            System.out.print((i != 4) ? list[i] + ", " : list[i]);
        }
        System.out.println("]");
    }
}