package model;

public class Utility extends Tiles {

    private int oneUtilityRent;
    private int twoUtilityRent;

    public Utility(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        oneUtilityRent = 0;
        twoUtilityRent = 0;
    }

    public void setOneUtilityRent(Dice dice){
        oneUtilityRent = 4 * dice.getLastRoll();
    }

    public int getOneUtilityRent(){
        return oneUtilityRent;
    }

    public void setTwoUtilityRent(Dice dice){
        twoUtilityRent = 10 * dice.getLastRoll();
    }
    
    public int getTwoUtilityRent(){
        return twoUtilityRent;
    }
    
}
