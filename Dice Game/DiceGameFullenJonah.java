/**
 * @author Jonah Fullen
 * Lab 4: Rolling a Die using an Object
 * 01-11-2022
 * This file uses the class created in "Die.java" to make the Dice Game.
 * This version of the game not only has the built-in die that I was given in class, but also
 * allows for the user to buils their own die to play the game with.
 */

import java.util.Scanner;

public class DiceGameFullenJonah {

    public static void playGame(Die myDie) {
        /**
         * This method runs a game takes a given die and asks the user how many rolls they think
         * it will take for the die to show some number within the die's range. If the user guesses
         * the number of rolls correctly then they win, otherwise they lose.
         * Note: statistically speaking, it is very difficult to win this game.
         * @param - (Die) myDie - a Die object as created in 'Die.java'
         * @return - None
         */
        int target = myDie.roll();
        // Establish the number that is trying to be rolled by rolling the die
        Scanner input = new Scanner(System.in); // Initialize the Scanner to get user input
        System.out.print("Using a " + myDie.getNumSides() + " sided die, ");
        System.out.print("how many rolls will it take to roll a " + target + "? : ");
        // Display the pertinent Die information and ask them how many rolls they think it will take
        int guess = input.nextInt();    // Assign the user guess to an int variable
        int roll = myDie.roll();    // Roll the Die once to initialize the roll value
        int counter = 1;    // Begin the counter at 1 in case the initial roll is the target value
        while (target != roll) {    // Loop until the target value is rolled
            roll = myDie.roll();    // Update roll by rolling the Die
            counter++;  // Increment the counter
        }
        if (counter == guess){  // If the user guesses the correct number of rolls the win
            System.out.print("\n Congratulations! You Win! It took exactly ");
            System.out.println(counter + " rolls to get a " + target + "!");
        }
        else {  // If the user guessed anything other than the number of rolls they lose
            System.out.println("\nNot quite. It took " + counter + " rolls to get a " + target + ".");
        }
    }

    public static Die newDie() {
        /**
         * This method walks the user through the process of building a new Die object as defined
         * in 'Die.java'. The user is asked to enter all necessary data for the construction of a
         * new Die object.
         * @return - (Die) newDie - a new Die object created by the user
         */
        System.out.println("\nBuilding a new custom die.");
        Scanner input = new Scanner(System.in); // Initialize the Scanner to get user input
        System.out.print("Enter the number of sides on your die: ");
        int numSides = input.nextInt(); // Assign the user entered Number of Sides as an integer
        input.nextLine();   // Skip the newline character
        System.out.print("Enter the primary color of your die: ");
        String primaryColor = input.nextLine(); // Assign the user entered Primary Color
        System.out.print("Enter the secondary color of your die: ");
        String secondaryColor = input.nextLine();   // Assign the user entered Secondary Color
        System.out.print("Enter the number color of your die: ");
        String numColor = input.nextLine(); // Assign the user entered Number Color
        int[] sideValues = new int[numSides];   // Initialize a new empty integer list that is the
        // size of the number of sides of the Die. This list will be used as the Side Values list
        for (int counter = 0; numSides > counter; counter++) {
            // Loop through the range of number of sides
            sideValues[counter] = counter + 1;
            // Insert the counter value + 1 into the counter position
        }
        Die myDie = new Die(numSides, primaryColor, secondaryColor, numColor, sideValues);
        // Construct a new Die using the information given and created above and passed in their
        // respective positions
        return myDie;   // Return the new Die that has been created
    }


    public static void main(String[] args) {
        /**
         * The main method simply handles the general running of the program. Requires use of
         * Die object created in 'Die.java'.
         */
        int[] mySides = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 17, 18, 19, 20};
        // Initialize the integer list containing all given Die side values.
        Die myDie = new Die(20, "Red", "None", "White", mySides);
        // Create a Die object with values matching the given Die
        // Greet the user to the game and inform them of the characteristics of the given Die
        System.out.println("Welcome to the Dice Game!");
        System.out.print("The built-in die has " + myDie.getNumSides() + " sides. ");
        System.out.println("Its Primary Color is " + myDie.getPrimaryColor() + ". ");
        System.out.print("Its Secondary Color is " + myDie.getSecondaryColor() + ". ");
        System.out.println("Its Number Color is " + myDie.getNumColor() + ". ");
        System.out.print("Its possible Side Values are = [");
        // The loop below loops through the Side Values integer list to display the list to the user
        for (int counter = 0; counter < myDie.getSideValues().length; counter++) {
            if (counter != 0) {
                System.out.print(", ");
            }
            System.out.print(myDie.getSideValues()[counter]);
        }
        System.out.println("]\n");

        Scanner input = new Scanner(System.in); // Initialize the Scanner to get user input
        // Ask the user if they want to play the game and inform them of the two ways to play.
        // 1 - play with built-in die. 2 - create a new die to play with.
        System.out.println("Do you want to play the game with the built-in die?");
        System.out.println("Play with built-in die enter '1'. Play with a different die enter '2'. ");
        System.out.print("To Exit the Game enter '-1': ");
        int playGame = input.nextInt(); // Assign the user input to an integer variable
        while (playGame != -1) {    // Check if the user wants to exit the game
            if (playGame == 1) {    // Check if the user wants to user the built-in die
                System.out.println("\nPlay game with built-in die.");
                playGame(myDie);    // Play the game using the built-in die
            }
            else if (playGame == 2) {
                // Check if the user wants to play the game with a different die
                Die builtDie = newDie();    // Create a new die
                // Display the characteristics of the new die
                System.out.print("\nThe die you built has " + builtDie.getNumSides() + " sides. ");
                System.out.println("Its Primary Color is " + builtDie.getPrimaryColor() + ". ");
                System.out.print("Its Secondary Color is " + builtDie.getSecondaryColor() + ". ");
                System.out.println("Its Number Color is " + builtDie.getNumColor() + ". ");
                System.out.print("Its possible Side Values are = [");
                // The loop below loops through the Side Values integer list to display the list
                // to the user
                for (int counter = 0; counter < builtDie.getSideValues().length; counter++) {
                    if (counter != 0) {
                        System.out.print(", ");
                    }
                    System.out.print(builtDie.getSideValues()[counter]);
                }
                System.out.println("]\n");
                playGame(builtDie); // Play the game using the users new die
            }
            else {  // If the user attempts to start the game using an invalid input, display an
                // error message and prompt them for a new input.
                System.out.println("\nInvalid Input.");
                System.out.println("Do you want to play the game with the built-in die?");
                System.out.println("Play with built-in die enter '1'. Play with a different die enter '2', ");
                System.out.print("To Exit the Game enter '-1': ");
                playGame = input.nextInt(); // Update playGame that controls while loop on ln 109
            }
            // Once the game has been played once, ask the user if they would like to play again
            System.out.println("\nDo you want to play the game again?");
            System.out.println("Play with built-in die enter '1'. Play with a different die enter '2', ");
            System.out.print("To Exit the Game enter '-1': ");
            playGame = input.nextInt(); // Update playGame that controls while loop on ln 109
        }
    }
}
