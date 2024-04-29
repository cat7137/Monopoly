/**
 * Lose $100 Card class
 * implements ChanceCard and CommunityChestCard
 * Author: Cody Thompson
 * 
 * One of the cards in the Chance and CommunityChest decks
 */

package logic;

import model.Player;

public class Lose100Card implements ChanceCard, CommunityChestCard{

    /**
     * Gets the card's description
     */
    @Override
    public String getDescription() {
        return "Uh Oh! You've been robbed! Lose $100!";
    }

    /**
     * Takes away $100 from the player
     */
    @Override
    public void completeAction(Player player) {
        player.loseMoney(100);
    }

    
    
} 
