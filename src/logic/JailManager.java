/**
 * Jail Manager Class
 * Author: Cody Thompson
 * 
 * Handles all the Jail Logic
 * 
 */


package logic;

import model.Dice;
import model.Player;

public class JailManager{
    
    private static final int MAX_TURNS = 3;
    private int turnsInJail = 0;


    /**
     * Roll to Leave Jail
     * 
     * IF a player rolls to leave jail, checks for doubles
     * if doubles are rolled, the player's jail status is 
     * set to false, otherwise still set to true
     * 
     * @param player the player in jail
     * @param dice the dice to be rolled
     */
    public void rollToLeave(Player player, Dice dice){
        if (player.isInJail() && turnsInJail < MAX_TURNS){
            int roll1 = dice.roll();
            int roll2 = dice.roll();

            if(roll1 == roll2){
                player.setInJail(false);
                player.move(roll1 + roll2);

            }
            else{
                player.setInJail(true);
                turnsInJail ++;
            }
        }

    }

    /**
     * Use a Get Out of Jail Free Card
     * 
     * If a player has a Get Out of Jail Free Card
     * and chooses to use it, their jail status is set to false
     * and their GetOutOfJailFreeCard status is set to False
     * 
     * @param player
     */
    public void useGetOutOfJailFreeCard(Player player){
        if (player.hasGetOutOfJailFreeCard()){
            player.setInJail(false);
            player.setGetOutOfJailFreeCard(false);
        }
        else{
            System.out.println("You don't have a get out of jail free card!");
        }
    }

    /**
     * Takes a player's turn in jail
     * 
     * If a player is in jail for more than three turns,
     * they pail bail and their jail status is set to false.
     * Otherwise, they can roll to leave.
     * 
     */
    public void takeTurnInJail(Player player, Dice dice){
        if(turnsInJail == MAX_TURNS){
            payBail(player);
            player.setInJail(false);
        }
        else{
        rollToLeave(player, dice);
        }
    }

    /**
     * Player pays the bail to get out of jail
     * @param player the player paying bail
     */
    public void payBail(Player player){
        player.loseMoney(50);
    }
}