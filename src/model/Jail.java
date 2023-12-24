package model;

public class Jail extends Tiles{

    public Jail(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
    
    }

    public void justVisiting(){
        System.out.println("Just Visiting!");
    }
    
}
