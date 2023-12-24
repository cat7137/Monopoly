package logic;

import model.Player;

public class GoToJailCard implements ChanceCard, CommunityChestCard {

    @Override
    public String getDescription() {
        return "Go to Jail. Go directly to Jail. Do not pass Go. Do not collect $200.";
    }

    @Override
    public void completeAction(Player player) {
        player.setPosition(9);
        player.setInJail(true);
    }
    
}
