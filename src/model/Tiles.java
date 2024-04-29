/**
 * Tiles Class
 * Author: Cody Thompson
 * 
 * Contains all the methods to represent the Board Tiles
 */

package model;


public class Tiles {
    
    private int cost;
    private int rent;
    private int numHouses;
    private boolean hasHotel;
    private int mortgage;
    private String name;
    private boolean mortgaged;
    private Colors color;
    private Player owner;
    private boolean owned;
    


    /**
     * Tiles constructor
     * @param name name of tile
     * @param cost cost of tile
     * @param rent rent for tile
     * @param mortgage mortgage for tile
     */
    public Tiles(String name, int cost, int rent, int mortgage, Colors color){
        this.name = name;
        this.cost = cost;
        this.rent = rent;
        this.mortgage = mortgage;
        this.numHouses = 0;
        this.hasHotel = false;
        this.mortgaged = false;
        this.color = color;
        this.owner = null;

    }

    /**
     * Gets the cost of the tile
     * @return cost 
     */
    public int getCost(){
        return this.cost;
    }

    /**
     * Gets the rent for the tile
     * @return rent
     */
    public int getRent(){
        return this.rent;
    }

    /**
     * Sets the new rent amount (based on numHouses)
     * @param newRentAmount
     */
    public void setRent(int newRentAmount){
        this.rent = newRentAmount;
    }

    /**
     * Checks to see if the tile has a hotel 
     * @return true if yes or false if no
     */
    public boolean hasHotel(){
        return this.hasHotel;
    }

    /**
     * Sets tiles status to has a hotel
     * @param hasHotel 
     */
    public void setHotel(boolean hasHotel){
        this.hasHotel = hasHotel;
    }

    /**
     * Gets number of houses the tile has
     * @return numHouses
     */
    public int getNumHouses(){
        return this.numHouses;
    }
    /**
     * Sets the number of houses the tile has
     * @param numHouses the number of houses
     */
    public void setNumHouses(int numHouses){
        this.numHouses = numHouses;
    }

    /**
     * Gets the mortgage amount for the tile
     * @return mortgage
     */
    public int getMortgage(){
        return this.mortgage;
    }

    /**
     * Gets the name of the tile
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Checks to see if the tile has been mortgaged
     * @return true if yes or false if no
     */
    public boolean mortgaged(){
        return this.mortgaged;
    }
    /**
     * Sets the tiles status to mortgaged or not mortgaged
     * @param mortgaged true or false
     */
    public void setMortgage(boolean mortgaged){
        this.mortgaged =  mortgaged;

    }

    /**
     * Gets the color of the tile
     * @return color
     */
    public Colors getColor(){
        return this.color;
    }

    /**
     * Sets an owner to the tile
     * @param owner
     */
    public void setOwner(Player owner){
        this.owner = owner;
        this.owned = true;

    }

    /**
     * Gets the owner of the Tile
     * @return
     */
    public Player getOwner(){
        return this.owner;
    }

    /**
     * Checks to see if the tile is owned already or not
     * @return
     */
    public boolean owned(){
        return this.owned;
    }


    /**
     * Checks to see if a tile is equal to another
     */
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj instanceof Tiles){
            Tiles tile = (Tiles) obj;
            if(this.name.equals(tile.name)){
                result = true;
            }
        }
        return result;
    }

    /**
     * String representation of a tile
     */
    @Override
    public String toString() {
        return super.toString();
    }

}