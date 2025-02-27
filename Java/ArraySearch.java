import java.util.Arrays;
import java.util.Scanner;

public class ArraySearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Get array size from user using Scanner
        // Validate input to ensure a positive integer for array size
        int length;
        do {
            System.out.print("Input a positive number please: ");
            length = scanner.nextInt();
        } while (length <= 0);
        
        int[] userArray = new int[length];

        // Create an array of the specified size and fill with random numbers
        for (int i = 0; i < length; i++) {
            userArray[i] = (int)(Math.random() * 1001);
        }

        // Get target number from user using Scanner
        // Validate input to ensure a positive integer for the target number if found, -1 if not
        
        int target;
        int linResult = -1;
        do {
            System.out.print("What number do you want? ");
            target = scanner.nextInt();
        } while(target < 0);

        // Linear Search
        System.out.println("Starting linear search...");
        long linearStartTime = System.nanoTime();

        // Implement linear search to find the index of the target number
        for (int i = 0; i < userArray.length; i++) {
            if (userArray[i] == target) {
                linResult = i;
                break;
            }
        }

        long linearEndTime = System.nanoTime();
        System.out.println("Linear search took " + (linearEndTime - linearStartTime) + " nanoseconds.");

        // Sort the array using built-in method of the Arrays class
        System.out.println("Sorting the array...");
        // Sort the array as specified above
        Arrays.sort(userArray);

        // Binary Search
        System.out.println("Starting binary search...");
        long binaryStartTime = System.nanoTime();

        // Implement binary search to find the index of the target number if found, -1 if not
        int binResult = Arrays.binarySearch(userArray, target);

        long binaryEndTime = System.nanoTime();
        System.out.println("Binary search took " + (binaryEndTime - binaryStartTime) + " nanoseconds.");

        // Display the result of the binary search (index or not found)
        System.out.println("Linear Search result: " + linResult + "\nBinary Search result: " + binResult);

        // Display results specified in Display Output section
        System.out.println("Linear Search took " + (linearEndTime - linearStartTime) + " nanoseconds\nBinary Search took " + (binaryEndTime - binaryStartTime) + " nanoseconds\n" + (((linearEndTime - linearStartTime) > (binaryEndTime - binaryStartTime)) ? "Binary Search": "Linear Search") + " was faster");
    }
}
