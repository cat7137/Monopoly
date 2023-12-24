package logic;

import model.Player;

public class AdvanceToGoCard implements ChanceCard, CommunityChestCard{

    @Override
    public String getDescription() {
        return "Advance To Go!";
    }

    @Override
    public void completeAction(Player player) {
        player.setPosition(0);
        player.addMoney(200);
    }
    
}
