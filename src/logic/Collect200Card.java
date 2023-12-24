package logic;

import model.Player;

public class Collect200Card implements ChanceCard, CommunityChestCard {

    @Override
    public String getDescription() {
        return "Collect $200!";
    }

    @Override
    public void completeAction(Player player) {
        player.addMoney(200);
    }

    
    
}
