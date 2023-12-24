package logic;

import model.Player;

public interface ChanceCard{

    public String getDescription();
    public void completeAction(Player player);

}