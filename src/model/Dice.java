/**
 * Dice class
 * Author: Cody Thompson
 * 
 * Contains all the methods for needed for dice  
 */

package model;

import java.util.Random;

public class Dice {

    private int numDice;
    private int lastRoll;

    /**
     * Dice constructor
     * @param numDice the number of dice (2)
     */
    public Dice(int numDice){
        this.numDice = numDice;
        this.lastRoll = 0;
    }


    /**
     * Rolls the dice
     * @return the number from the dice roll
     */
    public int roll(){
        Random randomNum = new Random();
        int total = 0;
        for(int i = 0; i < numDice; i++){
            int die = randomNum.nextInt(6) + 1;
            total += die;
        }
        lastRoll = total;
        return total;
    }

    /**
     * Gets the last Dice Roll 
     * @return the number from the Last Dice Roll
     */
    public int getLastRoll(){
        return this.lastRoll;
    }
    
}
