/**
 * Get Out of Jail Free Card Class
 * implements ChanceCard and CommunityChestCard
 * Author: Cody Thompson
 * 
 * One of the cards in the Chance or Community Chest decks
 */

package logic;

import model.Player;

public class GetOutOfJailFreeCard implements ChanceCard, CommunityChestCard {

    /**
     * Gets the card's description
     */
    @Override
    public String getDescription() {
        return "Get Out of Jail Free";
    }

    /**
     * Gives the player a Get Out of Jail Free card
     */
    @Override
    public void completeAction(Player player) {
        player.setGetOutOfJailFreeCard(true); 
    }

    
    
}
