/**
 * Tax Tile Class
 * Author: Cody Thompson
 * 
 * Contains all methods required for Tax Tile Interactions
 */

package model;

public class Tax extends Tiles {


    private int luxuryTax;
    private int incomeTax;

    /**
     * Tax Constructor 
     * @param name the name of the tile
     * @param cost the cost of the tile (N/A for Tax)
     * @param rent the rent of the tile (N/A for Tax)
     * @param mortgage the mortgage of the tile (N/A for Tax)
     * @param color the Color of the tile (Tax for Tax)
     */
    public Tax(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        this.luxuryTax = 100;
        this.incomeTax = 200;
    }

    /**
     * Gets the Luxury Tax amount
     * @return the amount for luxury tax to pay
     */
    public int getLuxuryTax(){
        return this.luxuryTax;
    }

    /**
     * Pays the Luxury Tax
     * @param player the player paying
     */
    public void payLuxuryTax(Player player){
        player.loseMoney(luxuryTax);
    }

    /**
     * Gets the Income Tax amount
     * @return the amount of income tax to pay
     */
    public int getIncomeTax(){
        return this.incomeTax;
    }

    /**
     * Pays the Income Tax
     * @param player the player paying
     */
    public void payIncomeTax(Player player){
        player.loseMoney(incomeTax);
    }

    
    
}
