package logic;

import model.Player;

public class Collect50Card implements ChanceCard, CommunityChestCard{

    @Override
    public String getDescription() {
        return "Collect $50!";
    }

    @Override
    public void completeAction(Player player) {
        player.addMoney(50);
    }

    
    
}
