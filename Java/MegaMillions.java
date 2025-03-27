import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

/**
 * MegaMillions Lottery Simulator
 * This program simulates the Mega Millions lottery game.
 * Players can buy tickets, select numbers or use Quick Pick,
 * add the Megaplier option, and win prizes based on matches.
 */
public class MegaMillions {
    // Static variables for game state
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static double balance;
    static double totalWinnings = 0;
    static double totalSpent = 0;

    /**
     * Main method - Entry point of the program
     * Calls the three primary game methods in sequence
     */
    public static void main(String[] args) {
        initializeGame();
        runGame();
        printGameSummary();
    }

    /**
     * Sets the starting balance and prints a welcome message
     */
    public static void initializeGame() {
        balance = 50.0;
        System.out.println("======================================");
        System.out.println("      WELCOME TO MEGA MILLIONS!      ");
        System.out.println("======================================");
        System.out.println("You start with $50.00.\n");
    }

    /**
     * Runs the game loop, allowing multiple plays until the player stops or runs out of money
     */
    public static void runGame() {
        while (balance >= 2) {
            playRound();
            if (balance < 2) {
                System.out.println("\nYou don't have enough money to play again. Game over!");
                break;
            }
            System.out.print("\nDo you want to play again? (yes/no): ");
            if (!scanner.next().equalsIgnoreCase("yes")) {
                break;
            }
        }
    }

    /**
     * Handles number selection, ticket purchase, drawing numbers, checking results, and updating balance
     */
    public static void playRound() {
        // Display current balance
        displayBalance();
        
        // Get player choices
        boolean quickPick = askQuickPick();
        
        // Get player's numbers based on choice
        int[] userNumbers;
        if (quickPick) {
            userNumbers = generateNumbers();
            System.out.println("Your Quick Pick: " + Arrays.toString(userNumbers) + " Mega Ball: " + 
                             (quickPick ? getMegaBall(true) : ""));
        } else {
            userNumbers = getUserNumbers();
        }
        
        // Get Mega Ball
        int megaBall = getMegaBall(quickPick);
        
        // Ask about Megaplier option
        boolean megaplierOption = askMegaplier();
        
        // Calculate ticket cost
        double ticketCost = megaplierOption ? 3.0 : 2.0;
        
        // Check if player has enough money
        if (!validateBalance(ticketCost)) {
            return;
        }
        
        // Update balance after purchase
        updateBalance(-ticketCost);
        
        // Generate winning numbers and Mega Ball
        int[] winningNumbers = generateNumbers();
        int winningMegaBall = random.nextInt(25) + 1;
        
        // Get Megaplier value if option was selected
        int megaplier = megaplierOption ? getRandomMegaplier() : 1;
        
        // Display winning numbers
        displayWinningNumbers(winningNumbers, winningMegaBall, megaplierOption, megaplier);
        
        // Process results and update balance
        processResults(userNumbers, megaBall, winningNumbers, winningMegaBall, megaplier);
    }

    /**
     * Helper method to display the current balance
     */
    public static void displayBalance() {
        System.out.println("--------------------------------------");
        System.out.println("Current Balance: $" + String.format("%.2f", balance));
        System.out.println("--------------------------------------");
    }

    /**
     * Asks if the player wants to use Quick Pick
     * @return true for Quick Pick, false for manual selection
     */
    public static boolean askQuickPick() {
        System.out.print("Do you want Quick Pick? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes");
    }

    /**
     * Gets the player's manual number selections
     * @return array of 5 unique numbers between 1-70
     */
    public static int[] getUserNumbers() {
        int[] userNumbers = new int[5];
        System.out.println("Enter five unique numbers (1-70): ");
        for (int i = 0; i < 5; i++) {
            int userInput;
            do {
                userInput = getValidNumber(1, 70);
                if (contains(Arrays.copyOfRange(userNumbers, 0, i), userInput)) {
                    System.out.println("Duplicate number! Enter a different number:");
                }
            } while (contains(Arrays.copyOfRange(userNumbers, 0, i), userInput));
            userNumbers[i] = userInput;
        }
        return userNumbers;
    }

    /**
     * Gets the Mega Ball number
     * @param quickPick if true, generates random Mega Ball
     * @return Mega Ball number between 1-25
     */
    public static int getMegaBall(boolean quickPick) {
        if (quickPick) {
            return random.nextInt(25) + 1;
        }
        System.out.print("Enter your Mega Ball (1-25): ");
        return getValidNumber(1, 25);
    }

    /**
     * Asks if the player wants to add the Megaplier option
     * @return true if Megaplier is added, false otherwise
     */
    public static boolean askMegaplier() {
        System.out.print("Do you want to add Megaplier for $1? (yes/no): ");
        return scanner.next().equalsIgnoreCase("yes");
    }

    /**
     * Validates if the player has enough money for the ticket
     * @param ticketCost cost of the ticket
     * @return true if balance is sufficient, false otherwise
     */
    public static boolean validateBalance(double ticketCost) {
        if (balance < ticketCost) {
            System.out.println("\nYou don't have enough money for this play. Game over!");
            return false;
        }
        return true;
    }

