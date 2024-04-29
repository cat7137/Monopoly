/**
 * Go Tile Class
 * Author: Cody Thompson
 * 
 * Contains all the methods required for Go Tile interactions
 */

package model;

public class Go extends Tiles {

    /**
     * Go Tile constructor
     * @param name the name of the tile 
     * @param cost the cost of the tile (N/A for GO)
     * @param rent the rent of the tile (N/A for GO)
     * @param mortgage the mortgage of the tile (N/A for GO)
     * @param color the color of the tile (GO for GO)
     */
    public Go(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
    }

    /**
     * adds $200 to the player's balance
     * @param player the player 
     */
    public void addMoney(Player player){
        player.addMoney(200);
    }
    
}
