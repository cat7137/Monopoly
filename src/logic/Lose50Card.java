package logic;

import model.Player;

public class Lose50Card implements ChanceCard, CommunityChestCard {

    @Override
    public String getDescription() {
        return "Petty Tax: Lose $50!";
    }

    @Override
    public void completeAction(Player player) {
        player.loseMoney(50);
    }

    
    
}
