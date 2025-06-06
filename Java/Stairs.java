import java.util.Scanner;

public class Stairs {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Input a character: ");
        String character = input.nextLine();
        System.out.println("Input a number: ");
        Integer steps = input.nextInt();
        input.close();
        stairBuilder(character, steps);
    }

    static void stairBuilder(String m_character, Integer m_steps) {
        Integer mult = m_character.length();
        for (int i = 1; i < m_steps + 1; i++) {
            System.out.println(" ".repeat((m_steps - i) * mult) + m_character.repeat(i));
        }
    }
}