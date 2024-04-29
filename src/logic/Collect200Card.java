/**
 * Collect $200 Card Class
 * implements ChanceCard and CommunityChestCard
 * Author: Cody Thompson
 * 
 * One of the cards in the Chance or CommunityChest decks
 */

package logic;

import model.Player;

public class Collect200Card implements ChanceCard, CommunityChestCard {

    /**
     * Gets the card's description
     */
    @Override
    public String getDescription() {
        return "Collect $200!";
    }

    /**
     * Gives the player $200
     */
    @Override
    public void completeAction(Player player) {
        player.addMoney(200);
    }

    
    
}
