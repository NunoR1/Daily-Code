// import java.util.Scanner;

// public class TestWorld {
//     static Scanner scanner = new Scanner(System.in);
//     public static double[] createArray(String[] line) {
//         double[] converted = new double[line.length];
//         for (int i = 0; i < converted.length; i++) {
//             converted[i] = Double.parseDouble(line[i]);
//         }
//         return converted;
//     }

//     public static int[] locateLargest(double[][] a) {
//         double max = a[0][0];
//         int[] maxCords = new int[2];
//         for (int i = 0; i < a.length; i++) {
//             for (int j = 0; i < a[i].length; j++) {
//                 if (max < a[i][j]) {
//                     max = a[i][j];
//                     maxCords[0] = i;
//                     maxCords[1] = j;
//                 }
//             }
//         }

//         return maxCords;
//     }

//     public static void main(String[] args) {
//         int x = scanner.nextInt();
//         int y = scanner.nextInt();
//         scanner.nextLine();
//         double[][] matrix = new double[x][y];

//         for (int i = 0; i < matrix.length; i++) {
//             matrix[i] = createArray(scanner.nextLine().split(" "));    
//         }
        
//         int[] largest = locateLargest(matrix);
//         System.out.print("(" + largest[0] + ", " + largest[1] + ")");
//     }
// }