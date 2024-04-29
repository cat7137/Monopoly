/**
 * Chance Card Interface
 * Author: Cody Thompson
 * 
 * Contains the methods for Chance cards to use
 */

package logic;

import model.Player;

public interface ChanceCard{

    /**
     * Gets the cards description
     * @return
     */
    public String getDescription();
    /**
     * Completes the action of the given card
     * @param player
     */
    public void completeAction(Player player);

}