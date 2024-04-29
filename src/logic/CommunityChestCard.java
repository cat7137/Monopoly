/**
 * CommunityChest Interface
 * Author: Cody Thompson
 * 
 * Contains the methods for CommunityChest cards to use
 */

package logic;

import model.Player;

public interface CommunityChestCard {

    /**
     * Gets the Description of the Card
     * @return the description
     */
    public String getDescription(); 
    /**
     * Completes the card's action
     * @param player
     */
    public void completeAction(Player player);
    
}
