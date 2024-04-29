/**
 * Lose $50 Card Class
 * implements ChanceCard and CommunityChestCard
 * Author: Cody Thompson
 * 
 * One of the cards in the Chance and CommunityChest decks
 */

package logic;

import model.Player;

public class Lose50Card implements ChanceCard, CommunityChestCard {

    /**
     * Gets the card's description
     */
    @Override
    public String getDescription() {
        return "Petty Tax: Lose $50!";
    }

    /**
     * Takes away $50 from the player
     */
    @Override
    public void completeAction(Player player) {
        player.loseMoney(50);
    }

    
    
}
