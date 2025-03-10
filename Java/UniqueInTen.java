import java.util.Scanner;

public class UniqueInTen {
    public static boolean linearSearch(int item, int...list) {
        for (int i : list) {
            if (i == item) {
                return false; 
            }
        }
        return true;
    }
    
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        int[] list = new int[10];
        int count = 0;
        for (int i = 0; i < list.length; i++) {
            int pending = scanner.nextInt();
            if (linearSearch(pending, list)) {
                count++;
                list[i] = pending;
            }
        }
        System.out.println("The number of distinct integers is " + count);
        System.out.print("The distinct integers are");
        for (int i : list) {
            if (i != 0) {
                System.out.print(" " + i);
            }
        }
    }
}
