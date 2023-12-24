package model;

public class GoToJail extends Tiles {


    public GoToJail(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        
    }

    public void sendToJail(Player player){
        player.setInJail(true);
        player.setPosition(9);
    }
    
}
