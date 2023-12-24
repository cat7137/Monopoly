package logic;

import model.Dice;
import model.Player;

public class JailManager{
    
    private static final int MAX_TURNS = 3;
    private int turnsInJail = 0;

    public void rollToLeave(Player player, Dice dice){
        if (player.isInJail() && turnsInJail < MAX_TURNS){
            int roll1 = dice.roll();
            int roll2 = dice.roll();

            if(roll1 == roll2){
                player.setInJail(false);
                player.move(roll1 + roll2);

            }
            else{
                player.setInJail(true);
                turnsInJail ++;
            }
        }

    }

    public void takeTurnInJail(Player player, Dice dice){
        if(turnsInJail == MAX_TURNS){
            payBail(player);
            player.setInJail(false);
        }
        else{
        rollToLeave(player, dice);
        }
    }

    public void payBail(Player player){
        player.loseMoney(50);
    }
}