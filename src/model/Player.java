package model;

import java.util.List;

public class Player {
    private String name;
    private int money;
    private List<Tiles> properties;
    private int position;
    private boolean inJail;
    private boolean isBankrupt;

    public Player(String name){
        this.name = name;
        this.money = 1500;
        this.properties = null;
        this.position = 0;
        this.inJail = false;
        this.isBankrupt = false;
    }

    public String getName(){
        return this.name;
    }

    public int getMoney(){
        return this.money;
    }

    public int addMoney(int amount){
        return this.money += amount;
    }

    public int loseMoney(int amount){
        return this.money -= amount;
    }

    public List<Tiles> getProperties(){
        return this.properties;
    }

    public List<Tiles> addProperty(Tiles property){
        properties.add(property);
        return this.properties;
    }

    public List<Tiles> removeProperty(Tiles property){
        for (Tiles prop : properties){
            if (prop.equals(property)){
                properties.remove(prop);
            }
        }
        return properties;
    }

    public int getPosition(){
        return this.position;
    }

    public void move(int moves){
        if ((position += moves) > 39){
            int total = 39 - this.position;
            moves -= total;
            moves -= 1; //for resetting back to zero;
            position = 0;
            position += moves;
        }
        else{
        this.position += moves;
        }
    }

    public void setPosition(int position){
        this.position = position;
    }

    public boolean isInJail(){
        return this.inJail;
    }

    public void setInJail(boolean inJail){
        this.inJail = inJail;
    }

    public boolean isBankrupt(){
        return this.isBankrupt;
    }

    public void setBankrupt(boolean isBankrupt){
        this.isBankrupt = isBankrupt;
    }
     
}
