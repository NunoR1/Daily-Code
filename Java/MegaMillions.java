import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MegaMillions {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    static double balance;
    static double totalWinnings = 0;
    static double totalSpent = 0;

    public static void main(String[] args) {
        initializeGame();
        
        // Run the game loop until the player can no longer play
        runGame();
        printGameSummary();
    }

    // Initialize the game (set balance, print welcome message)
    public static void initializeGame() {
        balance = 50;
        System.out.println(" _  _  ________      _______ _____ ______________    _______ _____     ______________ _____________    ____________            _____ _____ __   ________  ///\n |  |  ||______|     |      |     ||  |  ||______       |   |     |    |  |  ||______|  ____|_____|    |  |  |  |  |     |       |  |     || \\  ||______ /// \n |__|__||______|_____|_____ |_____||  |  ||______       |   |_____|    |  |  ||______|_____||     |    |  |  |__|__|_____|_______|__|_____||  \\_|______|...  ");
        System.out.println("=".repeat(156));
    }

    // Run the game loop (handle multiple rounds of play)
    // initial input asking to start
    // while running playRound and asking if they want to keep playing
    // terminates when balance < 2 or input == no
    // returns nothing and no parameters

    public static void runGame() {
        System.out.println("Your current balance: $" + String.format("%.2f", balance * 1.0));
        System.out.print("Do you wish to start(y/n)?: ");
        char waiver = Character.toLowerCase(scanner.next().charAt(0));
        while (balance >= 2 && waiver == 'y') { 
            playRound();
            System.out.print("Do you wish to play again?(y/n): ");
            waiver = Character.toLowerCase(scanner.next().charAt(0));
        }

        System.out.println();
        // conditional checking how the player lost different message for each prob through single line
        System.out.print((waiver == 'n') ? "Spectacular performance\nHere are your winnings" : "TOO BAD\nHAhAHAHAHHAHAHAHAHAHAHHA You lost all your money\nCheck this out");
    }

    // Play one round (handle number selection, ticket purchase, drawing numbers, checking results, updating balance)
    // ask for quick pick or not
    //  if not will ask user for numbers
    //      before putting it in if getValidNumber
    public static void playRound() {
        int number;
        int megaBall;
        int[] userNums = new int[5];
        System.out.println("=".repeat(33));
        System.out.println();
        System.out.print("Do you wish to quick pick(y/n): ");
        char quickPick = Character.toLowerCase(scanner.next().charAt(0));
        System.out.println();

        if (quickPick == 'y') {
            userNums = generateNumbers().clone();
            System.out.println("Your Quick Pick: " + Arrays.toString(userNums));
            // mega ball code below
            megaBall = 1 + random.nextInt(25);
            System.out.println("MegaBall: " + megaBall);
        } else {
            for (int i = 0; i < userNums.length; i++) {
                System.out.print("Input your number " + (i + 1) + "(1-70): ");
                number = scanner.nextInt();
                if (getValidNumber(number, 70, userNums)) { // 
                    userNums[i] = number;
                } else {i--;}
            }

            do {
                System.out.print("Pick your MegaBall number(1-25): ");
                megaBall = scanner.nextInt();
            } while (1 >= megaBall || megaBall >= 25);

            System.out.println();
            System.out.println("Your Numbers: " + Arrays.toString(userNums));
            System.out.println("Your MegaBall: " + megaBall);
        }

        System.out.println();
        
        // megaplier
        System.out.print("Do you wish to buy a Megaplier for $1(y/n): ");
        int megaplier = ('y' == Character.toLowerCase(scanner.next().charAt(0))) ? getRandomMegaplier() : 1;
        
        System.out.println();
        // winning and losing code

        int winnings = getPrize(megaplier, megaBall, userNums);
        System.out.println(((winnings == 0) ? "HAHAHAHAHHAHAHA ": (winnings == 100000000) ? "JACKPOT " : "") + "You won: $" + String.format("%,3.2f", winnings * 1.0));
        updateBalance(megaplier > 1, winnings);
        System.out.println("New Balance: $" + String.format("%,3.2f", balance * 1.0));

        System.out.println("=".repeat(33));
    }



    // Update balance after ticket purchase and winnings
    // auto balance -= 2
    // if megaplier == true balance -= 1
    // parameters (bool megaplier, int prize)
    // return int showing profit
    // updates totalSpent and totalWinnings and balance
    public static void updateBalance(boolean megaplier, int prize) {
        balance -= 2;
        totalSpent += 2;
        if (megaplier) {
            balance--;
            totalSpent++;
        }

        balance += prize;
        totalWinnings += prize;
    }


    // Print game summary (total spent, total winnings, final balance)
    public static void printGameSummary() {
        System.out.println();
        System.out.println("=".repeat(33));
        System.out.println("SUMMARY");
        System.out.println("=".repeat(33));
        System.out.println("Total Spent: $" + String.format("%,3.2f", totalSpent * 1.0));
        System.out.println("Total Won: $" + String.format("%,3.2f", totalWinnings * 1.0));
        System.out.println("Final Balance: $" + String.format("%,3.2f", balance * 1.0));
        System.out.println("=".repeat(33));
    }


    // Generate an array of 5 unique random numbers (1-70)
    // used for quick pick and winning numbers
    // sort at the end
    // getValidNumber
    public static int[] generateNumbers() {
        int[] array = new int[5];
        int number;
        for (int i = 0; i < array.length; i++) {
            number = 1 + random.nextInt(70);
            if (getValidNumber(number, 70, array)) { // 
                array[i] = number;
            } else {i--;}
        }
        return array;
    }


    // Get a valid number input from the user within a given range
    // parameters is num and upper range because lower range will always be 1
    // return bool
    // also checks if number is already in the array
    public static boolean getValidNumber(int num, int upper, int...array) {
        return (1 <= num && num <= upper) && !contains(num, array);
    }


    // Check if an array contains a specific number
    // called in countMatches
    // checks if current win number is in user array
    // returns bool
    public static boolean contains(int curNum, int...array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == curNum) return true;
        }
        return false;
    }


    // Count matching numbers between user and winning numbers
    // parameters is arrays
    // return int[] so actual matches and megaBall are separate
    // contains callen within arguments ()
    // for looping through winning array and user array
    public static int[] countMatches(int megaBall, int realmegaBall, int[] userArray, int[] winArray) {
        int count = 0;
        int wonMegaBall = ((megaBall == realmegaBall) ? 1 : 0);
        int[] matches = new int[2];
        for (int curNum : userArray) {
            if (contains(curNum, winArray)) {
                count++;
            }
        }

        matches[0] = count;
        matches[1] = wonMegaBall;

        return matches;
    }


    // Determine the prize amount based on matches
    // parameters (int megaplier, int megaball, int[] userNums)
    // returns prize money int
    // countMatches is called here
    public static int getPrize(int megaplier, int megaBall, int...userNums) {
        int prizeMoney = 0;
        boolean JACKPOT = false;
        // generate winning values
        int[] winNums = generateNumbers();
        int winMegaBall = 1 + random.nextInt(25);
        
        System.out.println("=".repeat(33) + "\n         WINNING NUMBERS         \n" + "=".repeat(33));
        System.out.print(Arrays.toString(winNums) + " ");
        System.out.println("MegaBall: " + winMegaBall);
        System.out.println((megaplier > 1) ? "Megaplier: X" + megaplier : "");
         System.out.println("=".repeat(33));
        
        int matches = countMatches(megaBall, winMegaBall, userNums, winNums)[0];
        boolean megaBallCheck = countMatches(megaBall, winMegaBall, userNums, winNums)[1] == 1;
        

        // THE FLOWCHART
        switch (matches) {
            case 5 -> {
                prizeMoney += (megaBallCheck) ? 100000000: 1000000;
            } case 4 -> {
                prizeMoney += (megaBallCheck) ? 10000: 500;
            } case 3 -> {
                prizeMoney += (megaBallCheck) ? 200: 10;
            } case 2 -> {
                prizeMoney += (megaBallCheck) ? 10: 0;
            } case 1 -> {
                prizeMoney += (megaBallCheck) ? 4: 0;
            } case 0 -> {
                prizeMoney += (megaBallCheck) ? 2: 0;
            }
        }

        prizeMoney = (JACKPOT) ? prizeMoney : prizeMoney * megaplier;
        
        return prizeMoney;
    }

    
    // Get a random Megaplier value (2x, 3x, 4x, or 5x)
    // get random number and return that
    public static int getRandomMegaplier() {
        return 2 + random.nextInt(4); 
    }
}
