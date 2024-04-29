/**
 * Player class
 * Author: Cody Thompson
 * 
 * represents everything a player has/needs to do
 * 
 */


package model;

import java.util.List;
import java.util.Scanner;

public class Player {
    private String name; 
    private int money; 
    private List<Tiles> properties;
    private int position;
    private boolean inJail;
    private boolean isBankrupt;
    private boolean hasGetOutOfJailFreeCard;

    /**
     * Player Constructor
     * @param name the players name
     * 
     * Starting money is $1500
     * starting position is 0 (Start/GO)
     * No Properties
     * Is not Bankrupt
     * Doesn't have a Get out of Jail Free Card
     * Is not in jail
     */
    public Player(String name){
        this.name = name;
        this.money = 1500;
        this.properties = null;
        this.position = 0;
        this.inJail = false;
        this.isBankrupt = false;
        this.hasGetOutOfJailFreeCard = false;
    }

    /**
     * Get the Player's name
     * @return the name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Gets the amount of money a player has
     * @return money
     */
    public int getMoney(){
        return this.money;
    }

    /**
     * Adds money to the player's balance
     * @param amount the amount to be added
     * @return the player's balance
     */
    public int addMoney(int amount){
        return this.money += amount;
    }

    /**
     * Takes money away from the player's balance
     * @param amount the amount to be taken away 
     * @return the player's balance
     */
    public int loseMoney(int amount){
        return this.money -= amount;
    }

    /**
     * Pays money to another player
     * @param other the other player
     * @param amount the amount to pay 
     */
    public void payMoney(Player other, int amount){
        this.loseMoney(amount);
        other.addMoney(amount);
    }

    /**
     * Gets all the player's properties
     * @return a list of the player's properties 
     */
    public List<Tiles> getProperties(){
        return this.properties;
    }

    /**
     * Adds a property to the player's properties
     * 
     * **might be a void function instead **
     * 
     * @param property the property to be added
     * @return the List of player's properties
     */
    public List<Tiles> addProperty(Tiles property){
        properties.add(property);
        return this.properties;
    }

    /**
     * Removes a propert from the player's properties list
     * 
     * **might be a void function instead**
     * 
     * @param property the property to be removed
     * @return the List of player's properties
     */
    public List<Tiles> removeProperty(Tiles property){
        for (Tiles prop : properties){
            if (prop.equals(property)){
                properties.remove(prop);
            }
        }
        return properties;
    }

    /**
     * Gets the player's current position
     * @return the player's position
     */
    public int getPosition(){
        return this.position;
    }

    /**
     * Moves a player 
     * 
     * If a player is at the end of the board,
     * (position 39), position resets to 0 and rest
     * of dice roll is added to the rest of the movement.
     * 200$ also added to player's bank.
     * 
     * @param moves the dice roll to move
     */
    public void move(int moves){
        if ((position += moves) > 39){
            int total = 39 - this.position;
            moves -= total;
            moves -= 1; //for resetting back to zero;
            System.out.println("Passed Go! Collected $200!");
            this.addMoney(200);
            position = 0;
            position += moves;
        }
        else{
        this.position += moves;
        }
    }

    /**
     * Set's a players position
     * @param position the position to set
     */
    public void setPosition(int position){
        this.position = position;
    }

    /**
     * Checks if a player is in jail 
     * @return true if in jail, false if not
     */
    public boolean isInJail(){
        return this.inJail;
    }

    /**
     * Sets a player's status of injail
     * @param inJail new InJail status
     */
    public void setInJail(boolean inJail){
        this.inJail = inJail;
    }

    /**
     * Checks if a player is Bankrupt
     * @return true if Bankrupt, false otherwise
     */
    public boolean isBankrupt(){
        return this.isBankrupt;
    }

    /**
     * Sets a player's status to Bankrupt
     * @param isBankrupt
     */
    public void setBankrupt(boolean isBankrupt){
        this.isBankrupt = isBankrupt;
    }

    /**
     * Checks if a player has a Get Out of Jail Free Card
     * @return true if they have, false otherwise 
     */
    public boolean hasGetOutOfJailFreeCard(){
        return hasGetOutOfJailFreeCard;
    }

    /**
     * Sets a player's status to has a Get Out of Jail Free Card
     * @param hasCard 
     */
    public void setGetOutOfJailFreeCard(boolean hasCard){
        this.hasGetOutOfJailFreeCard = hasCard;
    }

    /**
     * Accepts or Declines a trade from another player
     * @param player the player that's offering a trade
     * @return true if yes, false if no
     */
    public boolean acceptTrade(Player player){
        System.out.println("Does " + player.getName() + "accept the trade?\nYES\nNO");
        while(true){
            try (Scanner in = new Scanner(System.in)) {
                String answer = in.nextLine();
                answer.toUpperCase();
                if (answer.equals("YES")){
                    return true;
                }
                else if(answer.equals("NO")){
                    return false;
                }
                else{
                    System.out.println("Please enter YES or NO");
                }
            }
        }
        
    }

    /**
     * Offer a trade to another player
     * @param player the current player
     * @param other the other player
     * @param tile the tile to be traded 
     * @param wanted the tile wanted
     */
    public void offerTrade(Player player, Player other, Tiles tile, Tiles wanted){
        System.out.println(player.getName() + " offers to trade " + tile.getName() + " with " + other.getName() + " for " + wanted.getName());
    }

    /**
     * Checks if Player object is equal to another
     */
    @Override
    public boolean equals(Object other){
        boolean result = false;
        if (other instanceof Player) {
            Player p = (Player) other;
            if (this.name.equals(p.name)){
                result = true;
            }
        }
        return result;
    }
     
}
