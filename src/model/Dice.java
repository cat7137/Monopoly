package model;

import java.util.Random;

public class Dice {

    private int numDice;
    private int lastRoll;

    public Dice(int numDice){
        this.numDice = numDice;
        this.lastRoll = 0;
    }


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

    public int getLastRoll(){
        return this.lastRoll;
    }
    
}
