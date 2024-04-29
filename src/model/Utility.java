/**
 * Utility Tile Class
 * Author: Cody Thompson
 * 
 * Contains all the methods required for Utility interactions
 */

package model;

public class Utility extends Tiles {

    private int oneUtilityRent;
    private int twoUtilityRent;

    /**
     * Utility Constructor
     * @param name the name of the tile
     * @param cost the cost of the tile
     * @param rent the rent for the tile 
     * @param mortgage the mortgage for the tile
     * @param color the color of the tile
     */
    public Utility(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        oneUtilityRent = 0;
        twoUtilityRent = 0;
    }

    /**
     * Sets the rent for a player with one utility
     * @param dice the dice roll to determint the rent
     */
    public void setOneUtilityRent(Dice dice){
        oneUtilityRent = 4 * dice.getLastRoll();
    }

    /**
     * Gets the rent for one utility
     * @return the rent to pay for one Utility
     */
    public int getOneUtilityRent(){
        return oneUtilityRent;
    }

    /**
     * Sets the rent for a player with two utilites 
     * @param dice the dice roll to determine the rent
     */
    public void setTwoUtilityRent(Dice dice){
        twoUtilityRent = 10 * dice.getLastRoll();
    }
    
    /**
     * Gets the rent for two utilities
     * @return the rent to pay for two utilities 
     */
    public int getTwoUtilityRent(){
        return twoUtilityRent;
    }
    
}
