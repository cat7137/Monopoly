/**
 * Advance To Go Card Class
 * implements ChandCard and CommunityChestCard
 * Author: Cody Thompson
 * 
 * 
 * 
 * One of the cards in the Chance or Community Chest decks
 */

package logic;

import model.Player;

public class AdvanceToGoCard implements ChanceCard, CommunityChestCard{

    /**
     * Gets the description of the CC or Chance Card
     */
    @Override
    public String getDescription() {
        return "Advance To Go!";
    }

    /**
     * Completes the Action (Sends the Player to GO)
     */
    @Override
    public void completeAction(Player player) {
        player.setPosition(0);
        player.addMoney(200);
    }
    
}
