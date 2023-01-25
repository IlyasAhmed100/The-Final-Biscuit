import java.util.Scanner; // Importing the scanner 

public class LastBiscuit { // Scope of LastBiscuit Class 
    public static void main(String[] args) { // Scope of main()

        // Final Variable Declarations 
        final String BARREL_ONE_BISCUITS_LEFT = "Biscuits Left - Barrel 1: ";
        final String BARREL_TWO_BISCUITS_LEFT = "Biscuits Left - Barrel 2: ";
        final String PLAYER_TURN = "Player Turn: ";
        final String BARREL_SELECTION = 
        "Choose a barrel: barrel1 (one), barrel2 (two), or both (both), or skip turn (skip)? ";
        final String BISCUIT_SELECTION = "How many biscuits are you taking? ";
        final String INPUT_INTEGER = "Please input an integer: ";
        final String INVALID_INPUT = 
        "Sorry, that's not a legal number of biscuits for that/those barrel(s)";
        final String USED_SKIP = "Sorry you've used your skip.";
        final String PLAYER_WINNER = "Winner is player ";
        final int NUM_BISCUITS_BARREL_ONE = 6;
        final int NUM_BISCUITS_BARREL_TWO = 8;
        final int PLAYER_ONE_SKIP = 0;
        final int PLAYER_TWO_SKIP = 0;

        // Declaring number of biscuits at the start
        int barrelOneBiscuitsTotal = NUM_BISCUITS_BARREL_ONE;
        int barrelTwoBiscuitsTotal = NUM_BISCUITS_BARREL_TWO;

        // Starting the scanner to retrieve user inputs
        Scanner sc = new Scanner(System.in);

        // Starting off with Player 1
        boolean playerOneTurn = true;
        boolean winnerFound = false;
        boolean skipLines = false;

        // Counting the number of skips player 1 has used
        int playerOneSkipCount = PLAYER_ONE_SKIP;
        int playerTwoSkipCount = PLAYER_TWO_SKIP;
        
        // Checks which player took the last biscuit
        int lastTurn = 0;
        
        // Set up a while loop to distinguish between the 2 players
        while (!winnerFound) {
            while (playerOneTurn) {
                lastTurn = 1;
                if (!skipLines) {
                System.out.println(BARREL_ONE_BISCUITS_LEFT + barrelOneBiscuitsTotal);
                System.out.println(BARREL_TWO_BISCUITS_LEFT + barrelTwoBiscuitsTotal);
                System.out.println(PLAYER_TURN + 1);
                }
                System.out.print(BARREL_SELECTION);
                // Gets user input from choosing a barrel(s)
                String playerOneBarrelSelection = sc.nextLine(); 
                
                // While loop set up to ensure user inputs the correct barrel(s)
                while (!(playerOneBarrelSelection.equals("one") 
                || playerOneBarrelSelection.equals("two") 
                || playerOneBarrelSelection.equals("both")
                || playerOneBarrelSelection.equals("skip"))) {
                    System.out.print(BARREL_SELECTION);
                    playerOneBarrelSelection = sc.nextLine();
                }
                if (playerOneBarrelSelection.equals("one")) {
                    System.out.print(BISCUIT_SELECTION);
                    boolean inputValidityOne = true;
                    int playerOneBiscuitSelection = 0;
                    try { // Will try to check for integer
                        playerOneBiscuitSelection = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException ex) {
                        // If integer is not found while loop starts to get an integer from user
                        inputValidityOne = false;
                        // While loop to ensure user enters an integer
                        while (!inputValidityOne) {  
                            System.out.print(INPUT_INTEGER);
                            try {
                                playerOneBiscuitSelection = Integer.parseInt(sc.nextLine());
                                inputValidityOne = true;
                            } catch (NumberFormatException e) {
                                continue;
                            }
                        }
                    }
                    // Checks if the users input is less than the barrel total and more than zero
                    if ((playerOneBiscuitSelection > barrelOneBiscuitsTotal) 
                    || (playerOneBiscuitSelection <= 0)){
                        // Will tell the user he can't input his number
                        System.out.println(INVALID_INPUT);
                        skipLines = true;
                    } else {
                        // Will subtract players biscuit selection from the barrel 
                        barrelOneBiscuitsTotal -= playerOneBiscuitSelection;
                        playerOneTurn = false;
                        skipLines = false;
                    }
                } else if (playerOneBarrelSelection.equals("two")) {
                    System.out.print(BISCUIT_SELECTION);
                    boolean inputValidityOne = true;
                    int playerOneBiscuitSelection = 0;
                    try {  // Will try to check for integer
                        playerOneBiscuitSelection = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException ex) { 
                        // If integer is not found while loop starts to get an integer from user
                        inputValidityOne = false;
                        // While loop to ensure user enters an integer
                        while (!inputValidityOne) {  
                            System.out.print(INPUT_INTEGER);
                            try {
                                playerOneBiscuitSelection = Integer.parseInt(sc.nextLine());
                                inputValidityOne = true;
                            } catch (NumberFormatException e) {
                                continue;
                            }
                        }
                    }
                    if ((playerOneBiscuitSelection > barrelTwoBiscuitsTotal) 
                    || (playerOneBiscuitSelection <= 0)) {
                        System.out.println(INVALID_INPUT);
                        skipLines = true;
                    } else {
                        // Will subtract players biscuit selection from the barrel
                        barrelTwoBiscuitsTotal -= playerOneBiscuitSelection;
                        playerOneTurn = false;
                        skipLines = false;
                    }
                } else if (playerOneBarrelSelection.equals("both")) {
                    System.out.print(BISCUIT_SELECTION);
                    boolean inputValidityOne = true;
                    int playerOneBiscuitSelection = 0;
                    try { // Will try to check for integer
                        playerOneBiscuitSelection = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException ex) {
                        // If integer is not found while loop starts to get an integer from user
                        inputValidityOne = false;
                        // While loop to ensure user enters an integer
                        while (!inputValidityOne) { 
                            System.out.print(INPUT_INTEGER);
                            try {
                                playerOneBiscuitSelection = Integer.parseInt(sc.nextLine());
                                inputValidityOne = true;
                            } catch (NumberFormatException e) {
                                continue;
                            }
                        }
                    }
                    // Checks if the users input is less than the barrels total and more than zero
                    if ((playerOneBiscuitSelection > barrelOneBiscuitsTotal) 
                    || (playerOneBiscuitSelection > barrelTwoBiscuitsTotal) 
                    || (playerOneBiscuitSelection <= 0)) {
                        System.out.println(INVALID_INPUT);
                        skipLines = true;
                    } else {
                        // Will subtract players biscuit selection from the barrels
                        barrelOneBiscuitsTotal -= playerOneBiscuitSelection;
                        barrelTwoBiscuitsTotal -= playerOneBiscuitSelection;
                        playerOneTurn = false;
                        skipLines = false;
                    }                  
                } else if (playerOneBarrelSelection.equals("skip")) {
                    if (playerOneSkipCount < 1) {
                        // Will allow player to skip only one turn 
                        playerOneSkipCount++;
                        playerOneTurn = false;
                        skipLines = false;
                    } else {
                        // If player has used more than one skip he can't use more
                        System.out.println(USED_SKIP);
                        skipLines = true;
                    }
                }
            }
            // Checks if a winner has been found when switching to next players turn 
            if ((barrelOneBiscuitsTotal == 0) && (barrelTwoBiscuitsTotal == 0)){
                winnerFound = true;
                break;
            }
            // Player 2 Turn
            while (!playerOneTurn && !winnerFound) {
                lastTurn = 2;
                if (!skipLines) {
                System.out.println(BARREL_ONE_BISCUITS_LEFT + barrelOneBiscuitsTotal);
                System.out.println(BARREL_TWO_BISCUITS_LEFT + barrelTwoBiscuitsTotal);
                System.out.println(PLAYER_TURN + 2);
                }
                System.out.print(BARREL_SELECTION);
                String playerTwoBarrelSelection = sc.nextLine();
                // Makes sure player inputs correct barrels 
                while (!(playerTwoBarrelSelection.equals("one") 
                || playerTwoBarrelSelection.equals("two") 
                || playerTwoBarrelSelection.equals("both")
                || playerTwoBarrelSelection.equals("skip"))) {
                    System.out.print(BARREL_SELECTION);
                    playerTwoBarrelSelection = sc.nextLine();
                }
                if (playerTwoBarrelSelection.equals("one")) {
                    System.out.print(BISCUIT_SELECTION);
                    boolean inputValidityTwo = true;
                    int playerTwoBiscuitSelection = 0;
                    // Will try to check for integer
                    try {                                
                        playerTwoBiscuitSelection = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException ex) {
                        // If integer is not found while loop starts to get an integer from user
                        inputValidityTwo = false;
                        // While loop to ensure user enters an integer
                        while (!inputValidityTwo) { 
                            System.out.print(INPUT_INTEGER);
                            try {
                                playerTwoBiscuitSelection = Integer.parseInt(sc.nextLine());
                                inputValidityTwo = true;
                            } catch (NumberFormatException e) {
                                continue;
                            }
                        }
                    }
                    // Checks if the users input is less than the barrel total and more than zero
                    if ((playerTwoBiscuitSelection > barrelOneBiscuitsTotal) 
                    || (playerTwoBiscuitSelection <= 0)) {
                        System.out.println(INVALID_INPUT);
                        skipLines = true;
                    } else {
                        // Will subtract players biscuit selection from the barrel
                        barrelOneBiscuitsTotal -= playerTwoBiscuitSelection;
                        playerOneTurn = true;
                        skipLines = false;
                    }
                    // When player selects barrel 2
                } else if (playerTwoBarrelSelection.equals("two")) {
                    System.out.print(BISCUIT_SELECTION);
                    boolean inputValidityTwo = true;
                    int playerTwoBiscuitSelection = 0;
                    try {  // Will try to check for integer
                        playerTwoBiscuitSelection = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException ex) { 
                        // If integer is not found while loop starts to get an integer from user
                        inputValidityTwo = false;
                        // While loop to ensure user enters an integer
                        while (!inputValidityTwo) {
                            System.out.print(INPUT_INTEGER);
                            try {
                                playerTwoBiscuitSelection = Integer.parseInt(sc.nextLine());
                                inputValidityTwo = true;
                            } catch (NumberFormatException e) {
                                continue;
                            }
                        }
                    }
                    // Checks if the users input is less than the barrel total and more than zero
                    if ((playerTwoBiscuitSelection > barrelTwoBiscuitsTotal) 
                    || (playerTwoBiscuitSelection <= 0)){
                        System.out.println(INVALID_INPUT);
                        skipLines = true;
                    } else {
                        // Will subtract players biscuit selection from the barrel
                        barrelTwoBiscuitsTotal -= playerTwoBiscuitSelection;
                        playerOneTurn = true;
                        skipLines = false;
                    }
                    // When player selects both barrels
                } else if (playerTwoBarrelSelection.equals("both")) {
                    System.out.print(BISCUIT_SELECTION);
                    boolean inputValidityTwo = true;
                    int playerTwoBiscuitSelection = 0;
                    try { // Will try to check for integer
                        playerTwoBiscuitSelection = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException ex) { 
                        // If integer is not found while loop starts to get an integer from user
                        inputValidityTwo = false;
                        // While loop to ensure user enters an integer
                        while (!inputValidityTwo) { 
                            System.out.print(INPUT_INTEGER);
                            try {
                                playerTwoBiscuitSelection = Integer.parseInt(sc.nextLine());
                                inputValidityTwo = true;
                            } catch (NumberFormatException e) {
                                continue;
                            }
                        }
                    }
                     // Checks if the users input is less than the barrels total and more than zero
                    if ((playerTwoBiscuitSelection > barrelOneBiscuitsTotal) 
                    || (playerTwoBiscuitSelection > barrelTwoBiscuitsTotal) 
                    || (playerTwoBiscuitSelection <= 0)){
                        System.out.println(INVALID_INPUT);
                        skipLines = true;
                    } else {
                        // Will subtract players biscuit selection from the barrels
                        barrelOneBiscuitsTotal -= playerTwoBiscuitSelection;
                        barrelTwoBiscuitsTotal -= playerTwoBiscuitSelection;
                        playerOneTurn = true;
                        skipLines = false;
                    }
                } else if (playerTwoBarrelSelection.equals("skip")) {
                    // Will allow player to skip only one turn 
                    if (playerTwoSkipCount < 1) {
                        playerTwoSkipCount++;
                        playerOneTurn = true;
                        skipLines = false;
                    } else {
                        // If player has used more than one skip he can't use more
                        System.out.println(USED_SKIP);
                        skipLines = true;
                    }
                }
            }
            // Checks if a winner has been found when switching to next players turn 
            if ((barrelOneBiscuitsTotal == 0) && (barrelTwoBiscuitsTotal == 0)) {
                winnerFound = true;
            }
        }
        // If winner is found it prints that the barrels are empty
        System.out.println(BARREL_ONE_BISCUITS_LEFT + barrelOneBiscuitsTotal);
        System.out.println(BARREL_TWO_BISCUITS_LEFT + barrelTwoBiscuitsTotal);
        // If the last player to take the last biscuit was player 1 he wins
        if (lastTurn == 1) {
            System.out.println(PLAYER_WINNER + 1);
        } else {
            // If the last player to take the last biscuit was player 2 he wins
            System.out.println(PLAYER_WINNER + 2);
        }
        // Closing the scanner
        sc.close();    
    }
}
