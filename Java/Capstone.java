import java.util.Arrays;
import java.util.Scanner;

public class Capstone {
    public static int valid(int lim, String ask) { // input validation function
        Scanner scanner = new Scanner(System.in);
        int a;

        do {
            System.out.print(ask);
            a = scanner.nextInt();
        } while (a < 0 || !(1 <= a && a <= lim));

        return a;
    }


    public static int linearSearch(int target, int...list) {
        for (int i = 0; i < list.length; i++) {
            if (list[i] == target) {
                return i;
            }
        }
        return -1;
    }


    public static int reverseLinearSearch(int target, int...list) {
        for (int i = list.length; 0 < i; i--) {
            if (list[i] == target) {
                return i;
            }
        }
        return -1;
    }


    public static int BinarySearch(int target, int...list) {
        Arrays.sort(list);
        return Arrays.binarySearch(list, target);
    }


    public static int countOccurance(int target, int...list) {
        int occurences = 0;
        for (int i : list) {
            if (i == target) {
                occurences++;
            }
        }

        return occurences;
    }


    public static void main(String[] args) {
        int length = valid(10000, "Give me a length (positive integer, 1-10,000): ");
        int target = valid(1000, "Give me a target (positive integer, 1-1,000): ");
        int searches = valid(5, "How many searches do you want? (positive integer, 1-5): ");
        
        // Create and fill array
        int[] numList = new int[length];
        for (int i = 0; i < numList.length; i++) {
            numList[i] = (int)(1 + Math.random() * 1001);
        }

        // multiple targets
        int[] targetList = new int[searches];
        for (int i = 0; i < targetList.length; i++) {
            switch (i) {
                case 0:
                    targetList[i] = target;
                    break;
                case 1:
                    targetList[i] = target / 2;
                    break;
                case 2:
                    targetList[i] = target * 2;
                    break;
                case 3:
                    targetList[i] = target + 1;
                    break;
                case 4:
                    targetList[i] = target - 1;
                    break;
            }

            // makes sure targets don't over or under flow 1 - 1000 
            if (targetList[i] > 1000) {
                targetList[i] = 1000;
            } else if (targetList[i] < 1) {
                targetList[i] = 1;
            }
        }
        

        // Time check
        long startTime;
        long stopTime;
        long[] times = new long[searches * 4];
        for (int i = 0; i < times.length; i++) {

        }

    }

    public static long[] greatSearch(int[] targets, int[] numbers) {
        
    }
}