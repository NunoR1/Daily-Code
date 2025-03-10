import java.util.Arrays; // they didn't import Arrays in the pseudocode
import java.util.Scanner;

public class OtherPseudoCode {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.print("Input a number greater or equal to 5: ");
        int input = scanner.nextInt();
        
        // contradiction here in the pseudocode where they stated the minimum was 5 but put "input < 5" in the while loop definition 
        while (input <= 4) { 
            System.out.print("Input a number greater than 5: ");
            input = scanner.nextInt();
        }

        int[] userArray = new int[input];

        for (int i = 0; i < userArray.length; i++) {
            userArray[i] = (int)(1 + Math.random() * 51); // in the pseudocode they used the random module
        }
    
        System.out.println(Arrays.toString(userArray));

        int first = userArray[userArray.length - 3];
        int second = userArray[userArray.length - 2];
        int third = userArray[userArray.length - 1];

        // in the pseudocode they suggested doing that "userArray.length - 3" within the loop; fixed it to make code more readable
        for (int i = 0; i < userArray.length - 3; i++) { 
            // set the current index of the for loop to be that index plus 3??? Assuming this program is made to shift values of an array to the right by 3
            userArray[i + 3] = userArray[i];
        }

        // // then I realized this loop doesn't work like it should by incrementing through the array, so here is how the loop should've been
        // for (int i = userArray.length - 1; 0 < i - 2; i--) {
        //     userArray[i] = userArray[i - 3];
        // }

        userArray[0] = first;
        userArray[1] = second;
        userArray[2] = third;

        System.out.println(Arrays.toString(userArray)); // they didn't print theirs at the end I just did this for debugging
    }
}