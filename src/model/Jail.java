/**
 * The Jail Tile Class
 * Author: Cody Thompson
 * 
 * Contains all the methods required for Jail Tile interactions
 */

package model;

public class Jail extends Tiles{

    /**
     * Jail Tile Constructor
     * @param name the name of the tile
     * @param cost the cost of the tile (N/A for Jail)
     * @param rent the rent of the tile (N/A for Jail)
     * @param mortgage the mortgage of the tile (N/A for Jail)
     * @param color the color of the tile (Jail for Jail)
     */
    public Jail(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
    
    }

    /**
     * Just Visiting!
     */
    public void justVisiting(){
        System.out.println("Just Visiting!");
    }
    
}
