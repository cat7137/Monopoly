package logic;

import model.Player;

public class Lose100Card implements ChanceCard, CommunityChestCard{

    @Override
    public String getDescription() {
        return "Uh Oh! You've been robbed! Lose $100!";
    }

    @Override
    public void completeAction(Player player) {
        player.loseMoney(100);
    }

    
    
} 
