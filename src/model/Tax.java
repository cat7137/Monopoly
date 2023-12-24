package model;

public class Tax extends Tiles {


    private int luxuryTax;
    private int incomeTax;

    public Tax(String name, int cost, int rent, int mortgage, Colors color) {
        super(name, cost, rent, mortgage, color);
        this.luxuryTax = 100;
        this.incomeTax = 200;
    }

    public int getLuxuryTax(){
        return this.luxuryTax;
    }

    public void payLuxuryTax(Player player){
        player.loseMoney(luxuryTax);
    }

    public int getIncomeTax(){
        return this.incomeTax;
    }

    public void payIncomeTax(Player player){
        player.loseMoney(incomeTax);
    }

    
    
}
