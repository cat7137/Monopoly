package logic;

import model.Player;

public class GetOutOfJailFreeCard implements ChanceCard, CommunityChestCard {

    @Override
    public String getDescription() {
        return "Get Out of Jail Free";
    }

    @Override
    public void completeAction(Player player) {
        player.setInJail(false);
    }

    
    
}