    /**
     * Displays the winning numbers, Mega Ball, and Megaplier if applicable
     */
    public static void displayWinningNumbers(int[] winningNumbers, int winningMegaBall, boolean megaplierOption, int megaplier) {
        System.out.println("\n======================================");
        System.out.println("         WINNING NUMBERS: ");
        System.out.println("======================================");
        System.out.println(Arrays.toString(winningNumbers) + " Mega Ball: " + winningMegaBall);
        if (megaplierOption) {
            System.out.println("Megaplier Drawn: x" + megaplier);
        }
        System.out.println("======================================");
    }

    /**
     * Processes the results, calculates prizes, and updates the balance
     */
    public static void processResults(int[] userNumbers, int megaBall, int[] winningNumbers, int winningMegaBall, int megaplier) {
        // Count matching numbers
        int matchCount = countMatches(userNumbers, winningNumbers);
        boolean megaBallMatch = (megaBall == winningMegaBall);
        
        // Calculate prize
        int basePrize = getPrize(matchCount, megaBallMatch);
        
        // Apply Megaplier (except for jackpot)
        int finalPrize = (matchCount == 5 && megaBallMatch) ? basePrize : basePrize * megaplier;

        // Update balance with winnings
        updateBalance(finalPrize);
        
        // Display results
        System.out.println("\nYou won: $" + finalPrize);
        System.out.println("New Balance: $" + String.format("%.2f", balance));
    }

    /**
     * Updates the balance after ticket purchase and winnings
     * @param amount amount to add to balance (negative for spending)
     */
    public static void updateBalance(double amount) {
        balance += amount;
        if (amount < 0) {
            totalSpent -= amount;
        } else {
            totalWinnings += amount;
        }
    }

    /**
     * Displays the total spent, total winnings, and final balance
     */
    public static void printGameSummary() {
        System.out.println("\n======================================");
        System.out.println("              GAME OVER");
        System.out.println("======================================");
        System.out.println("Total Spent: $" + String.format("%.2f", totalSpent));
        System.out.println("Total Winnings: $" + String.format("%.2f", totalWinnings));
        System.out.println("Final Balance: $" + String.format("%.2f", balance));
        System.out.println("======================================");
    }

    /**
     * Generates and returns five unique random numbers between 1-70
     * @return array of 5 sorted random numbers
     */
    public static int[] generateNumbers() {
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            int num;
            do {
                num = random.nextInt(70) + 1;
            } while (contains(Arrays.copyOfRange(numbers, 0, i), num));
            numbers[i] = num;
        }
        Arrays.sort(numbers);
        return numbers;
    }

    /**
     * Ensures the user enters a valid number within a given range
     * @param min minimum valid value
     * @param max maximum valid value
     * @return valid number within range
     */
    public static int getValidNumber(int min, int max) {
        int num;
        do {
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter a number between " + min + " and " + max + ": ");
                scanner.next();
            }
            num = scanner.nextInt();
            if (num < min || num > max) {
                System.out.print("Number must be between " + min + " and " + max + ": ");
            }
        } while (num < min || num > max);
        return num;
    }

    /**
     * Checks if a number exists in an array
     * @param array array to check
     * @param num number to find
     * @return true if number is found, false otherwise
     */
    public static boolean contains(int[] array, int num) {
        for (int n : array) {
            if (n == num) return true;
        }
        return false;
    }

    /**
     * Counts how many numbers match between the user's ticket and the winning numbers
     * @param user player's numbers
     * @param winning winning numbers
     * @return count of matching numbers
     */
    public static int countMatches(int[] user, int[] winning) {
        int count = 0;
        for (int num : user) {
            if (contains(winning, num)) count++;
        }
        return count;
    }

    /**
     * Determines and returns the prize amount based on the number of matches
     * Prize Distribution:
     * 5 matches + Mega Ball = $100,000,000 (Jackpot)
     * 5 matches = $1,000,000
     * 4 matches + Mega Ball = $10,000
     * 4 matches = $500
     * 3 matches + Mega Ball = $200
     * 3 matches = $10
     * 2 matches + Mega Ball = $10
     * 1 match + Mega Ball = $4
     * 0 matches + Mega Ball = $2
     * 0-5 matches without Mega Ball = $0
     * 
     * @param matchCount number of matching regular numbers
     * @param megaBallMatch whether Mega Ball matches
     * @return prize amount
     */
    public static int getPrize(int matchCount, boolean megaBallMatch) {
        if (matchCount == 5 && megaBallMatch) return 100000000;
        if (matchCount == 5) return 1000000;
        if (matchCount == 4 && megaBallMatch) return 10000;
        if (matchCount == 4) return 500;
        if (matchCount == 3 && megaBallMatch) return 200;
        if (matchCount == 3) return 10;
        if (matchCount == 2 && megaBallMatch) return 10;
        if (matchCount == 1 && megaBallMatch) return 4;
        if (megaBallMatch) return 2;
        return 0;
    }

    /**
     * Randomly selects and returns a Megaplier value (2x, 3x, 4x, or 5x)
     * @return random Megaplier value
     */
    public static int getRandomMegaplier() {
        int[] multipliers = {2, 3, 4, 5};
        return multipliers[random.nextInt(multipliers.length)];
    }
}