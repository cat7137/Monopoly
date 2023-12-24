package model;

public class FreeParking extends Tiles{

    private int moneyInMiddle;

    public FreeParking(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        moneyInMiddle = 0;
        
    }

    public int getMoneyInMiddle(){
        return this.moneyInMiddle;
    }

    public void collectMoney(Player player){
        player.addMoney(moneyInMiddle);
    }

    public void setMoneyInMiddle(int amount){
        this.moneyInMiddle += amount;
    }
    
}
