/**
 * Go To Jail Tile Class
 * Author: Cody Thompson
 * 
 * Contains all the methods required for Go to Jail Tile interactions
 */

package model;

public class GoToJail extends Tiles {


    /**
     * Go to Jail Tile Constructor 
     * @param name the name of the tile
     * @param cost the cost of the tile (N/A for GoToJail)
     * @param rent the rent of the tile (N/A for GoToJail)
     * @param mortgage the mortgage of the tile (N/A for GoToJail)
     * @param color the color of the tile (GoToJail for GoToJail)
     */
    public GoToJail(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        
    }

    /**
     * Send a player to jail
     * @param player the player that landed on the tile
     */
    public void sendToJail(Player player){
        player.setInJail(true);
        player.setPosition(9);
    }
    
}
