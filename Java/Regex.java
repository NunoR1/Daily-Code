import java.util.Arrays;

public class Regex {
    public static void main(String[] args) {
        // Find and fix the bug in each of these regex lines:
        String text1 = "file.txt";
        boolean result1 = text1.matches("file.txt");  // Should match "file.txt" exactly

        String[] parts2 = "apple,banana;orange".split("[,;]"); // Should split on commas and semicolons

        String result3 = "abbbbbc".replaceAll("[a+bc]", "X"); // Should replace "abbbbbc" with "X"

        String result4 = "abc123def456".replaceAll("\\d+", "[\\d+]"); // Should wrap digits in brackets

        String result5 = "C:\\Program Files\\Java".replaceAll("\\\\", "/"); // Should replace backslashes with forward slashes

//        System.out.println(result1);
//        System.out.println(Arrays.toString(parts2));
        System.out.println(result3);
        System.out.println(result4);
//        System.out.println(result5);
    }
}
