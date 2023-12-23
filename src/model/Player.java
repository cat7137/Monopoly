package model;

import java.util.List;

public class Player {
    private String name;
    private int money;
    private List<Tiles> properties;
    private int position;

    public Player(String name){
        this.name = name;
        this.money = 1500;
        this.properties = null;
        this.position = 0;
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

     
}
