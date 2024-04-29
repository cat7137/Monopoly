/**
 * Free Parking Tile Class
 * Author: Cody Thompson
 * 
 * Contains all the methods required for Free Parking tile interactions
 */

package model;

public class FreeParking extends Tiles{

    private int moneyInMiddle;

    /**
     * Free Parking Tile Constructor
     * @param name the name of the tile
     * @param cost the cost of the tile (N/A for Free Parking)
     * @param rent the rent of the tile (N/A for Free Parking)
     * @param mortgage the mortgage of the tile (N/A for Free Parking)
     * @param color the color of the tile (Free Parking for Free Parking)
     */
    public FreeParking(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        moneyInMiddle = 0;
        
    }

    /**
     * Gets the amount of money in the middle of the board
     * @return the amount of money 
     */
    public int getMoneyInMiddle(){
        return this.moneyInMiddle;
    }

    /**
     * Collects the money from the middle of the board
     * @param player the player collecting
     */
    public void collectMoney(Player player){
        player.addMoney(moneyInMiddle);
    }

    /**
     * Set the amount of monet in the middle of the board
     * @param amount the amount added to the middle 
     */
    public void setMoneyInMiddle(int amount){
        this.moneyInMiddle += amount;
    }
    
}
