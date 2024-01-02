package model;

public class Go extends Tiles {

    public Go(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
    }

    public void addMoney(Player player){
        player.addMoney(200);
    }
    
}
