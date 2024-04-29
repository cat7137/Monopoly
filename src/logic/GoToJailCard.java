/**
 * Go to Jail Card Class
 * implements ChanceCard and CommunityChestCard
 * Author: Cody Thompson
 * 
 * One of the cards in the Chance or Community Chest decks
 */

package logic;

import model.Player;

public class GoToJailCard implements ChanceCard, CommunityChestCard {

    /**
     * Gets the card's description
     */
    @Override
    public String getDescription() {
        return "Go to Jail. Go directly to Jail. Do not pass Go. Do not collect $200.";
    }

    /**
     * sends a player to jail
     */
    @Override
    public void completeAction(Player player) {
        player.setPosition(9);
        player.setInJail(true);
    }
    
}
