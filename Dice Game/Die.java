/**
 * @author Jonah Fullen
 * Lab 4: Rolling a Die using an Object
 * 01-11-2022
 * This file contains the Die Object class. Code for the Dice Game found in "DiceGameFullenJonah.java".
 */

public class Die {
    // Initialize the needed private class variables
    private int numSides;
    private String primaryColor;
    private String secondaryColor;
    private String numColor;
    private int[] sideValues;

    public Die(int sides, String primary, String secondary, String nums, int[] values) {
        /**
         * The Die object is made to represent a specific, real-world die that contains various
         * different physical attributes that are defined in the following parameters.
         * @param - (int) sides - the number of sides present on the die
         * @param - (String) primary - the primary, or main, color present on the die
         * @param - (String) secondary - the secondary color present on the die. Could be None.
         * @param - (String) nums - the color of the numbers on the die
         * @param - (int[]) values - an integer list containing all possible values on the die
         */
        // The following lines assign the passed parameters to the initialized private class variables
        numSides = sides;
        primaryColor = primary;
        secondaryColor = secondary;
        numColor = nums;
        sideValues = values;
    }

    public void setNumSides(int sides) {this.numSides = sides;}
    // Setter method for the private numSides variable
    public void setPrimaryColor(String primary) {this.primaryColor = primary;}
    // Setter method for the private primaryColor variable
    public void setSecondaryColor(String secondary) {this.secondaryColor = secondary;}
    // Setter method for the private secondaryColor variable
    public void setNumColor(String color) {this.numColor = color;}
    // Setter method for the private numColor variable
    public void setSideValues(int[] values) {this.sideValues = values;}
    // Setter method for the private sideValues variable

    public int getNumSides() {return this.numSides;}
    // Getter method for the private numSides variable
    public String getPrimaryColor() {return this.primaryColor;}
    // Getter method for the private primaryColor variable
    public String getSecondaryColor() {return this.secondaryColor;}
    // Getter method for the private secondaryColor variable
    public String getNumColor() {return this.numColor;}
    // Getter method for the private numColor variable
    public int[] getSideValues() {return this.sideValues;}
    // Getter method for the private sideValues variable
    public int roll() {
        // The roll() method generates a random integer in the range of [1, numSides]
        return (int)((this.numSides * Math.random()) + 1);
    }
}
